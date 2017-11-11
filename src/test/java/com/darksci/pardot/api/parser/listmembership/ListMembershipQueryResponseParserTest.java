package com.darksci.pardot.api.parser.listmembership;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.parser.list.ListQueryResponseParserTest;
import com.darksci.pardot.api.response.list.ListMembership;
import com.darksci.pardot.api.response.listmembership.ListMembershipQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ListMembershipQueryResponseParserTest  extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ListQueryResponseParserTest.class);

    /**
     * Validates we can parse a List query with multiple Lists response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("listMembershipQuery.xml");
        final ListMembershipQueryResponse.Result response = new ListMembershipQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 2 results", 2, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getListMemberships().size());

        // Validate first list
        ListMembership listMembership = response.getListMemberships().get(0);
        assertEquals("Has correct id", 158902003L, (long) listMembership.getId());
        assertEquals("Has correct listId", 33173L, (long) listMembership.getListId());
        assertEquals("Has correct prospectId", 59135263L, (long) listMembership.getProspectId());
        assertEquals("Has correct optedOut", false, listMembership.getOptedOut());
        assertEquals("Has correct createdAt", "2017-08-11T22:03:37.000", listMembership.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-11T22:03:37.000", listMembership.getUpdatedAt().toString());

        // Validate 2nd list
        listMembership = response.getListMemberships().get(1);
        assertEquals("Has correct id", 170293539L, (long) listMembership.getId());
        assertEquals("Has correct listId", 33173L, (long) listMembership.getListId());
        assertEquals("Has correct prospectId", 59156811L, (long) listMembership.getProspectId());
        assertEquals("Has correct optedOut", true, listMembership.getOptedOut());
        assertEquals("Has correct createdAt", "2017-11-11T07:40:44.000", listMembership.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-11-11T07:40:44.000", listMembership.getUpdatedAt().toString());
    }
}