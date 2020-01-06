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

package com.darksci.pardot.api.parser.tagobject;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.request.tagobject.TagObjectType;
import com.darksci.pardot.api.response.tagobject.TagObject;
import com.darksci.pardot.api.response.tagobject.TagObjectQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Validates parsing TagObject Query responses.
 */
public class TagObjectQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(TagObjectQueryResponseParserTest.class);

    /**
     * Validates we can parse a TagObject query with multiple campaigns response A-OK.
     */
    @Test
    public void testMultipleTags() throws IOException {
        final String input = readFile("tagObjectQuery.xml");
        final TagObjectQueryResponse.Result response = new TagObjectQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 6 results", 6, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getTagObjects().size());
        validateTagObject1(response.getTagObjects().get(0));
        validateTagObject2(response.getTagObjects().get(1));
    }

    private void validateTagObject1(final TagObject tagObject) {
        assertEquals("Has correct id", 53772L, (long) tagObject.getId());
        assertEquals("Has correct type", TagObjectType.PROSPECT, tagObject.getType());
        assertEquals("Has correct type name", "Prospect", tagObject.getTypeName());
    }

    private void validateTagObject2(final TagObject tagObject) {
        assertEquals("Has correct id", 53773L, (long) tagObject.getId());
        assertEquals("Has correct type", TagObjectType.FORM, tagObject.getType());
        assertEquals("Has correct type name", "Form", tagObject.getTypeName());
    }
}