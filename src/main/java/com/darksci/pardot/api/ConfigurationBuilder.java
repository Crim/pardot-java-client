/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.darksci.pardot.api;

import com.darksci.pardot.api.auth.AuthorizationServer;
import com.darksci.pardot.api.auth.PasswordSessionRefreshHandler;
import com.darksci.pardot.api.auth.SessionRefreshHandler;
import com.darksci.pardot.api.auth.SsoAccessTokenSessionRefreshHandler;
import com.darksci.pardot.api.auth.SsoRefreshTokenSessionRefreshHandler;
import com.darksci.pardot.api.auth.SsoSessionRefreshHandler;
import com.darksci.pardot.api.config.Configuration;
import com.darksci.pardot.api.config.PasswordLoginCredentials;
import com.darksci.pardot.api.config.ProxyConfiguration;
import com.darksci.pardot.api.config.SsoAccessTokenCredentials;
import com.darksci.pardot.api.config.SsoLoginCredentials;
import com.darksci.pardot.api.config.SsoRefreshTokenCredentials;
import com.darksci.pardot.api.rest.interceptor.NoopRequestInterceptor;
import com.darksci.pardot.api.rest.interceptor.RequestInterceptor;

import java.util.Objects;

/**
 * Pardot API Client Configuration Builder.
 * Used to construct {@link Configuration} instances.
 */
public class ConfigurationBuilder {
    // Authentication handler
    private SessionRefreshHandler sessionRefreshHandler = null;

    // Optional Proxy Configuration
    private String proxyHost = null;
    private int proxyPort = 0;
    private String proxyScheme = "HTTP";

    // Optional Proxy Authentication.
    private String proxyUsername = null;
    private String proxyPassword = null;

    // If you want to override the Pardot API url or version.
    private String pardotApiHost = "https://pi.pardot.com/api";
    private String pardotApiVersion = "3";

    // Optional setting to skip validating Pardot's SSL certificate.
    private boolean ignoreInvalidSslCertificates = false;

    // Optional interface to allow for modifying the outbound Http Post request prior to sending it.
    private RequestInterceptor requestInterceptor = new NoopRequestInterceptor();

    /**
     * For configuring authenticating to the Pardot API using legacy Username, Password, and UserKey values.
     *
     * @param username Pardot user's email address or username.
     * @param password Pardot user's password.
     * @param userKey Pardot user's userKey.
     * @return Builder instance.
     * @deprecated Pardot is removing Username and Password authentication, replacing it with
     *             Salesforce SSO Authentication: {@link ConfigurationBuilder#withSsoLogin}
     */
    public ConfigurationBuilder withUsernameAndPasswordLogin(final String username, final String password, final String userKey) {
        return withCustomAuthenticationHandler(new PasswordSessionRefreshHandler(
            new PasswordLoginCredentials(Objects.requireNonNull(username), Objects.requireNonNull(password), Objects.requireNonNull(userKey))
        ));
    }

    /**
     * For configuring authenticating to the Pardot API using the password OAuth2 authentication flow.
     *
     * @param username Salesforce username.
     * @param password Salesforce user's password.
     * @param clientId Connected Application client or consumer Id.
     * @param clientSecret Connected Application client or consumer secret.
     * @param businessUnitId Id of the Pardot business unit to connect to.
     * @return Builder instance.
     */
    public ConfigurationBuilder withSsoLogin(final String username, final String password, final String clientId, final String clientSecret, final String businessUnitId) {
        return withCustomAuthenticationHandler(new SsoSessionRefreshHandler(new SsoLoginCredentials(
            Objects.requireNonNull(username),
            Objects.requireNonNull(password),
            Objects.requireNonNull(clientId),
            Objects.requireNonNull(clientSecret),
            Objects.requireNonNull(businessUnitId)
        ), AuthorizationServer.DEFAULT_SALESFORCE));
    }

    /**
     * For configuring authenticating to the Pardot API using the password OAuth2 authentication flow.
     *
     * @param username Salesforce username.
     * @param password Salesforce user's password.
     * @param clientId Connected Application client or consumer Id.
     * @param clientSecret Connected Application client or consumer secret.
     * @param businessUnitId Id of the Pardot business unit to connect to.
     * @param authorizationServer Override the authorization server address.
     * @return Builder instance.
     */
    public ConfigurationBuilder withSsoLogin(final String username, final String password, final String clientId, final String clientSecret, final String businessUnitId, final AuthorizationServer authorizationServer) {
        return withCustomAuthenticationHandler(new SsoSessionRefreshHandler(new SsoLoginCredentials(
            Objects.requireNonNull(username),
            Objects.requireNonNull(password),
            Objects.requireNonNull(clientId),
            Objects.requireNonNull(clientSecret),
            Objects.requireNonNull(businessUnitId)
        ), authorizationServer));
    }

