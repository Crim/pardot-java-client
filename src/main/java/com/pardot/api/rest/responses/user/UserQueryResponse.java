package com.pardot.api.rest.responses.user;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Represents the result from a User Query API call.
 */
public class UserQueryResponse {
    private UserQueryResponse.Result result;

    public Result getResult() {
        return result;
    }

    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "user")
        private List<User> users;

        public Integer getTotalResults() {
            return totalResults;
        }

        public List<User> getUsers() {
            return users;
        }

        @Override
        public String toString() {
            return "UserQueryResponse{"
                + "totalResults=" + totalResults
                + ", users=" + users
                + '}';
        }
    }

    @Override
    public String toString() {
        return "UserQueryResponse{"
            + "result=" + result
            + '}';
    }
}
