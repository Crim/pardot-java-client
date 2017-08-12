package com.darksci.pardot.api.rest.handlers;

import com.darksci.pardot.api.response.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Handles login responses.
 */
public class LoginResponseHandler extends BaseResponseHandler<LoginResponse> {
    private static final Logger logger = LoggerFactory.getLogger(LoginResponseHandler.class);

    @Override
    public LoginResponse parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, LoginResponse.class);
    }
}
