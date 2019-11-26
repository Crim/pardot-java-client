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

package com.darksci.pardot.api.parser.form;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.form.Form;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FormReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(FormReadResponseParserTest.class);

    /**
     * Validates we can parse a Form Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("formRead.xml");
        final Form form = new FormReadResponseParser().parseResponse(input);
        logger.info("Result: {}", form);

        assertNotNull("Should not be null", form);
        validateForm(form);
    }

    private void validateForm(final Form form) {
        assertEquals("Has correct id", 1L, (long) form.getId());
        assertEquals("Has correct last name", "Standard Form", form.getName());
        assertEquals("Has correct embedCode", "<iframe src=\"http://go.pardot.com/l/1/2018-01-01/2i\" width=\"100%\" height=\"500\" type=\"text/html\" frameborder=\"0\" allowTransparency=\"true\" style=\"border: 0\"></iframe>", form.getEmbedCode());
        assertNotNull("Has non null campaign", form.getCampaign());
        assertEquals("Has correct campaign id", 1L, (long) form.getCampaign().getId());
        assertEquals("Has correct campaign name", "Website Tracking", form.getCampaign().getName());
    }
}