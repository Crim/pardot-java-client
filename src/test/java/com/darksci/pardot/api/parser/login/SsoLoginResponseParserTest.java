/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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