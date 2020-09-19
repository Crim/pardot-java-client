package com.darksci.pardot.api.parser.login;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.login.SsoLoginResponse;

import java.io.IOException;

/**
 * Parses successful SSO login responses.
 */
public class SsoLoginResponseParser implements ResponseParser<SsoLoginResponse> {
    @Override
    public SsoLoginResponse parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newJsonInstance().readValue(responseStr, SsoLoginResponse.class);
    }
}
