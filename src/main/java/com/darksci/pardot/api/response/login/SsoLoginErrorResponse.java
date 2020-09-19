package com.darksci.pardot.api.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class SsoLoginErrorResponse {
    private final String error;
    private final String description;

    @JsonCreator
    public SsoLoginErrorResponse(
        @JsonProperty("error") final String error,
        @JsonProperty("error_description") final String description) {
        this.error = error;
        this.description = description;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "SsoLoginErrorResponse{"
            + "error='" + error + '\''
            + ", description='" + description + '\''
            + '}';
    }
}
