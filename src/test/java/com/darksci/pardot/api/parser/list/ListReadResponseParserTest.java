package com.darksci.pardot.api.parser.list;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.list.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ListReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ListReadResponseParserTest.class);

    /**
     * Validates we can parse a List Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("listRead.xml");
        final List list = new ListReadResponseParser().parseResponse(input);
        logger.info("Result: {}", list);

        // Validate list
        assertEquals("Has correct id", 33173, (long) list.getId());
        assertEquals("Has correct name", "Stevie Only List", list.getName());
        assertEquals("Has correct isPublic", false, list.getIsPublic());
        assertEquals("Has correct isDynamic", false, list.getIsDynamic());
        assertNull("Has correct title", list.getTitle());
        assertNull("Has correct description", list.getDescription());
        assertEquals("Has correct isCrmVisible", false, list.getIsCrmVisible());
        assertEquals("Has correct createdAt", "2017-08-11T22:03:22.000", list.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-11T22:03:22.000", list.getUpdatedAt().toString());
    }
}