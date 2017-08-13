package com.darksci.pardot.api.parser.user;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;

import java.io.IOException;

/**
 * Handles parsing UserAbilities API responses into POJOs.
 */
public class UserAbilitiesParser implements ResponseParser<UserAbilitiesResponse.Result> {

    @Override
    public UserAbilitiesResponse.Result parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, UserAbilitiesResponse.class).getResult();
    }
}
