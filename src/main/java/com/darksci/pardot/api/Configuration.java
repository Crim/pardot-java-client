package com.darksci.pardot.api;

/**
 * Configure your Pardot API credentials.
 *
 * Also allows for configuring an optional proxy with or without authentication.
 */
public class Configuration {
    private final String email;
    private final String password;
    private final String userKey;

    // Optional Proxy Configuration
    private String proxyHost = null;
    private int proxyPort = 0;
    private String proxyScheme = "HTTP";

    // Optional Proxy Authentication.
    private String proxyUsername = null;
    private String proxyPassword = null;

    // If you want to override the Pardot API url
    private String pardotApiHost = "https://pi.pardot.com/api";
    private String pardotApiVersion = "3";

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
     */
    public void useProxy(final String proxyHost, final int proxyPort, final String proxyScheme) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyScheme = proxyScheme;
    }

    /**
     * Allow setting credentials for a proxy that requires authentication.
     *
     * @param proxyUsername Username for proxy.
     * @param proxyPassword Password for proxy.
     */
    public void useProxyAuthentication(final String proxyUsername, final String proxyPassword) {
        this.proxyUsername = proxyUsername;
        this.proxyPassword = proxyPassword;
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

    public void setPardotApiHost(final String pardotApiHost) {
        this.pardotApiHost = pardotApiHost;
    }

    public String getPardotApiVersion() {
        return pardotApiVersion;
    }

    public void setPardotApiVersion(final String pardotApiVersion) {
        this.pardotApiVersion = pardotApiVersion;
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
