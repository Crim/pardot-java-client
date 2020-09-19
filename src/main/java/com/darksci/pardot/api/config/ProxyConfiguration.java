package com.darksci.pardot.api.config;

/**
 *
 */
public class ProxyConfiguration {
    // Optional Proxy Configuration
    private final String host;
    private final int port;
    private final String scheme;

    // Optional Proxy Authentication.
    private final String username;
    private final String password;

    /**
     * Not configured constructor.
     */
    public ProxyConfiguration() {
        this(null, 0, null, null, null);
    }

    /**
     * Constructor.
     * @param host
     * @param port
     * @param scheme
     * @param username
     * @param password
     */
    public ProxyConfiguration(final String host, final int port, final String scheme, final String username, final String password) {
        this.host = host;
        this.port = port;
        this.scheme = scheme;
        this.username = username;
        this.password = password;
    }

    public boolean isConfigured() {
        return getHost() != null;
    }

    public boolean isAuthenticationRequired() {
        return getUsername() != null;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getScheme() {
        return scheme;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        String authDisplay = "";
        if (isAuthenticationRequired()) {
            authDisplay =
                ", username='" + username + '\''
                + ", password='XXXXXXXXXX'";
        }

        return "ProxyConfiguration{"
            + "host='" + host + '\''
            + ", port=" + port
            + ", scheme='" + scheme + '\''
            + authDisplay
            + '}';
    }
}
