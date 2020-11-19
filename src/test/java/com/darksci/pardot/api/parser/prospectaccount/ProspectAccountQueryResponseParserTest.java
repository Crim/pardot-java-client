package com.darksci.pardot.api.parser.prospectaccount;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.parser.prospect.ProspectQueryResponseParser;
import com.darksci.pardot.api.response.prospect.ProspectQueryResponse;
import com.darksci.pardot.api.response.prospectaccount.ProspectAccountQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ProspectAccountQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ProspectAccountQueryResponseParserTest.class);

    /**
     * Validates we can parse a Prospect Account Query response.
     */
    @Test
    public void testQuery() throws IOException {
        final String input = readFile("prospectAccountQuery.xml");
        final ProspectAccountQueryResponse.Result response = new ProspectAccountQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        // High level validation
        assertEquals("Has expected value for total_results", 1, (int) response.getTotalResults());
        assertEquals("Has correct number of prospect accounts in result", 1, response.getProspectAccounts().size());

        // TODO Validate entries
    }
}