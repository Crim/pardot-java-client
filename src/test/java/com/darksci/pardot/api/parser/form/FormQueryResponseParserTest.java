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

package com.darksci.pardot.api.parser.form;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.form.Form;
import com.darksci.pardot.api.response.form.FormQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Validates parsing Form Query responses.
 */
public class FormQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(FormQueryResponseParserTest.class);

    /**
     * Validates we can parse a Campaign query with multiple campaigns response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("formQuery.xml");
        final FormQueryResponse.Result response = new FormQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 6 results", 6, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getForms().size());
        validateForm1(response.getForms().get(0));
        validateForm2(response.getForms().get(1));
    }

    private void validateForm1(final Form form) {
        assertEquals("Has correct id", 1L, (long) form.getId());
        assertEquals("Has correct last name", "Standard Form", form.getName());
        assertEquals("Has correct embedCode", "<iframe src=\"http://go.pardot.com/l/1/2018-01-01/2i\" width=\"100%\" height=\"500\" type=\"text/html\" frameborder=\"0\" allowTransparency=\"true\" style=\"border: 0\"></iframe>", form.getEmbedCode());
        assertNotNull("Has non null campaign", form.getCampaign());
        assertEquals("Has correct campaign id", 1L, (long) form.getCampaign().getId());
        assertEquals("Has correct campaign name", "Website Tracking", form.getCampaign().getName());
    }

    private void validateForm2(final Form form) {
        assertEquals("Has correct id", 2L, (long) form.getId());
        assertEquals("Has correct last name", "Buyer's Guide", form.getName());
        assertEquals("Has correct embedCode", "<iframe src=\"http://go.pardot.com/l/1/2018-01-02/5i\" width=\"100%\" height=\"500\" type=\"text/html\" frameborder=\"0\" allowTransparency=\"true\" style=\"border: 0\"></iframe>", form.getEmbedCode());
        assertNotNull("Has non null campaign", form.getCampaign());
        assertEquals("Has correct campaign id", 3L, (long) form.getCampaign().getId());
        assertEquals("Has correct campaign name", "Buyer's Guide Campaign", form.getCampaign().getName());
    }
}