package com.darksci.pardot.api;

import com.darksci.pardot.api.config.LoginType;
import com.darksci.pardot.api.config.PasswordLoginCredentials;
import com.darksci.pardot.api.config.ProxyConfiguration;
import com.darksci.pardot.api.config.SsoLoginCredentials;
import com.darksci.pardot.api.rest.interceptor.NoopRequestInterceptor;
import com.darksci.pardot.api.rest.interceptor.RequestInterceptor;

import java.util.Objects;

import static com.darksci.pardot.api.config.LoginType.*;
import static com.darksci.pardot.api.config.LoginType.SSO;

/**
 * Configuration Builder.
 */
public class ConfigurationBuilder {
    private LoginType loginType;

    // Configuration properties for username password login
    private String email;
    private String password;
    private String userKey;

    // Configuration properties for SSO login.
    private String ssoClientId;
    private String ssoClientSecret;

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
     * For configuring legacy Username, Password, and Userkey api login.
     * @param username Pardot user's email address or username.
     * @param password Pardot user's password.
     * @param userKey Pardot user's userKey.
     * @return Builder instance.
     */
    public ConfigurationBuilder withUsernameAndPasswordLogin(final String username, final String password, final String userKey) {
        this.loginType = USERNAME_PASSWORD;
        this.email = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        this.userKey = Objects.requireNonNull(userKey);

        return this;
    }

    public ConfigurationBuilder withSsoLogin(final String username, final String password, final String clientId, final String clientSecret) {
        this.loginType = SSO;
        this.email = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        this.ssoClientId = Objects.requireNonNull(clientId);
        this.ssoClientSecret = Objects.requireNonNull(clientSecret);
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
     * Configure library to use different Pardot API Version.
     * @return Builder instance.
     */
    public ConfigurationBuilder withApiVersion(final String apiVersion) {
        this.pardotApiVersion = apiVersion;
        return this;
    }

    /**
     * Disable all validation of SSL Certificates.  This is insecure and highly discouraged!
     *
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

    public Configuration build() {
        // Create proxy config
        final ProxyConfiguration proxyConfiguration;
        if (proxyHost == null) {
            proxyConfiguration = new ProxyConfiguration();
        } else {
            proxyConfiguration = new ProxyConfiguration(
                proxyHost,
                proxyPort,
                proxyScheme,
                proxyUsername,
                proxyPassword
            );
        }
        final PasswordLoginCredentials passwordLoginCredentials;
        final SsoLoginCredentials ssoLoginCredentials;

        switch (loginType) {
            case SSO:
                passwordLoginCredentials = null;
                ssoLoginCredentials = new SsoLoginCredentials(email, password, ssoClientId, ssoClientSecret);
                break;
            case USERNAME_PASSWORD:
                passwordLoginCredentials = new PasswordLoginCredentials(email, password, userKey);
                ssoLoginCredentials = null;
                break;
            default:
                throw new IllegalStateException("Undefined Login type!");
        }

        return new Configuration(
            loginType,
            ssoLoginCredentials,
            passwordLoginCredentials,
            proxyConfiguration,
            pardotApiHost,
            pardotApiVersion,
            ignoreInvalidSslCertificates,
            requestInterceptor
        );
    }
}
