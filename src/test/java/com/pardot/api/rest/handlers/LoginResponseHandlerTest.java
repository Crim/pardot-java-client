package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.LoginResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginResponseHandlerTest extends BaseResponseHandlerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginResponseHandlerTest.class);

    /**
     * Validates we can parse the login response A-OK.
     */
    @Test
    public void test() throws IOException {
        final String input = readFile("login.xml");

        final LoginResponse loginResponse = new LoginResponseHandler().parseResponse(input);
        assertNotNull("Should not be null", loginResponse);
        assertEquals("Has correct api_key", "5a1698a233e73d7c8ccd60d775fbc68a", loginResponse.getApiKey());
    }

}