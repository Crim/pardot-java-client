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

package com.darksci.pardot.api.parser.listmembership;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.list.ListMembership;
import com.darksci.pardot.api.response.listmembership.ListMembershipQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ListMembershipQueryResponseParserTest  extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ListMembershipQueryResponseParserTest.class);

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