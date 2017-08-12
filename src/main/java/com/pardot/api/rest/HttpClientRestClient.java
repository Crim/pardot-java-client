package com.pardot.api.rest;

import com.pardot.api.Configuration;
import com.pardot.api.request.Request;
import com.pardot.api.request.campaign.CampaignQueryRequest;
import com.pardot.api.request.campaign.CampaignReadRequest;
import com.pardot.api.request.user.UserAbilitiesRequest;
import com.pardot.api.request.user.UserQueryRequest;
import com.pardot.api.request.user.UserReadRequest;
import com.pardot.api.response.LoginResponse;
import com.pardot.api.response.campaign.Campaign;
import com.pardot.api.response.campaign.CampaignQueryResponse;
import com.pardot.api.response.user.User;
import com.pardot.api.response.user.UserAbilitiesResponse;
import com.pardot.api.response.user.UserQueryResponse;
import com.pardot.api.rest.handlers.LoginResponseHandler;
import com.pardot.api.rest.handlers.StringResponseHandler;
import com.pardot.api.rest.handlers.campaign.CampaignQueryResponseHandler;
import com.pardot.api.rest.handlers.campaign.CampaignReadResponseHandler;
import com.pardot.api.rest.handlers.user.UserAbilitiesHandler;
import com.pardot.api.rest.handlers.user.UserQueryResponseHandler;
import com.pardot.api.rest.handlers.user.UserReadResponseHandler;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * RestClient implementation using HTTPClient.
 */
