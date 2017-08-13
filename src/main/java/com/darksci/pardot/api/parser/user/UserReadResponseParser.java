package com.darksci.pardot.api.parser.user;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserReadResponse;

import java.io.IOException;

/**
 * Handles parsing UserRead API responses into POJOs.
 */
public class UserReadResponseParser implements ResponseParser<User> {

    @Override
    public User parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, UserReadResponse.class).getUser();
    }
}
