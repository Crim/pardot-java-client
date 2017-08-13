package com.darksci.pardot.api.parser;

import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Base Test class to abstract common code.
 */
public abstract class BaseResponseParserTest {

    /**
     * Utility method to help load mock responses from resources.
     * @param fileName file name to load from resources
     * @return The contents of the file, as a UTF-8 string.
     * @throws IOException on error reading from resource file.
     */
    public String readFile(final String fileName) throws IOException {
        final URL inputFile = getClass().getClassLoader().getResource("mockResponses/" + fileName);
        return IOUtils.toString(inputFile, Charsets.UTF_8);
    }
}
