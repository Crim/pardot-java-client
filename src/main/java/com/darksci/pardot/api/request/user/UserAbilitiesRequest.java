package com.darksci.pardot.api.request.user;

import com.darksci.pardot.api.request.BaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * * Used to generate a User Abilities request.
 */
public class UserAbilitiesRequest extends BaseRequest<UserAbilitiesRequest> {
    private static final Logger logger = LoggerFactory.getLogger(UserAbilitiesRequest.class);

    @Override
    public String getApiEndpoint() {
        return "user/do/abilities";
    }
}
