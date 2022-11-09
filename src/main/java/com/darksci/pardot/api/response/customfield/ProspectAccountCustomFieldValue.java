package com.darksci.pardot.api.response.customfield;



import com.darksci.pardot.api.parser.prospectaccount.ProspectAccountCustomFieldDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
* Represents a Prospect CustomField value.
* Since custom fields can be stored as a single value, or as a list of values (for record multiple fields),
* this attempts to normalize the way these two types are accessed.
*/
@JsonDeserialize(using = ProspectAccountCustomFieldDeserializer.class)
public class ProspectAccountCustomFieldValue {private final String fieldName;
private final List<String> values = new ArrayList<>();

/**
* Constructor for custom field which only has a single value.
* @param fieldName name of the field.
* @param value value of the field.
*/
public ProspectAccountCustomFieldValue(final String fieldName, final String value) {
  this.fieldName = fieldName;
  if (value != null) {
      this.values.add(value);
  }
}

/**
* Constructor for custom field which has multiple values.
* @param fieldName name of the field.
* @param values values for the field.
*/
public ProspectAccountCustomFieldValue(final String fieldName, final Collection<String> values) {
  this.fieldName = fieldName;
  if (values != null) {
      this.values.addAll(values);
  }
}

public String getFieldName() {
  return fieldName;
}

/**
* The value of the custom field.
* @return value of the custom field.
*         *NOTE* If this is a record multiple field with multiple values, this will return the first value only.
*/
public String getValue() {
  if (values.isEmpty()) {
      return null;
  }
  if (values != null)
  {
	  return values.get(0);
  }
  else return null;
}

public List<String> getValues() {
  return values;
}

public boolean hasMultipleValues() {
  return getValues().size() > 1;
}

public void addValue(final String value) {
  values.add(value);
}

public void addValues(final Collection<String> values) {
  values.addAll(values);
}

public void setValue(final String value) {
  values.clear();
  addValue(value);
}

public void setValues(final Collection<String> values) {
  values.clear();
  addValues(values);
}

@Override
public String toString() {
  return "ProspectCustomFieldValue{"
      + "fieldName='" + fieldName + '\''
      + ", values=" + values
      + '}';
}
}

