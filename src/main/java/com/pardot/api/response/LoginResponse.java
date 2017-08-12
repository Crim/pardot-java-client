package com.pardot.api.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Represents a login response.
 */
public class LoginResponse {
    @JacksonXmlProperty(localName = "api_key")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "LoginResponse{"
            + "apiKey='" + apiKey + '\''
            + '}';
    }
}
