package com.pardot.api.response.user;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Represents one or more Abilities/Credentials that a user has.
 */
public class UserAbilitiesResponse {
    private UserAbilitiesResponse.Result result;

    public UserAbilitiesResponse.Result getResult() {
        return result;
    }

    /**
     * Represents one or more Abilities/Credentials that a user has.
     */
    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "credentials")
        private Credentials credentials;

        public Integer getTotalResults() {
            return totalResults;
        }

        public List<String> getCredentials() {
            return credentials.getCredentials();
        }

        @Override
        public String toString() {
            return "Result{"
                + "totalResults=" + totalResults
                + ", credentials=" + getCredentials()
                + '}';
        }

        /**
         * Represents one or more Abilities/Credentials that a user has.
         */
        public static class Credentials {
            private List<String> credentials;

            @JacksonXmlProperty(localName = "credential")
            public List<String> getCredentials() {
                return credentials;
            }

            @Override
            public String toString() {
                return credentials.toString();
            }
        }
    }

    @Override
    public String toString() {
        return "UserAbilitiesResponse{"
            + "result=" + result
            + '}';
    }
}
