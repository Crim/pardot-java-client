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
import com.darksci.pardot.api.response.emailtemplate.EmailTemplateListOneToOneResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test parsing Email Template List One To One templates.
 */
public class EmailTemplateListOneToOneResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(EmailTemplateListOneToOneResponseParserTest.class);

    /**
     * Validates we can parse an email template list one to one query.
     */
    @Test
    public void testMultipleTemplates() throws IOException {
        final String input = readFile("emailTemplateListOneToOne.xml");
        final EmailTemplateListOneToOneResponse.Result response = new EmailTemplateListOneToOneResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 11 results", 11, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getEmailTemplates().size());
        validateEmailTemplate1(response.getEmailTemplates().get(0));
        validateEmailTemplate2(response.getEmailTemplates().get(1));
    }

    private void validateEmailTemplate1(final EmailTemplate emailTemplate) {
        assertNotNull("Should not be null", emailTemplate);
        assertEquals("Has correct id", 1L, (long) emailTemplate.getId());
        assertEquals("Has correct name", "Buyer's Guide", emailTemplate.getName());
        assertEquals("Has correct subject", "Free Buyer's Guide Subject", emailTemplate.getSubject());
        assertTrue(emailTemplate.getIsOneToOneEmail());
        assertTrue(emailTemplate.getIsDripEmail());
        assertTrue(emailTemplate.getIsListEmail());
        assertEquals("Email type is 0", (Long) 0L, emailTemplate.getEmailType());
        assertEquals("Type is 1", (Long) 1L, (Long) emailTemplate.getType());
    }

    private void validateEmailTemplate2(final EmailTemplate emailTemplate) {
        assertNotNull("Should not be null", emailTemplate);
        assertEquals("Has correct id", 11L, (long) emailTemplate.getId());
        assertEquals("Has correct name", "Test Email Template", emailTemplate.getName());
        assertEquals("Has correct subject", "New Template - Its the New New!", emailTemplate.getSubject());
        assertTrue(emailTemplate.getIsOneToOneEmail());
        assertTrue(emailTemplate.getIsDripEmail());
        assertTrue(emailTemplate.getIsListEmail());
        assertEquals("Email type is 0", (Long) 0L, emailTemplate.getEmailType());
        assertEquals("Type is 3", (Long) 3L, (Long) emailTemplate.getType());
    }
}