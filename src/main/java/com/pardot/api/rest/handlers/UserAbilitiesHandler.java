package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.LoginResponse;
import com.pardot.api.rest.responses.UserAbilitiesResponse;
import com.pardot.api.rest.responses.UserQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 */
public class UserAbilitiesHandler extends BaseResponseHandler<UserAbilitiesResponse.Result> {
    private static final Logger logger = LoggerFactory.getLogger(UserAbilitiesHandler.class);

    @Override
    public UserAbilitiesResponse.Result parseResponse(final String responseStr) {
        try {
            return getMapper().readValue(responseStr, UserAbilitiesResponse.class).getResult();
        } catch (IOException e) {
            logger.error("Failed to parse: {}", e.getMessage(), e);
            return null;
        }
    }
}