public class HttpClientRestClient implements RestClient {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientRestClient.class);

    /**
     * Save a copy of the configuration.
     */
    private Configuration configuration;

    /**
     * The user's api Key.
     */
    private String apiKey = null;

    /**
     * Our underlying Http Client.
     */
    private CloseableHttpClient httpClient;


    /**
     * Constructor.
     */
    public HttpClientRestClient() {

    }

    /**
     * Initialization method.  This takes in the configuration and sets up the underlying
     * http client appropriately.
     * @param configuration The user defined configuration.
     */
    @Override
    public void init(final Configuration configuration) {
        // Save reference to configuration
        this.configuration = configuration;

        // Create default SSLContext
        final SSLContext sslcontext = SSLContexts.createDefault();

        // Allow TLSv1 protocol only
        final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
            sslcontext,
            new String[] { "TLSv1" },
            null,
            SSLConnectionSocketFactory.getDefaultHostnameVerifier()
        );

        // Setup client builder
        final HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder
            // Pardot disconnects requests after 120 seconds.
            .setConnectionTimeToLive(130, TimeUnit.SECONDS)
            .setSSLSocketFactory(sslsf);

        // Define our RequestConfigBuilder
        final RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();

        // If we have a configured proxy host
        if (configuration.getProxyHost() != null) {
            // Define proxy host
            final HttpHost proxyHost = new HttpHost(
                configuration.getProxyHost(),
                configuration.getProxyPort(),
                configuration.getProxyScheme()
            );

            // If we have proxy auth enabled
            if (configuration.getProxyUsername() != null) {
                // Create credential provider
                final CredentialsProvider credsProvider = new BasicCredentialsProvider();
                credsProvider.setCredentials(
                    new AuthScope(configuration.getProxyHost(), configuration.getProxyPort()),
                    new UsernamePasswordCredentials(configuration.getProxyUsername(), configuration.getProxyPassword())
                );

                // Attach Credentials provider to client builder.
                clientBuilder.setDefaultCredentialsProvider(credsProvider);
            }

            // Attach Proxy to request config builder
            requestConfigBuilder.setProxy(proxyHost);
        }

        // Attach default request config
        clientBuilder.setDefaultRequestConfig(requestConfigBuilder.build());

        // build http client
        httpClient = clientBuilder.build();
    }

    /**
     * Test method for now.  Does a GET request.
     */
    String get(final String url) throws IOException {
        try {
            final HttpGet httpget = new HttpGet(url);
            logger.info("Executing request {}", httpget.getRequestLine());

            // Execute
            final String response = httpClient.execute(httpget, new StringResponseHandler());
            logger.info("Response: {}", response);

            // Return response as a string
            return response;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return null;
    }

    /**
     * Test POST method for now.
     * @param url Url to POST to.
     * @param postParams Any POST parameters to include
     * @return String representation of response.
     */
    String post(final String url, Map<String, String> postParams) throws IOException {
        return post(url, postParams, new StringResponseHandler());
    }

    <T> T post(final Request request, final ResponseHandler<T> responseHandler) throws IOException {
        final String url = constructApiUrl(request.getApiEndpoint());
        return post(url, request.getRequestParameters(), responseHandler);
    }

    /**
     * Internal POST method.
     * @param url Url to POST to.
     * @param postParams Any POST parameters to include
     * @param responseHandler The response Handler to use to parse the response
     * @param <T> The type that ResponseHandler returns.
     * @return Parsed response.
     */
    <T> T post(final String url, Map<String, String> postParams, final ResponseHandler<T> responseHandler) throws IOException {
        // Ensure we're authenticated.
        if (!(responseHandler instanceof LoginResponseHandler)) {
            // Attempt to login
            loginCheck();
        }

        try {
            final HttpPost post = new HttpPost(url);

            // Define required auth params
            final List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("user_key", configuration.getUserKey()));
            if (apiKey != null) {
                params.add(new BasicNameValuePair("api_key", apiKey));
            }

            // Attach post params
            for (Map.Entry<String, String> entry : postParams.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            post.setEntity(new UrlEncodedFormEntity(params));

            logger.info("Executing request {} with {}", post.getRequestLine(), params);

            // Execute
            final T response = httpClient.execute(post, responseHandler);
            logger.info("Response: {}", response);

            // Return response as a string
            return response;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Only close at end
            //httpClient.close();
        }
        return null;
    }

    private void loginCheck() {
        // If we have an api key
        if (apiKey != null) {
            // All good
            return;
        }

        // Otherwise auth
        authenticate();

        // If we still have no api key
        if (apiKey == null) {
            // Toss exception
            throw new RuntimeException("Unable to authenticate!");
        }
    }

    /**
     * Make login request
     * @return LoginResponse returned from server.
     */
    public LoginResponse authenticate() {
        final String url = constructApiUrl("login");
        Map<String, String> params = new HashMap<>();
        params.put("email", configuration.getEmail());
        params.put("password", configuration.getPassword());

        try {
            final LoginResponse loginResponse = post(url, params, new LoginResponseHandler());

            if (loginResponse != null) {
                // Save apiKey
                apiKey = loginResponse.getApiKey();
            }
            return loginResponse;
        } catch (Exception e) {
            logger.error("Failed to Authenticate: {}", e.getMessage(), e);
        }
        return null;
    }

    public UserQueryResponse.Result userQuery(final UserQueryRequest userQueryRequest) throws IOException {
        return post(userQueryRequest, new UserQueryResponseHandler());
    }

    public UserAbilitiesResponse.Result userAbilities(final UserAbilitiesRequest userAbilitiesRequest) throws IOException {
        return post(userAbilitiesRequest, new UserAbilitiesHandler());
    }

    public User userRead(final UserReadRequest readRequest) throws IOException {
        return post(readRequest, new UserReadResponseHandler());
    }

    public CampaignQueryResponse.Result campaignQuery(final CampaignQueryRequest request) throws IOException {
        return post(request, new CampaignQueryResponseHandler());
    }

    public Campaign campaignRead(final CampaignReadRequest request) throws IOException {
        return post(request, new CampaignReadResponseHandler());
    }

    /**
     * Internal helper method for generating URLs w/ the appropriate API host and API version.
     * @param endPoint The end point you want to hit.
     * @return Constructed URL for the end point.
     */
    private String constructApiUrl(final String endPoint) {
        return configuration.getPardotApiHost()
            + "/" + endPoint
            + "/version/"
            + configuration.getPardotApiVersion();
    }
}
