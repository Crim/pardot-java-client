/**
 * Copyright 2017 Stephen Powis https://github.com/Crim/pardot-java-client
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