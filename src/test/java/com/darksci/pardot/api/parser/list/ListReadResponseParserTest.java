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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ListReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ListReadResponseParserTest.class);

    /**
     * Validates we can parse a List Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("listRead.xml");
        final List list = new ListReadResponseParser().parseResponse(input);
        logger.info("Result: {}", list);

        // Validate list
        assertEquals("Has correct id", 33173, (long) list.getId());
        assertEquals("Has correct name", "Stevie Only List", list.getName());
        assertEquals("Has correct isPublic", false, list.getIsPublic());
        assertEquals("Has correct isDynamic", false, list.getIsDynamic());
        assertNull("Has correct title", list.getTitle());
        assertNull("Has correct description", list.getDescription());
        assertEquals("Has correct isCrmVisible", false, list.getIsCrmVisible());
        assertEquals("Has correct createdAt", "2017-08-11T22:03:22.000", list.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-11T22:03:22.000", list.getUpdatedAt().toString());
    }
}