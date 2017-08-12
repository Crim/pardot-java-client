package com.pardot.api.rest.handlers;

import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Base Test class to abstract common code.
 */
public abstract class BaseResponseHandlerTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseResponseHandlerTest.class);

    public String readFile(final String fileName) throws IOException {
        final URL inputFile = getClass().getClassLoader().getResource("mockResponses/" + fileName);
        return IOUtils.toString(inputFile, Charsets.UTF_8);
    }
}
