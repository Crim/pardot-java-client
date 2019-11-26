/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Converts values to boolean.
 *
 * False values: NULL, emptyString, NO, FALSE, 0
 * True values: all others.
 */
public class PardotBooleanSerializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        final String value = jsonParser.getText();

        // Null => false
        // Empty string => false
        if (value == null || value.isEmpty()) {
            return false;
        }

        // Make all lower case
        final String normalizedValue = value.toLowerCase();

        // No, false, and 0 => false
        if (normalizedValue.equals("no") || normalizedValue.equals("false") || normalizedValue.equals("0")) {
            return false;
        }

        // All others defaulted to true
        return true;
    }
}
