package com.darksci.pardot.api;

import com.darksci.pardot.api.parser.ErrorResponseParser;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.parser.account.AccountReadResponseParser;
import com.darksci.pardot.api.parser.campaign.CampaignQueryResponseParser;
import com.darksci.pardot.api.parser.campaign.CampaignReadResponseParser;
import com.darksci.pardot.api.parser.email.EmailReadResponseParser;
import com.darksci.pardot.api.parser.email.EmailStatsResponseParser;
import com.darksci.pardot.api.parser.login.LoginResponseParser;
import com.darksci.pardot.api.parser.user.UserAbilitiesParser;
import com.darksci.pardot.api.parser.user.UserQueryResponseParser;
import com.darksci.pardot.api.parser.user.UserReadResponseParser;
import com.darksci.pardot.api.request.Request;
import com.darksci.pardot.api.request.account.AccountReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignCreateRequest;
import com.darksci.pardot.api.request.campaign.CampaignQueryRequest;
import com.darksci.pardot.api.request.campaign.CampaignReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignUpdateRequest;
import com.darksci.pardot.api.request.email.EmailReadRequest;
import com.darksci.pardot.api.request.email.EmailSendListRequest;
import com.darksci.pardot.api.request.email.EmailSendOneToOneRequest;
import com.darksci.pardot.api.request.email.EmailStatsRequest;
import com.darksci.pardot.api.request.login.LoginRequest;
import com.darksci.pardot.api.request.user.UserAbilitiesRequest;
import com.darksci.pardot.api.request.user.UserQueryRequest;
import com.darksci.pardot.api.request.user.UserReadRequest;
import com.darksci.pardot.api.response.ErrorResponse;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.response.email.Email;
import com.darksci.pardot.api.response.email.EmailStatsResponse;
import com.darksci.pardot.api.response.login.LoginResponse;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import com.darksci.pardot.api.response.user.UserQueryResponse;
import com.darksci.pardot.api.rest.HttpClientRestClient;
import com.darksci.pardot.api.rest.RestClient;
import com.darksci.pardot.api.rest.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Interface for Pardot's API.
 */
