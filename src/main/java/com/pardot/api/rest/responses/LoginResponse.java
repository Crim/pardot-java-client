package com.pardot.api.rest.responses;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a login response.
 */
public class LoginResponse {
    private static final Logger logger = LoggerFactory.getLogger(LoginResponse.class);

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
