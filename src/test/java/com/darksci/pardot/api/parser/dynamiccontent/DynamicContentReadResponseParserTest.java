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

package com.darksci.pardot.api.parser.dynamiccontent;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.dynamiccontent.DynamicContent;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests parsing Dynamic Content Query api responses.
 */
public class DynamicContentReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(DynamicContentReadResponseParserTest.class);

    /**
     * Validates we can parse a dynamic content query response A-OK.
     */
    @Test
    public void testDynamicContent() throws IOException {
        final String input = readFile("dynamicContentRead.xml");
        final DynamicContent response = new DynamicContentReadResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        validateDynamicContent1(response);
    }

    private void validateDynamicContent1(final DynamicContent dynamicContent) {
        assertEquals("Has correct id", 752L, (long) dynamicContent.getId());
        assertEquals("Has correct name", "DynamicContent 1", dynamicContent.getName());
        assertEquals("Has correct code", "<script type=\"text/javascript\" src=\"https://go.domain.com/dcjs/139321/752/dc.js\"></script>", dynamicContent.getEmbedCode());
        assertEquals("Has correct url", "https://go.domain.com/dcjs/139321/752/dc.js", dynamicContent.getEmbedUrl());
        assertEquals("Has correct base content", "<strong>This is my default content</strong>", dynamicContent.getBaseContent());
        assertEquals("Has correct based on", "Default Field: City", dynamicContent.getBasedOn());
        assertEquals("Has correct createdAt", "2020-07-29T21:04:24.000", dynamicContent.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2020-07-30T02:24:24.000", dynamicContent.getUpdatedAt().toString());
        assertEquals("Should have 2 variations",2, dynamicContent.getVariations().size());

        DynamicContent.Variation variation = dynamicContent.getVariations().get(0);
        assertEquals("Correct comparison", "contains atlanta", variation.getComparison());
        assertEquals("Correct content", "Your city is <strong>atlanta</strong>", variation.getContent());

        variation = dynamicContent.getVariations().get(1);
        assertEquals("Correct comparison", "contains Tokyo", variation.getComparison());
        assertEquals("Correct content", "Your city is <strong>Tokyo</strong>", variation.getContent());
    }
}