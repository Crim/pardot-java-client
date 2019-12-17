/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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

import com.darksci.pardot.api.rest.interceptor.NoopRequestInterceptor;
import com.darksci.pardot.api.rest.interceptor.RequestInterceptor;

import java.util.Objects;

/**
 * Configure your Pardot API credentials.
 *
 * Also allows for configuring an optional proxy with or without authentication.
 */
public class Configuration {
    private final String email;
    private final String password;
    private final String userKey;

    /**
     * Optionally you can re-use an existing known good api key.
     */
    private String apiKey = null;

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

    /**
     * Optional setting to skip validating Pardot's SSL certificate.
     * There should be no real valid use case for this option other then use against
     * development environments.
     */
    private boolean ignoreInvalidSslCertificates = false;

    /**
     * Optional interface to allow for modifying the outbound Http Post request prior to sending it.
     */
    private RequestInterceptor requestInterceptor = new NoopRequestInterceptor();

    /**
     * Constructor.
     * @param email Pardot user's email address.
     * @param password Pardot user's password.
     * @param userKey Pardot user's userKey.
     */
    public Configuration(final String email, final String password, final String userKey) {
        this.email = email;
        this.password = password;
        this.userKey = userKey;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserKey() {
        return userKey;
    }

    /**
     * Allow setting optional proxy configuration.
     *
     * @param proxyHost Host for the proxy to use.
     * @param proxyPort Post for the proxy to use.
     * @param proxyScheme Scheme to use, HTTP/HTTPS
     * @return Configuration instance.
     */
    public Configuration useProxy(final String proxyHost, final int proxyPort, final String proxyScheme) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyScheme = proxyScheme;
        return this;
    }

    /**
     * Allow setting credentials for a proxy that requires authentication.
     *
     * @param proxyUsername Username for proxy.
     * @param proxyPassword Password for proxy.
     * @return Configuration instance.
     */
    public Configuration useProxyAuthentication(final String proxyUsername, final String proxyPassword) {
        this.proxyUsername = proxyUsername;
        this.proxyPassword = proxyPassword;
        return this;
    }

    /**
     * Configure library to use Pardot Api Version 4.
     * @return Configuration instance.
     */
    public Configuration withApiVersion4() {
        this.pardotApiVersion = "4";
        return this;
    }

    /**
     * Configure library to use Pardot Api Version 4.
     * @return Configuration instance.
     */
    public Configuration withApiVersion3() {
        this.pardotApiVersion = "3";
        return this;
    }

    /**
     * Allows for injecting a Http Request Interceptor instance.
     *
     * @param requestInterceptor Implementation to use.
     * @return Configuration instance.
     */
    public Configuration withRequestInterceptor(final RequestInterceptor requestInterceptor) {
        Objects.requireNonNull(requestInterceptor);
        this.requestInterceptor = requestInterceptor;
        return this;
    }

    /**
     * Skip all validation of SSL Certificates.  This is insecure and highly discouraged!
     *
     * @return Configuration instance.
     */
    public Configuration useInsecureSslCertificates() {
        this.ignoreInvalidSslCertificates = true;
        return this;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public String getProxyScheme() {
        return proxyScheme;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public String getPardotApiHost() {
        return pardotApiHost;
    }

    /**
     * Allows for overriding the Pardot Api hostname.
     *
     * @param pardotApiHost the Pardot API hostname to use.
     * @return Configuration instance.
     */
    public Configuration setPardotApiHost(final String pardotApiHost) {
        this.pardotApiHost = pardotApiHost;
        return this;
    }

    /**
     * Allows for overriding the Pardot Api hostname.
     *
     * @param pardotApiHost the Pardot API hostname to use.
     * @return Configuration instance.
     */
    public Configuration withPardotApiHost(final String pardotApiHost) {
        return setPardotApiHost(pardotApiHost);
    }

    public String getPardotApiVersion() {
        return pardotApiVersion;
    }

    public Configuration setPardotApiVersion(final String pardotApiVersion) {
        this.pardotApiVersion = pardotApiVersion;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Configuration setApiKey(final String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public RequestInterceptor getRequestInterceptor() {
        return requestInterceptor;
    }

    public boolean getIgnoreInvalidSslCertificates() {
        return ignoreInvalidSslCertificates;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Configuration{")
            .append("email='").append(email).append('\'')
            .append(", password='XXXXX'")
            .append(", userKey='").append(userKey.substring(0,3)).append("...'");

        if (proxyHost != null) {
            stringBuilder
                .append(", proxy='").append(proxyScheme).append("://");

            // Append configured proxy auth details
            if (proxyUsername != null) {
                stringBuilder.append(proxyUsername).append(':').append("XXXXXXX@");
            }

            stringBuilder.append(proxyHost).append(":").append(proxyPort).append('\'');
        }
        stringBuilder.append('}');

        return stringBuilder.toString();
    }
}
