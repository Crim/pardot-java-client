package com.darksci.pardot.api.parser.customfield;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.customfield.CustomField;
import com.darksci.pardot.api.response.customfield.CustomFieldQueryResponse;
import com.darksci.pardot.api.response.customfield.CustomFieldType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests parsing CustomFieldQuery api responses.
 */
public class CustomFieldQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomFieldQueryResponseParserTest.class);

    /**
     * Validates we can parse a Campaign query with multiple campaigns response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("customFieldQuery.xml");
        final CustomFieldQueryResponse.Result response = new CustomFieldQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 6 results", 6, (int) response.getTotalResults());
        assertEquals("Should have 3 results", 3, response.getCustomFields().size());
        validateCustomField1(response.getCustomFields().get(0));
        validateCustomField2(response.getCustomFields().get(1));
        validateCustomField3(response.getCustomFields().get(2));
    }

    private void validateCustomField1(final CustomField customField) {
        assertEquals("Has correct id", 1L, (long) customField.getId());
        assertEquals("Has correct name", "date", customField.getName());
        assertEquals("Has correct field_id", "my__date", customField.getFieldId());
        assertEquals("Has correct type", "Date", customField.getType());
        assertEquals("Has correct typeId", 12, (int) customField.getTypeId());
        assertEquals("Has correct customFieldType", CustomFieldType.DATE, customField.getFieldtype());
        assertNull("Has null crmId", customField.getCrmId());
        assertFalse("Does not record multiple", customField.isRecordMultipleResponses());
        assertFalse("Does not use values", customField.isUseValues());
    }

    private void validateCustomField2(final CustomField customField) {
        assertEquals("Has correct id", 2L, (long) customField.getId());
        assertEquals("Has correct name", "nothing field", customField.getName());
        assertEquals("Has correct field_id", "nothing_field", customField.getFieldId());
        assertEquals("Has correct type", "Text", customField.getType());
        assertEquals("Has correct typeId", 1, (int) customField.getTypeId());
        assertEquals("Has correct customFieldType", CustomFieldType.TEXT, customField.getFieldtype());
        assertEquals("Has correct crmId", "my_crm_id__c", customField.getCrmId());
        assertFalse("Does not record multiple", customField.isRecordMultipleResponses());
        assertFalse("Does not use values", customField.isUseValues());
    }

    private void validateCustomField3(final CustomField customField) {
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