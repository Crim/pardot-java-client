package com.darksci.pardot.api.config;

/**
 *
 */
public class PasswordLoginCredentials {
    // Immutable Fields.
    private final String username;
    private final String password;
    private final String userKey;

    // Updated after authenticated.
    private String apiKey = null;

    public PasswordLoginCredentials(final String username, final String password, final String userKey) {
        this.username = username;
        this.password = password;
        this.userKey = userKey;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserKey() {
        return userKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public boolean hasApiKey() {
        return apiKey != null;
    }

    public void clearApiKey() {
        this.setApiKey(null);
    }

    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        final String apiKeyDisplay;
        if (hasApiKey()) {
            apiKeyDisplay = "-API-KEY-SET-";
        } else {
             apiKeyDisplay = "-NO-API-KEY-SET-";
        }


        return "PasswordLoginCredentials{"
            + "username='" + username + '\''
            + ", password='XXXXXXXXX'"
            + ", userKey='XXXXXXXXX'"
            + ", apiKey='" + apiKeyDisplay + "'"
            + '}';
    }
}
