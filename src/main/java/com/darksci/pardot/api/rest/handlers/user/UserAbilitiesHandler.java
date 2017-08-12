package com.darksci.pardot.api.rest.handlers.user;

import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import com.darksci.pardot.api.rest.handlers.BaseResponseHandler;

import java.io.IOException;

/**
 * Handles parsing UserAbilities API responses into POJOs.
 */
public class UserAbilitiesHandler extends BaseResponseHandler<UserAbilitiesResponse.Result> {

    @Override
    public UserAbilitiesResponse.Result parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, UserAbilitiesResponse.class).getResult();
    }
}
