package com.darksci.pardot.api.parser.listmembership;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.list.ListMembership;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ListMembershipReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ListMembershipReadResponseParserTest.class);

    /**
     * Validates we can parse a ListMembership Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("listMembershipRead.xml");
        final ListMembership listMembership = new ListMembershipReadResponseParser().parseResponse(input);
        logger.info("Result: {}", listMembership);

        // Validate list
        assertEquals("Has correct id", 170293539L, (long) listMembership.getId());
        assertEquals("Has correct listId", 33173L, (long) listMembership.getListId());
        assertEquals("Has correct prospectId", 59156811L, (long) listMembership.getProspectId());
        assertFalse("Has correct optedOut", listMembership.getOptedOut());
        assertEquals("Has correct createdAt", "2017-11-11T07:40:44.000", listMembership.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-11-11T07:40:44.000", listMembership.getUpdatedAt().toString());
    }
}