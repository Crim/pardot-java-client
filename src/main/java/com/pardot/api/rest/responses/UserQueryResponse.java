package com.pardot.api.rest.responses;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.pardot.api.request.user.User;
import com.sun.xml.internal.bind.annotation.XmlLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Represents the result from a User Query API call.
 */
public class UserQueryResponse {

    @JacksonXmlProperty(localName = "result")
    private UserQueryResponse.Result result;

    public Result getResult() {
        return result;
    }

    public static class Result {
        @JacksonXmlProperty(localName = "total_results")
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
