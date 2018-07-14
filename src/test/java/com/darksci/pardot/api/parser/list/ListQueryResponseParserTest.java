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
package com.darksci.pardot.api.parser.list;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ListQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ListQueryResponseParserTest.class);

    /**
     * Validates we can parse a List query with multiple Lists response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("listQuery.xml");
        final ListQueryResponse.Result response = new ListQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 2 results", 2, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getLists().size());

        // Validate first list
        List list = response.getLists().get(0);
        assertEquals("Has correct id", 839L, (long) list.getId());
        assertEquals("Has correct name", "Internal Test List", list.getName());
        assertEquals("Has correct isPublic", true, list.getIsPublic());
        assertEquals("Has correct isDynamic", false, list.getIsDynamic());
        assertEquals("Has correct title", "Title of my list", list.getTitle());
        assertEquals("Has correct description", "Internal Test List Description", list.getDescription());
        assertEquals("Has correct isCrmVisible", false, list.getIsCrmVisible());
        assertEquals("Has correct createdAt", "2016-01-04T10:39:27.000", list.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2016-01-04T10:39:27.000", list.getUpdatedAt().toString());

        // Validate 2nd list
        list = response.getLists().get(1);
        assertEquals("Has correct id", 33173, (long) list.getId());
        assertEquals("Has correct name", "Stevie Only List", list.getName());
        assertEquals("Has correct isPublic", false, list.getIsPublic());
        assertEquals("Has correct isDynamic", true, list.getIsDynamic());
        assertNull("Has correct title", list.getTitle());
        assertNull("Has correct description", list.getDescription());
        assertEquals("Has correct isCrmVisible", false, list.getIsCrmVisible());
        assertEquals("Has correct createdAt", "2017-08-11T22:03:22.000", list.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-11T22:03:22.000", list.getUpdatedAt().toString());
    }
}