    /**
     * For configuring authenticating to the Pardot API using a previously acquired refresh_token acquired using
     * the access_code OAuth2 authentication flow.
     *
     * @param refreshToken Salesforce refresh_token.
     * @param clientId Connected Application client or consumer Id.
     * @param clientSecret Connected Application client or consumer secret.
     * @param businessUnitId Id of the Pardot business unit to connect to.
     * @return Builder instance.
     */
    public ConfigurationBuilder withSsoRefreshTokenLogin(final String refreshToken, final String clientId, final String clientSecret, final String businessUnitId) {
        return withCustomAuthenticationHandler(new SsoRefreshTokenSessionRefreshHandler(new SsoRefreshTokenCredentials(
            Objects.requireNonNull(refreshToken),
            Objects.requireNonNull(clientId),
            Objects.requireNonNull(clientSecret),
            Objects.requireNonNull(businessUnitId)
        ), AuthorizationServer.DEFAULT_SALESFORCE));
    }

    /**
     * For configuring authenticating to the Pardot API using a refresh_token acquired using
     * the access_code oauth2 authentication flow.
     *
     * @param refreshToken Salesforce refresh_token.
     * @param clientId Connected Application client or consumer Id.
     * @param clientSecret Connected Application client or consumer secret.
     * @param businessUnitId Id of the Pardot business unit to connect to.
     * @param authorizationServer Override the authorization server address.
     * @return Builder instance.
     */
    public ConfigurationBuilder withSsoRefreshTokenLogin(final String refreshToken, final String clientId, final String clientSecret, final String businessUnitId, final AuthorizationServer authorizationServer) {
        return withCustomAuthenticationHandler(new SsoRefreshTokenSessionRefreshHandler(new SsoRefreshTokenCredentials(
            Objects.requireNonNull(refreshToken),
            Objects.requireNonNull(clientId),
            Objects.requireNonNull(clientSecret),
            Objects.requireNonNull(businessUnitId)
        ), authorizationServer));
    }

    /**
     * For configuring authenticating to the Pardot API using a previously acquired access_token acquired using
     * the access_code OAuth2 authentication flow.
     *
     * Note this authentication scheme has no provisions for renewing expired sessions automatically.
     * See withSsoRefreshTokenLogin() method using a refresh_token.
     *
     * @param accessToken Salesforce access_token.
     * @param clientId Connected Application client or consumer Id.
     * @param clientSecret Connected Application client or consumer secret.
     * @param businessUnitId Id of the Pardot business unit to connect to.
     * @return Builder instance.
     */
    public ConfigurationBuilder withSsoAccessTokenLogin(final String accessToken, final String clientId, final String clientSecret, final String businessUnitId) {
        return withCustomAuthenticationHandler(new SsoAccessTokenSessionRefreshHandler(new SsoAccessTokenCredentials(
            Objects.requireNonNull(accessToken),
            Objects.requireNonNull(clientId),
            Objects.requireNonNull(clientSecret),
            Objects.requireNonNull(businessUnitId)
        )));
    }

    /**
     * Allows for injecting a custom {@link SessionRefreshHandler} implementation.
     * @param sessionRefreshHandler Interface for handling authentication to Pardot API.
     * @return Builder instance.
     */
    public ConfigurationBuilder withCustomAuthenticationHandler(final SessionRefreshHandler sessionRefreshHandler) {
        this.sessionRefreshHandler = Objects.requireNonNull(sessionRefreshHandler);
        return this;
    }

    /**
     * Allow setting optional proxy configuration over HTTP.
     *
     * @param proxyHost Host for the proxy to use.
     * @param proxyPort Post for the proxy to use.
     * @return Configuration instance.
     */
    public ConfigurationBuilder withProxyHttp(final String proxyHost, final int proxyPort) {
        return withProxy(proxyHost, proxyPort, "HTTP");
    }

    /**
     * Allow setting optional proxy configuration over HTTPS.
     *
     * @param proxyHost Host for the proxy to use.
     * @param proxyPort Post for the proxy to use.
     * @return Configuration instance.
     */
    public ConfigurationBuilder withProxyHttps(final String proxyHost, final int proxyPort) {
        return withProxy(proxyHost, proxyPort, "HTTPS");
    }

