package com.darksci.pardot.api.parser.login;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.login.SsoLoginErrorResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SsoLoginErrorResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(SsoLoginErrorResponseParserTest.class);

    /**
     * Validates we can parse an SSO Login error response.
     */
    @Test
    public void testParse() throws IOException {
        final String input = readFile("ssoLoginFailed.json");
        final SsoLoginErrorResponse response = new SsoLoginErrorResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("invalid_client_id", response.getError());
        assertEquals("client identifier invalid", response.getDescription());
    }
}