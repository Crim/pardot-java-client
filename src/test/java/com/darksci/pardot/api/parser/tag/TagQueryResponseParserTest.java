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

package com.darksci.pardot.api.parser.tag;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.tag.Tag;
import com.darksci.pardot.api.response.tag.TagQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Validates parsing Tag Query responses.
 */
public class TagQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(TagQueryResponseParserTest.class);

    /**
     * Validates we can parse a Tag query with multiple campaigns response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("tagQuery.xml");
        final TagQueryResponse.Result response = new TagQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 6 results", 6, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getTags().size());
        validateTag1(response.getTags().get(0));
        validateTag2(response.getTags().get(1));
    }

    private void validateTag1(final Tag tag) {
        assertEquals("Has correct id", 1L, (long) tag.getId());
        assertEquals("Has correct name", "Standard Tag", tag.getName());
    }

    private void validateTag2(final Tag tag) {
        assertEquals("Has correct id", 2L, (long) tag.getId());
        assertEquals("Has correct name", "Standard Tag 2", tag.getName());
    }
}