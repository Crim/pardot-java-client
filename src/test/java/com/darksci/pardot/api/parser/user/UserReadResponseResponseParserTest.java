/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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
import com.darksci.pardot.api.response.user.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserReadResponseResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(UserReadResponseResponseParserTest.class);

    /**
     * Validates we can parse a User Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("userRead.xml");
        final User user = new UserReadResponseParser().parseResponse(input);
        logger.info("Result: {}", user);

        assertNotNull("Should not be null", user);
        assertEquals("Has correct id", 1212L, (long) user.getId());
        assertEquals("Has correct accountId", 1L, (long) user.getAccount());
        assertEquals("Has correct first name", "Api", user.getFirstName());
        assertEquals("Has correct last name", "Test", user.getLastName());
        assertEquals("Has correct email", "apitest@gmail.com", user.getEmail());
        assertEquals("Has correct jobTitle", "Engineer", user.getJobTitle());
        assertEquals("Has correct role", "Administrator", user.getRole());
        assertEquals("Has correct createdAt", "2017-08-11T01:20:15.000", user.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-11T21:20:15.000", user.getUpdatedAt().toString());
    }
}