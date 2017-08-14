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
