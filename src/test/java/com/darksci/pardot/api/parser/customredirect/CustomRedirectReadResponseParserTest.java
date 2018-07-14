/**
 * Copyright 2017, 2018 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.parser.customredirect;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.customredirect.CustomRedirect;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomRedirectReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomRedirectReadResponseParserTest.class);

    /**
     * Validates we can parse a custom redirect read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("customRedirectRead.xml");
        final CustomRedirect customRedirect = new CustomRedirectReadResponseParser().parseResponse(input);
        logger.info("Result: {}", customRedirect);

        assertNotNull("Should not be null", customRedirect);
        validateCustomRedirect(customRedirect);
    }

    private void validateCustomRedirect(final CustomRedirect customRedirect) {
        assertEquals("Has correct id", 1L, (long) customRedirect.getId());
        assertEquals("Has correct name", "Blah", customRedirect.getName());
        assertEquals("Has correct url", "http://go.pardot.com/l/1/2016-06-03/2khmg8", customRedirect.getUrl());
        assertEquals("Has correct destination url", "http://www.google.com", customRedirect.getDestinationUrl());
        assertNotNull("Has non-null campaign", customRedirect.getCampaign());
        assertEquals("Has correct campaign id", 2L, (long) customRedirect.getCampaign().getId());
        assertEquals("Has correct campaign name", "Website Tracking", customRedirect.getCampaign().getName());
    }
}