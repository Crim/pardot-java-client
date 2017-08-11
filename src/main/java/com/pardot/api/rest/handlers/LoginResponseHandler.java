package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Handles login responses.
 */
public class LoginResponseHandler extends BaseResponseHandler<LoginResponse> {
    private static final Logger logger = LoggerFactory.getLogger(LoginResponseHandler.class);

    @Override
    public LoginResponse parseResponse(final String responseStr) {
        try {
            return getMapper().readValue(responseStr, LoginResponse.class);
        } catch (IOException e) {
            logger.error("Failed to parse: {}", e.getMessage(), e);
            return null;
        }
    }
}
