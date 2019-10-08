package com.darksci.pardot.api.parser.user;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.user.Cookie;
import com.darksci.pardot.api.response.user.UserCookieResponse;

import java.io.IOException;

/**
 * Parses a user/doCookie request.
 */
public class UserCookieParser implements ResponseParser<Cookie> {
    @Override
    public Cookie parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, UserCookieResponse.class).getCookie();
    }
}
