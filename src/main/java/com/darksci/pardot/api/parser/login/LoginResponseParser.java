package com.darksci.pardot.api.parser.login;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.login.LoginResponse;

import java.io.IOException;

/**
 * Handles login responses.
 */
public class LoginResponseParser implements ResponseParser<LoginResponse> {
    @Override
    public LoginResponse parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, LoginResponse.class);
    }
}