public class PardotClient implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(PardotClient.class);

    /**
     * Our API Configuration.
     */
    private final Configuration configuration;

    /**
     * Underlying RestClient to use.
     */
    private final RestClient restClient;

    /**
     * Internal State flag.
     */
    private boolean isInitialized = false;

    /**
     * Default Constructor.
     * @param configuration Pardot Api Configuration.
     */
    public PardotClient(final Configuration configuration) {
        this.configuration = configuration;
        this.restClient = new HttpClientRestClient();
    }

    /**
     * Constructor for injecting a RestClient implementation.
     * Typically only used in testing.
     * @param configuration Pardot Api Configuration.
     * @param restClient RestClient implementation to use.
     */
    public PardotClient(final Configuration configuration, final RestClient restClient) {
        this.configuration = configuration;
        this.restClient = restClient;
    }

    private <T> T submitRequest(final Request request, ResponseParser<T> responseParser) throws IOException {
        // Ugly hack,
        // avoid doing login check if we're doing a login request.
        if (!(request instanceof LoginRequest)) {
            // Check for auth token
            checkLogin();
        }

        // Submit request
        final RestResponse restResponse = getRestClient().submitRequest(request);

        // If we have a valid response
        logger.info("Response: {}", restResponse);

        // Check for invalid http status codes
        if (restResponse.getHttpCode() >= 200 && restResponse.getHttpCode() < 300) {
            // High level check for error response
            if (restResponse.getResponseStr().contains("<rsp stat=\"fail\"")) {
                // Parse error response
                final ErrorResponse error = new ErrorResponseParser().parseResponse(restResponse.getResponseStr());

                // throw exception
                throw new InvalidRequestException(error.getMessage(), error.getCode());
            }
            return responseParser.parseResponse(restResponse.getResponseStr());
        }
        // Otherwise throw an exception.
        throw new InvalidRequestException("Invalid http response code from server: " + restResponse.getHttpCode(), restResponse.getHttpCode());
    }

    /**
     * @return Return Pardot API Configuration.
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Package protected for access in tests.
     * @return Rest Client.
     */
    RestClient getRestClient() {
        // If we haven't initialized.
        if (!isInitialized) {
            // Call Init.
            restClient.init(getConfiguration());

            // Flip state flag
            isInitialized = true;
        }

        // return our rest client.
        return restClient;
    }

    /**
     * Check to see if we're already logged in and have an API key.
     * If no existing API key is found, this will attempt to authenticate and
     * get a new API key.
     */
    private void checkLogin() throws IOException {
        if (configuration.getApiKey() != null) {
            return;
        }
        // Otherwise attempt to authenticate.
        final LoginResponse response = login(new LoginRequest()
            .withEmail(configuration.getEmail())
            .withPassword(configuration.getPassword())
        );

        // If we have an API key.
        if (response.getApiKey() != null) {
            // Set it.
            getConfiguration().setApiKey(response.getApiKey());
        }
    }

    /**
     * Make login request
     * @return LoginResponse returned from server.
     */
    public LoginResponse login(LoginRequest request) throws IOException {
        return submitRequest(request, new LoginResponseParser());
    }

    /**
     * Make API request to read the account of the currently authenticated user.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public Account accountRead(final AccountReadRequest request) throws IOException {
        return submitRequest(request, new AccountReadResponseParser());
    }

    /**
     * Make API request to query one or more users.
     * @param request Request definition.
     * @return Parsed user query response.
     * @throws IOException on parse errors.
     */
    public UserQueryResponse.Result userQuery(final UserQueryRequest request) throws IOException {
        return submitRequest(request, new UserQueryResponseParser());
    }

    /**
     * Make API request to read the abilities of the currently authenticated user.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public UserAbilitiesResponse.Result userAbilities(final UserAbilitiesRequest request) throws IOException {
        return submitRequest(request, new UserAbilitiesParser());
    }

    /**
     * Make API request to read a specific user.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public User userRead(final UserReadRequest request) throws IOException {
        return submitRequest(request, new UserReadResponseParser());
    }

    /**
     * Make API request to query for one or more campaigns.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public CampaignQueryResponse.Result campaignQuery(final CampaignQueryRequest request) throws IOException {
        return submitRequest(request, new CampaignQueryResponseParser());
    }

    /**
     * Make API request to read a specific campaign.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public Campaign campaignRead(final CampaignReadRequest request) throws IOException {
        return submitRequest(request, new CampaignReadResponseParser());
    }

    /**
     * Make API request to create a new Campaign.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public Campaign campaignCreate(final CampaignCreateRequest request) throws IOException {
        return submitRequest(request, new CampaignReadResponseParser());
    }

    /**
     * Make API request to update an existing Campaign.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public Campaign campaignUpdate(final CampaignUpdateRequest request) throws IOException {
        return submitRequest(request, new CampaignReadResponseParser());
    }

    /**
     * Make API request to read a specific Email.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public Email emailRead(final EmailReadRequest request) throws IOException {
        return submitRequest(request, new EmailReadResponseParser());
    }

    /**
     * Make API request to retrieve stats about a List Email Send.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public EmailStatsResponse.Stats emailStats(final EmailStatsRequest request) throws IOException {
        return submitRequest(request, new EmailStatsResponseParser());
    }

    /**
     * Make API request to send a 1-to-1 prospect email.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public Email emailSendOneToOne(final EmailSendOneToOneRequest request) throws IOException {
        return submitRequest(request, new EmailReadResponseParser());
    }

    /**
     * Make API request to send a list email.
     * @param request Request definition.
     * @return Parsed api response.
     * @throws IOException on parse errors.
     */
    public Email emailSendList(final EmailSendListRequest request) throws IOException {
        return submitRequest(request, new EmailReadResponseParser());
    }

    /**
     * Clean up instance, releasing any resources held internally.
     */
    public void close() {
        getRestClient().close();
    }
}