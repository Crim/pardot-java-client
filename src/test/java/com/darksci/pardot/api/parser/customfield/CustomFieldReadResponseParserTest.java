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

package com.darksci.pardot.api.parser.customfield;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.parser.campaign.CampaignReadResponseParser;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.customfield.CustomField;
import com.darksci.pardot.api.response.customfield.CustomFieldType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CustomFieldReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomFieldReadResponseParserTest.class);

    /**
     * Validates we can parse a custom field read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("customFieldRead.xml");
        final CustomField customField = new CustomFieldReadResponseParser().parseResponse(input);
        logger.info("Result: {}", customField);

        assertNotNull("Should not be null", customField);
        validateCustomField(customField);
    }

    private void validateCustomField(final CustomField customField) {
        assertEquals("Has correct id", 3L, (long) customField.getId());
        assertEquals("Has correct name", "Zip", customField.getName());
        assertEquals("Has correct field_id", "Zip2", customField.getFieldId());
        assertEquals("Has correct type", "Text", customField.getType());
        assertEquals("Has correct typeId", 1, (int) customField.getTypeId());
        assertEquals("Has correct customFieldType", CustomFieldType.TEXT, customField.getFieldtype());
        assertNull("Has null crmId", customField.getCrmId());
        assertTrue("Does record multiple", customField.isRecordMultipleResponses());
        assertTrue("Does use values", customField.isUseValues());
    }
}