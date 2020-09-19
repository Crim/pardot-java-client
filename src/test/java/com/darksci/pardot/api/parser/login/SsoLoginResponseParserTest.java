package com.darksci.pardot.api.parser.login;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.login.SsoLoginResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SsoLoginResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(SsoLoginResponseParserTest.class);

    /**
     * Validates we can parse an SSO Login response.
     */
    @Test
    public void testParse() throws IOException {
        final String input = readFile("ssoLoginSuccess.json");
        final SsoLoginResponse response = new SsoLoginResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);

        // Validate properties
        assertEquals("ACCESS_TOKEN_HERE", response.getAccessToken());
        assertEquals("https://login.salesforce.com/id/00DD/005B00", response.getId());
        assertEquals("https://test.my.salesforce.com", response.getInstanceUrl());
        assertEquals("1600482897925", response.getIssuedAt());
        assertEquals("SIGNATURE-HERE", response.getSignature());
        assertEquals("Bearer", response.getTokenType());
    }
}