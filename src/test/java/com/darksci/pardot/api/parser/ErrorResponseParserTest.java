package com.darksci.pardot.api.parser;

import com.darksci.pardot.api.response.ErrorResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ErrorResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ErrorResponseParserTest.class);


    /**
     * Validates we can parse the login response A-OK.
     */
    @Test
    public void test() throws IOException {
        final String input = readFile("error.xml");

        final ErrorResponse errorResponse = new ErrorResponseParser().parseResponse(input);
        assertNotNull("Should not be null", errorResponse);
        logger.info("{}", errorResponse);
        assertEquals("Has correct error", "Invalid API key or user key", errorResponse.getMessage());
        assertEquals("Has correct code", 1, errorResponse.getCode());
    }
}