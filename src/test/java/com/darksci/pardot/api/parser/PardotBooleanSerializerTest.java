package com.darksci.pardot.api.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(DataProviderRunner.class)
public class PardotBooleanSerializerTest {

    @Test
    @UseDataProvider("provideBooleanValues")
    public void testTrueValues(final Object value, final boolean expectedResult) throws IOException {
        // Setup a mock
        JsonParser mockParser = mock(JsonParser.class);
        if (value == null) {
            when(mockParser.getText()).thenReturn(null);
        } else {
            when(mockParser.getText()).thenReturn(value.toString());
        }


        boolean result = new PardotBooleanSerializer().deserialize(mockParser, null);
        assertEquals("Should match expected result for input: " + value, expectedResult, result);
    }

    /**
     * Provides invalid upsertKeyField values.
     */
    @DataProvider
    public static Object[][] provideBooleanValues() {
        return new Object[][]{
            // False values
            { "0", false },
            { 0, false },
            { "", false },
            { null, false },
            { "no", false },
            { "NO", false },
            { "nO", false },
            { "false", false },
            { "FALSE", false },
            { "False", false },
            { "faLse", false },

            // True values
            { "1", true },
            { 1, true },
            { "yes", true },
            { "YES", true },
            { "yEs", true },
            { "true", true },
            { "TRUE", true },
            { "True", true },
            { "trUe", true },

            // Other random values default to true
            { "1000", true },
            { 1000, true },
            { "ABC", true },
        };
    }

}