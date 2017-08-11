package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.user.UserQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 */
public class UserQueryResponseHandler extends BaseResponseHandler<UserQueryResponse.Result> {
    private static final Logger logger = LoggerFactory.getLogger(UserQueryResponseHandler.class);

    @Override
    public UserQueryResponse.Result parseResponse(final String responseStr) {
        try {
            return getMapper().readValue(responseStr, UserQueryResponse.class).getResult();
        } catch (IOException e) {
            logger.error("Failed to parse: {}", e.getMessage(), e);
            return null;
        }
    }
}
