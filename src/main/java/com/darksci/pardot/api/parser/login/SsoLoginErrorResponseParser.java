package com.darksci.pardot.api.parser.login;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.login.SsoLoginErrorResponse;
import com.darksci.pardot.api.response.login.SsoLoginResponse;

import java.io.IOException;

/**
 * Parses error SSO login responses.
 */
public class SsoLoginErrorResponseParser implements ResponseParser<SsoLoginErrorResponse> {
    @Override
    public SsoLoginErrorResponse parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newJsonInstance().readValue(responseStr, SsoLoginErrorResponse.class);
    }
}