    /**
     * Allow setting optional proxy configuration.
     *
     * @param proxyHost Host for the proxy to use.
     * @param proxyPort Post for the proxy to use.
     * @param proxyScheme Scheme to use, HTTP/HTTPS
     * @return Builder instance.
     */
    public ConfigurationBuilder withProxy(final String proxyHost, final int proxyPort, final String proxyScheme) {
        this.proxyHost = Objects.requireNonNull(proxyHost);
        this.proxyPort = proxyPort;
        this.proxyScheme = Objects.requireNonNull(proxyScheme);
        return this;
    }

    /**
     * Allow setting credentials for a proxy that requires authentication.
     *
     * @param proxyUsername Username for proxy.
     * @param proxyPassword Password for proxy.
     * @return Builder instance.
     */
    public ConfigurationBuilder useProxyAuthentication(final String proxyUsername, final String proxyPassword) {
        this.proxyUsername = proxyUsername;
        this.proxyPassword = proxyPassword;
        return this;
    }

    /**
     * Sets default Production Pardot API Host of https://pi.pardot.com/api
     *
     * @return Builder instance.
     */
    public ConfigurationBuilder withProductionApiHost() {
        return withPardotApiHost("https://pi.pardot.com/api");
    }

    /**
     * Sets default Demo Pardot API Host of https://pi.pardot.com/api
     *
     * @return Builder instance.
     */
    public ConfigurationBuilder withDemoApiHost() {
        return withPardotApiHost("https://pi.demo.pardot.com/api");
    }

    /**
     * Allows for overriding the Pardot Api hostname.
     *
     * @param pardotApiHost the Pardot API hostname to use.
     * @return Builder instance.
     */
    public ConfigurationBuilder withPardotApiHost(final String pardotApiHost) {
        this.pardotApiHost = Objects.requireNonNull(pardotApiHost);
        return this;
    }

    /**
     * Configure library to use Pardot Api Version 4.
     * @return Builder instance.
     */
    public ConfigurationBuilder withApiVersion4() {
        return withApiVersion("4");
    }

    /**
     * Configure library to use Pardot Api Version 3.
     * @return Builder instance.
     */
    public ConfigurationBuilder withApiVersion3() {
        return withApiVersion("3");
    }

    /**
     * Allows for explicitly configuring library to use different Pardot API Version.
     * The default is to start with API version 3, and if the library detects that version 4 is
     * required, it will automatically upgrade to version 4 as needed.
     *
     * @param apiVersion Define the API version to use.  Supported values are "3" or "4".
     * @return Builder instance.
     */
    public ConfigurationBuilder withApiVersion(final String apiVersion) {
        this.pardotApiVersion = apiVersion;
        return this;
    }

    /**
     * Disable all validation of SSL Certificates.
     * Disabling validations is insecure and highly discouraged!
     *
     * @return Builder instance.
     */
    public ConfigurationBuilder withIgnoreInvalidSslCertificates() {
        return withIgnoreInvalidSslCertificates(true);
    }

    /**
     * Configuration validation of SSL Certificates. Disabling validations is insecure and highly discouraged!
     *
     * @param ignoreInvalidSslCertificates Pass a value of true to disable SSL certificate validation.
     *                                     Pass a value of false to enable SSL certificate validation.
     * @return Builder instance.
     */
    public ConfigurationBuilder withIgnoreInvalidSslCertificates(final boolean ignoreInvalidSslCertificates) {
        this.ignoreInvalidSslCertificates = ignoreInvalidSslCertificates;
        return this;
    }

    /**
     * Allows for injecting a Http Request Interceptor instance.
     *
     * @param requestInterceptor Implementation to use.
     * @return Configuration instance.
     */
    public ConfigurationBuilder withRequestInterceptor(final RequestInterceptor requestInterceptor) {
        this.requestInterceptor = Objects.requireNonNull(requestInterceptor);
        return this;
    }

    /**
     * Create {@link Configuration} instance using properties defined on the builder.
     * @return Configuration instance.
     */
    public Configuration build() {
        // Create optional proxy config
        final ProxyConfiguration proxyConfiguration;
        if (proxyHost == null) {
            // Creates an empty ProxyConfiguration object (not configured).
            proxyConfiguration = new ProxyConfiguration();
        } else {
            // Creates a ProxyConfiguration instance with appropriate values.
            proxyConfiguration = new ProxyConfiguration(
                proxyHost,
                proxyPort,
                proxyScheme,
                proxyUsername,
                proxyPassword
            );
        }

        // Create instance.
        return new Configuration(
            sessionRefreshHandler,
            proxyConfiguration,
            pardotApiHost,
            pardotApiVersion,
            ignoreInvalidSslCertificates,
            requestInterceptor
        );
    }
}
