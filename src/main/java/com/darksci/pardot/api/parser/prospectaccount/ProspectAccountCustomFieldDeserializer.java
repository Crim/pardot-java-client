package com.darksci.pardot.api.parser.prospectaccount;

import com.darksci.pardot.api.response.customfield.ProspectAccountCustomFieldValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Custom deserializer to be able to support Record Multiple custom fields.
*/
public class ProspectAccountCustomFieldDeserializer extends StdDeserializer<ProspectAccountCustomFieldValue> {

  /**
   * Constructor.
   */
  public ProspectAccountCustomFieldDeserializer() {
      this(null);
  }

  /**
   * Constructor.
   * @param vc the type of the class this handles.
   */
  public ProspectAccountCustomFieldDeserializer(final Class<?> vc) {
      super(vc);
  }

  @Override
  public ProspectAccountCustomFieldValue deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
      // Get the current custom field name.
      final String fieldName = parser.getCurrentName();

      // Keep track of all the values associated with the field.
      final List<String> fieldValues = new ArrayList<>();

      // If we have multiple values
      if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
          // Loop until we hit end object
          while (parser.nextToken() != JsonToken.END_OBJECT) {
              // Pull out each value
              if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                  fieldValues.add(parser.getValueAsString());
              }
          }
      } else if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
          // If we have a single value, we just record the value as is.
          fieldValues.add(parser.getValueAsString());
      }

      // Return our deserialized instance.
      return new ProspectAccountCustomFieldValue(fieldName, fieldValues);
  }
}