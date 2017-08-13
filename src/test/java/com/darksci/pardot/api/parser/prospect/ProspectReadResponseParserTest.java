package com.darksci.pardot.api.parser.prospect;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.prospect.Prospect;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ProspectReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ProspectReadResponseParserTest.class);

    /**
     * Validates we can parse an Account Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("prospectRead.xml");
        final Prospect response = new ProspectReadResponseParser().parseResponse(input);
        logger.info("Result: {}", response);
    }

}