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

package com.darksci.pardot.api.config;

import com.darksci.pardot.api.ConfigurationBuilder;
import com.darksci.pardot.api.rest.interceptor.RequestInterceptor;

import java.util.Objects;

/**
 * Defines API Client Configuration.
 * Use {@link ConfigurationBuilder} to create instances of these.
 */
public class Configuration {
    // Login Details.
    private final LoginType loginType;
    private final SsoLoginCredentials ssoLoginCredentials;
    private final PasswordLoginCredentials passwordLoginCredentials;

    // Proxy Configuration
    private final ProxyConfiguration proxyConfiguration;

    // If you want to override the Pardot API url or version.
    private final String pardotApiHost;
    private String pardotApiVersion;

    /**
     * Optional setting to skip validating Pardot's SSL certificate.
     * There should be no real valid use case for this option other then use against
     * development environments.
     */
    private final boolean ignoreInvalidSslCertificates;

    /**
     * Optional interface to allow for modifying the outbound Http Post request prior to sending it.
     */
    private final RequestInterceptor requestInterceptor;

    /**
     * Creates a new ConfigurationBuilder instance.
     * @return ConfigurationBuilder instance.
     */
    public static ConfigurationBuilder newBuilder() {
        return new ConfigurationBuilder();
    }

    /**
     * Constructor.
     * Note: Use {@link ConfigurationBuilder} to create instances instead of calling this constructor.
     *
     * @param passwordLoginCredentials Defines Pardot password Authentication credentials.
     * @param proxyConfiguration Defines Proxy Configuration.
     * @param pardotApiHost Defines Pardot API Host.
     * @param pardotApiVersion Defines Pardot API version.
     * @param ignoreInvalidSslCertificates Should SSL certificates be validated.
     * @param requestInterceptor Defines request interceptor instance.
     */
    public Configuration(
        final PasswordLoginCredentials passwordLoginCredentials,
        final ProxyConfiguration proxyConfiguration,
        final String pardotApiHost,
        final String pardotApiVersion,
        final boolean ignoreInvalidSslCertificates,
        final RequestInterceptor requestInterceptor) {
        this(
            LoginType.USERNAME_PASSWORD,
            null,
            passwordLoginCredentials,
            proxyConfiguration,
            pardotApiHost,
            pardotApiVersion,
            ignoreInvalidSslCertificates,
            requestInterceptor
        );
    }

    /**
     * Constructor.
     * Note: Use {@link ConfigurationBuilder} to create instances instead of calling this constructor.
     *
     * @param ssoLoginCredentials Defines Salesforce SSO Authentication credentials.
     * @param proxyConfiguration Defines Proxy Configuration.
     * @param pardotApiHost Defines Pardot API Host.
     * @param pardotApiVersion Defines Pardot API version.
     * @param ignoreInvalidSslCertificates Should SSL certificates be validated.
     * @param requestInterceptor Defines request interceptor instance.
     */
    public Configuration(
        final SsoLoginCredentials ssoLoginCredentials,
        final ProxyConfiguration proxyConfiguration,
        final String pardotApiHost,
        final String pardotApiVersion,
        final boolean ignoreInvalidSslCertificates,
        final RequestInterceptor requestInterceptor) {
        this(
            LoginType.SSO,
            ssoLoginCredentials,
            null,
            proxyConfiguration,
            pardotApiHost,
            pardotApiVersion,
            ignoreInvalidSslCertificates,
            requestInterceptor
        );
    }

    /**
     * Constructor.
     * Note: Use {@link ConfigurationBuilder} to create instances instead of calling this constructor.
     *
     * @param loginType Type of login.
     * @param ssoLoginCredentials Defines Salesforce SSO Authentication credentials.
     * @param passwordLoginCredentials Defines Pardot password Authentication credentials.
     * @param proxyConfiguration Defines Proxy Configuration.
     * @param pardotApiHost Defines Pardot API Host.
     * @param pardotApiVersion Defines Pardot API version.
     * @param ignoreInvalidSslCertificates Should SSL certificates be validated.
     * @param requestInterceptor Defines request interceptor instance.
     */
    public Configuration(
        final LoginType loginType,
        final SsoLoginCredentials ssoLoginCredentials,
        final PasswordLoginCredentials passwordLoginCredentials,
        final ProxyConfiguration proxyConfiguration,
        final String pardotApiHost,
        final String pardotApiVersion,
        final boolean ignoreInvalidSslCertificates,
        final RequestInterceptor requestInterceptor) {

        this.loginType = Objects.requireNonNull(loginType);
        this.ssoLoginCredentials = ssoLoginCredentials;
        this.passwordLoginCredentials = passwordLoginCredentials;
        this.proxyConfiguration = Objects.requireNonNull(proxyConfiguration);
        this.pardotApiHost = Objects.requireNonNull(pardotApiHost);
        this.pardotApiVersion = Objects.requireNonNull(pardotApiVersion);
        this.ignoreInvalidSslCertificates = ignoreInvalidSslCertificates;
        this.requestInterceptor = Objects.requireNonNull(requestInterceptor);
    }

    public boolean isUsingPasswordAuthentication() {
        return LoginType.USERNAME_PASSWORD == loginType;
    }

    public boolean isUsingSsoAuthentication() {
        return LoginType.SSO == loginType;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    /**
     * Get defined Salesforce SSO Credentials configuration details.
     * @return PasswordLoginCredentials configuration instance.
     */
    public SsoLoginCredentials getSsoLoginCredentials() {
        if (ssoLoginCredentials == null) {
            throw new IllegalStateException("Cannot access SsoLoginCredentials if configured to use " + loginType + " authentication!");
        }
        return ssoLoginCredentials;
    }

    /**
     * Get defined Pardot PasswordLogin Credentials configuration details.
     * @return PasswordLoginCredentials configuration instance.
     */
    public PasswordLoginCredentials getPasswordLoginCredentials() {
        if (passwordLoginCredentials == null) {
            throw new IllegalStateException("Cannot access PasswordLoginCredentials if configured to use " + loginType + " authentication!");
        }
        return passwordLoginCredentials;
    }

    public boolean hasProxyConfigured() {
        return proxyConfiguration.isConfigured();
    }

    public ProxyConfiguration getProxyConfiguration() {
        return proxyConfiguration;
    }

    public boolean isIgnoreInvalidSslCertificates() {
        return ignoreInvalidSslCertificates;
    }

    public String getPardotApiHost() {
        return pardotApiHost;
    }

    public String getPardotApiVersion() {
        return pardotApiVersion;
    }

    public Configuration setPardotApiVersion(final String pardotApiVersion) {
        this.pardotApiVersion = pardotApiVersion;
        return this;
    }

    public RequestInterceptor getRequestInterceptor() {
        return requestInterceptor;
    }

    @Override
    public String toString() {
        return "Configuration{"
            + "loginType=" + loginType
            + ", ssoLoginCredentials=" + ssoLoginCredentials
            + ", passwordLoginCredentials=" + passwordLoginCredentials
            + ", proxyConfiguration=" + proxyConfiguration
            + ", pardotApiHost='" + pardotApiHost + '\''
            + ", pardotApiVersion='" + pardotApiVersion + '\''
            + ", ignoreInvalidSslCertificates=" + ignoreInvalidSslCertificates
            + ", requestInterceptor=" + requestInterceptor
            + '}';
    }
}
