package com.darksci.pardot.api.response.prospectaccount;


import com.darksci.pardot.api.parser.prospect.ProspectCustomFieldDeserializer;
import com.darksci.pardot.api.response.customfield.ProspectAccountCustomFieldValue;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.joda.time.LocalDateTime;

public class ProspectAccount {
	 private Long id;
	 private String name;
	 
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private LocalDateTime createdAt;
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private LocalDateTime updatedAt;
	    
	 // Custom fields
	    @JsonDeserialize(using = ProspectCustomFieldDeserializer.class)
	    private Map<String, ProspectAccountCustomFieldValue> customFields = new HashMap<>();
	    
	    
	    public Long getId() {
	        return id;
	    }
	    public String getName() {
	        return name;
	    }
	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

	    public LocalDateTime getUpdatedAt() {
	        return updatedAt;
	    }
	    /**
	     * Get all CustomFields defined on the prospect.
	     * @return Map of all CustomFields.
	     */
	    @JsonAnyGetter
	    public Map<String, ProspectAccountCustomFieldValue> getCustomFields() {
	        return customFields;
	    }
	    /**
	     * Utility method to get custom field value.
	     *
	     * @param customFieldName Field to retrieve value for.
	     * @return Value of the custom field.
	     */
	    public String getCustomField(final String customFieldName) {
	        if (!hasCustomField(customFieldName)|| (customFields.get(customFieldName)==null)) {
	            return null;
	        }
	        return customFields.get(customFieldName).getValue();
	    }

	    /**
	     * Utility method to get custom field values for record multiple custom fields.
	     * @param customFieldName Field to retrieve values for.
	     * @return List of all values.
	     */
	    public List<String> getCustomFieldValues(final String customFieldName) {
	        if (!hasCustomField(customFieldName)) {
	            return new ArrayList<>();
	        }
	        return customFields.get(customFieldName).getValues();
	    }

	    /**
	     * Set a custom fields value.
	     * @param fieldName name of custom field to set.
	     * @param fieldValue value to set custom field to.
	     */
	    public void setCustomField(final String fieldName, final String fieldValue) {
	        setCustomField(new ProspectAccountCustomFieldValue(fieldName, fieldValue));
	    }

	    /**
	     * For record multiple custom field values, set multiple values for the field.
	     * @param fieldName name of custom field to set.
	     * @param fieldValues values to set custom field to.
	     */
	    public void setCustomField(final String fieldName, final Collection<String> fieldValues) {
	        setCustomField(new ProspectAccountCustomFieldValue(fieldName, fieldValues));
	    }

	    /**
	     * Set custom field value.
	     * @param value value of custom field to set.
	     */
	    public void setCustomField(final ProspectAccountCustomFieldValue value) {
	        Objects.requireNonNull(value);
	        Objects.requireNonNull(value.getFieldName(), "Field name may not be null.");
	        setCustomField(value.getFieldName(), value);
	    }

	    /**
	     * Protected internal method for deserializing server responses.
	     * @param fieldName name of the custom field.
	     * @param value value of the custom field.
	     */
	    @JsonAnySetter
	    protected void setCustomField(final String fieldName, final ProspectAccountCustomFieldValue value) {
	        Objects.requireNonNull(fieldName, "FieldName may not be null.");
	        customFields.put(fieldName, value);
	    }

	    /**
	     * Is there a custom field set on the prospect.
	     * @param fieldName name of the field to check.
	     * @return true if it exists, false if not.
	     */
	    public boolean hasCustomField(final String fieldName) {
	        return customFields.containsKey(fieldName);
	    }

	    /**
	     * Remove a custom field from the prospect.
	     * @param fieldName name of the field to remove.
	     */
	    public void removeCustomField(final String fieldName) {
	        if (hasCustomField(fieldName)) {
	            customFields.remove(fieldName);
	        }
	    }

	    /**
	     * Append a new custom field value to a record multiple custom field.
	     * @param fieldName name of the custom field to append a value to.
	     * @param value value to append.
	     */
	    public void appendCustomFieldValue(final String fieldName, final String value) {
	        if (hasCustomField(fieldName)) {
	            customFields.get(fieldName).addValue(value);
	            return;
	        }
	        setCustomField(fieldName, new ProspectAccountCustomFieldValue(fieldName, value));
	    }
	    // Setters
	    public void setId(final Long id) {
	        this.id = id;
	    }
	    public void setName(final String name) {
	        this.name = name;
	    }
	    public void setCreatedAt(final LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }

	    public void setUpdatedAt(final LocalDateTime updatedAt) {
	        this.updatedAt = updatedAt;
	    }
}
