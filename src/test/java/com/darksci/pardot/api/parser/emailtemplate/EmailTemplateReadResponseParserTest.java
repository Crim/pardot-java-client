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
package com.darksci.pardot.api.parser.emailtemplate;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.emailtemplate.EmailTemplate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmailTemplateReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(EmailTemplateReadResponseParserTest.class);

    /**
     * Validates we can parse a Campaign Read
     */
    @Test
    public void testRead() throws IOException {
        final String expectedHtml = "<html><body><center>My New Test Template!<br/>Come Check it out today at "
            + "<a href=\"http://www.pardot.com/\">www.pardot.com</a>!<br/></center><br /><a href=\"%%unsubscribe%%\">Unsubscribe</a>"
            +" from email communications</body></html>";

        final String expectedText = "My New Test Template!\n"
            + "            Come check it out at http://www.pardot.com today!\n"
            + "\n"
            + "            Unsubscribe from email communications: %%unsubscribe%%";

        final String input = readFile("emailTemplateRead.xml");
        final EmailTemplate emailTemplate = new EmailTemplateReadResponseParser().parseResponse(input);
        logger.info("Result: {}", emailTemplate);

        assertNotNull("Should not be null", emailTemplate);
        assertEquals("Has correct id", 11L, (long) emailTemplate.getId());
        assertEquals("Has correct name", "Test Email Template", emailTemplate.getName());
        assertEquals("Has correct html", expectedHtml, emailTemplate.getHtmlMessage());
        assertEquals("Has correct text", expectedText, emailTemplate.getTextMessage());
        assertEquals("Has correct subject", "Email Template - Its my New One!", emailTemplate.getSubject());
        assertTrue(emailTemplate.getIsOneToOneEmail());
        assertTrue(emailTemplate.getIsDripEmail());
        assertTrue(emailTemplate.getIsListEmail());
        assertEquals("Email type is 0", (Long) 0L, emailTemplate.getEmailType());
        assertEquals("Type is 3", (Long) 3L, (Long) emailTemplate.getType());
    }
}