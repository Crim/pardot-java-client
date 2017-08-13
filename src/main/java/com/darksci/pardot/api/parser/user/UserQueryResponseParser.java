package com.darksci.pardot.api.parser.user;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.user.UserQueryResponse;

import java.io.IOException;

/**
 * Handles parsing UserQuery API responses into POJOs.
 */
public class UserQueryResponseParser implements ResponseParser<UserQueryResponse.Result> {

    @Override
    public UserQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, UserQueryResponse.class).getResult();
    }
}
