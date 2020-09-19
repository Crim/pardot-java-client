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
    private final String businessUnitId;

    // Updated after authentication.
    private String accessToken = null;

    public SsoLoginCredentials(final String username, final String password, final String clientId, final String clientSecret, final String businessUnitId) {
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.businessUnitId = businessUnitId;
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

    public boolean hasAccessToken() {
        return accessToken != null;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public String getBusinessUnitId() {
        return businessUnitId;
    }
}
