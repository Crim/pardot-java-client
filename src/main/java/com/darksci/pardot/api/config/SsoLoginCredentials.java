package com.darksci.pardot.api.config;


/**
 *
 */
public class SsoLoginCredentials {
    // Immutable values.
    private final String username;
    private final String password;
    private final String clientId;
    private final String clientSecret;

    // Updated after authentication.
    private String accessToken = null;
    private String businessUnitId = null;

    public SsoLoginCredentials(final String username, final String password, final String clientId, final String clientSecret) {
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
