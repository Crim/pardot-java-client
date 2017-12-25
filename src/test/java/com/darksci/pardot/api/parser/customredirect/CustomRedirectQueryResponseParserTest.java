/**
 * Copyright 2017 Stephen Powis https://github.com/Crim/pardot-java-client
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
import com.darksci.pardot.api.response.customredirect.CustomRedirectQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests parsing Custom Redirect Query api responses.
 */
public class CustomRedirectQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomRedirectQueryResponseParserTest.class);

    /**
     * Validates we can parse a custom redirect query response A-OK.
     */
    @Test
    public void testMultipleCustomRedirects() throws IOException {
        final String input = readFile("customRedirectQuery.xml");
        final CustomRedirectQueryResponse.Result response = new CustomRedirectQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 2 results", 2, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getCustomRedirects().size());
        validateCustomRedirect1(response.getCustomRedirects().get(0));
        validateCustomRedirect2(response.getCustomRedirects().get(1));
    }

    private void validateCustomRedirect1(final CustomRedirect customRedirect) {
        assertEquals("Has correct id", 1L, (long) customRedirect.getId());
        assertEquals("Has correct name", "Blah", customRedirect.getName());
        assertEquals("Has correct url", "http://go.pardot.com/l/1/2016-06-03/2khmg8", customRedirect.getUrl());
        assertEquals("Has correct destination url", "http://www.google.com", customRedirect.getDestinationUrl());
        assertNotNull("Has non-null campaign", customRedirect.getCampaign());
        assertEquals("Has correct campaign id", 2L, (long) customRedirect.getCampaign().getId());
        assertEquals("Has correct campaign name", "Website Tracking", customRedirect.getCampaign().getName());
    }

    private void validateCustomRedirect2(final CustomRedirect customRedirect) {
        assertEquals("Has correct id", 2L, (long) customRedirect.getId());
        assertEquals("Has correct name", "Another Test Redirect", customRedirect.getName());
        assertEquals("Has correct url", "http://go.pardot.com/l/1/2017-10-05/5cqq5d", customRedirect.getUrl());
        assertEquals("Has correct destination url", "http://www.facebook.com", customRedirect.getDestinationUrl());
        assertNotNull("Has non-null campaign", customRedirect.getCampaign());
        assertEquals("Has correct campaign id", 3L, (long) customRedirect.getCampaign().getId());
        assertEquals("Has correct campaign name", "Another Test Campaign", customRedirect.getCampaign().getName());
    }
}