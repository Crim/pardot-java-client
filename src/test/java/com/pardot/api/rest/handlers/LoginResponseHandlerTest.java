package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.LoginResponse;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 *
 */
public class LoginResponseHandlerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginResponseHandlerTest.class);

    /**
     * Validates we can parse the login response A-OK.
     */
    @Test
    public void test() throws IOException {
        final URL inputFile = getClass().getClassLoader().getResource("mockResponses/login.xml");
        final String input = IOUtils.toString(inputFile, Charsets.UTF_8);

        final LoginResponse loginResponse = new LoginResponseHandler().parseResponse(input);
        assertNotNull("Should not be null", loginResponse);
        assertEquals("Has correct api_key", "5a1698a233e73d7c8ccd60d775fbc68a", loginResponse.getApiKey());
    }

}