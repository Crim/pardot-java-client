package com.darksci.pardot.api.rest.handlers.user;

import com.darksci.pardot.api.response.user.UserQueryResponse;
import com.darksci.pardot.api.rest.handlers.BaseResponseHandler;

import java.io.IOException;

/**
 * Handles parsing UserQuery API responses into POJOs.
 */
public class UserQueryResponseHandler extends BaseResponseHandler<UserQueryResponse.Result> {

    @Override
    public UserQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, UserQueryResponse.class).getResult();
    }
}
