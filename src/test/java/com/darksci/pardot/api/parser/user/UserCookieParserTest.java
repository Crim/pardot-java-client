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

package com.darksci.pardot.api.parser.user;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.user.Cookie;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserCookieParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(UserCookieParserTest.class);

    @Test
    public void test() throws IOException {
        final String input = readFile("userCookie.xml");
        final Cookie result = new UserCookieParser().parseResponse(input);
        logger.info("result: {}", result);

        assertEquals((Long) 12L, result.getId());
        assertEquals((Long) 34L, result.getUserId());
        assertEquals("RememberMe", result.getName());
        assertEquals("10bfe186d03-NOT-A-REAL-VALUE-38f9b37c497a597680603f818ee9a03dd36fff8207f070950980a6472fcf15eb3023e3e7e11a3a6c577d98c171499906d8222b3548", result.getValue());
        assertEquals((Long) 1570030099L, result.getExpire());
        assertEquals("/", result.getPath());
        assertEquals("", result.getDomain());
        assertFalse(result.getSecure());
        assertTrue(result.getHttpOnly());
        assertEquals("2018-01-01T01:23:45.000", result.getCreatedAt().toString());
    }
}
