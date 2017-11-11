package com.darksci.pardot.api.parser.list;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ListQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ListQueryResponseParserTest.class);

    /**
     * Validates we can parse a List query with multiple Lists response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("listQuery.xml");
        final ListQueryResponse.Result response = new ListQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 2 results", 2, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getLists().size());

        // Validate first list
        List list = response.getLists().get(0);
        assertEquals("Has correct id", 839L, (long) list.getId());
        assertEquals("Has correct name", "Internal Test List", list.getName());
        assertEquals("Has correct isPublic", true, list.getIsPublic());
        assertEquals("Has correct isDynamic", false, list.getIsDynamic());
        assertEquals("Has correct title", "Title of my list", list.getTitle());
        assertEquals("Has correct description", "Internal Test List Description", list.getDescription());
        assertEquals("Has correct isCrmVisible", false, list.getIsCrmVisible());
        assertEquals("Has correct createdAt", "2016-01-04T10:39:27.000", list.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2016-01-04T10:39:27.000", list.getUpdatedAt().toString());

        // Validate 2nd list
        list = response.getLists().get(1);
        assertEquals("Has correct id", 33173, (long) list.getId());
        assertEquals("Has correct name", "Stevie Only List", list.getName());
        assertEquals("Has correct isPublic", false, list.getIsPublic());
        assertEquals("Has correct isDynamic", true, list.getIsDynamic());
        assertNull("Has correct title", list.getTitle());
        assertNull("Has correct description", list.getDescription());
        assertEquals("Has correct isCrmVisible", false, list.getIsCrmVisible());
        assertEquals("Has correct createdAt", "2017-08-11T22:03:22.000", list.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-11T22:03:22.000", list.getUpdatedAt().toString());
    }
}