package com.darksci.pardot.api.parser.emailclick;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.emailclick.EmailClick;
import com.darksci.pardot.api.response.emailclick.EmailClickQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Validates the EmailClickQuery response parser.
 */
public class EmailClickQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(EmailClickQueryResponseParserTest.class);

    /**
     * Validates we can parse a Email Clicks query with multiple responses A-OK.
     */
    @Test
    public void testMultipleEmailClicks() throws IOException {
        final String input = readFile("emailClickQuery.xml");
        final EmailClickQueryResponse.Result response = new EmailClickQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 7 results", 7, (int) response.getTotalResults());
        assertEquals("Should have 4 results", 4, response.getEmailClicks().size());
        validateEmailClick1(response.getEmailClicks().get(0));
        validateEmailClick2(response.getEmailClicks().get(1));
        validateEmailClick3(response.getEmailClicks().get(2));
        validateEmailClick4(response.getEmailClicks().get(3));
    }

    private void validateEmailClick1(final EmailClick emailClick) {
        assertEquals("has correct id", 11L, (long) emailClick.getId());
        assertEquals("has correct prospectId", 111L, (long) emailClick.getProspectId());
        assertEquals("Has correct url", "http://www.pardot.com/1", emailClick.getUrl());
        assertEquals("Has correct fk id", 1L, (long) emailClick.getEmailTemplateId());
    }

    private void validateEmailClick2(final EmailClick emailClick) {
        assertEquals("has correct id", 22L, (long) emailClick.getId());
        assertEquals("has correct prospectId", 222L, (long) emailClick.getProspectId());
        assertEquals("Has correct url", "http://www.pardot.com/2", emailClick.getUrl());
        assertEquals("Has correct fk id", 2L, (long) emailClick.getDripProgramActionId());
    }

    private void validateEmailClick3(final EmailClick emailClick) {
        assertEquals("has correct id", 33L, (long) emailClick.getId());
        assertEquals("has correct prospectId", 333L, (long) emailClick.getProspectId());
        assertEquals("Has correct url", "http://www.pardot.com/3", emailClick.getUrl());
        assertEquals("Has correct fk id", 3L, (long) emailClick.getListEmailId());
    }

    private void validateEmailClick4(final EmailClick emailClick) {
        assertEquals("has correct id", 44L, (long) emailClick.getId());
        assertEquals("has correct prospectId", 444L, (long) emailClick.getProspectId());
        assertEquals("Has correct url", "http://www.pardot.com/4", emailClick.getUrl());
        assertEquals("Has correct fk id", 4L, (long) emailClick.getTrackerRedirectId());
    }
}