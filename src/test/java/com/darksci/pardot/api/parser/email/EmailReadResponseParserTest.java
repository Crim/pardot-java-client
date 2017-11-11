/**
 * Copyright 2017 Stephen Powis
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
package com.darksci.pardot.api.parser.email;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.email.Email;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmailReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(EmailReadResponseParserTest.class);

    /**
     * Validates we can parse a User Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("emailRead.xml");
        final Email email = new EmailReadResponseParser().parseResponse(input);
        logger.info("Result: {}", email);

        assertNotNull("Should not be null", email);
        assertEquals("Has correct id", 12345L, (long) email.getId());
        assertEquals("Has correct  name", "Test Email To Stephen", email.getName());
        assertEquals("Has correct subject", "This is the Subject", email.getSubject());
        assertNotNull("Has non-null message", email.getMessage());
        assertNotNull("Has text message", email.getMessage().getText());
        assertNotNull("Has html message", email.getMessage().getHtml());
        assertTrue("Is One-to-One email", email.isOneToOne());
        assertEquals("Has correct createdAt", "2017-08-11T21:41:08.000", email.getCreatedAt().toString());
    }
}