/**
 * Copyright 2017, 2018 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.response.customfield;

import com.darksci.pardot.api.parser.PardotBooleanSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.joda.time.DateTime;

/**
 * Represents a Pardot CustomField record.
 */
public class CustomField {
    private Long id;
    private String name;
    private String fieldId;
    private String type;
    private Integer typeId;
    private String crmId;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "is_record_multiple_responses")
    private boolean isRecordMultipleResponses = false;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "is_use_values")
    private boolean isUseValues = false;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(final String fieldId) {
        this.fieldId = fieldId;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(final Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * Field type of the CustomField.
     *
     * @return Enum representing field type.
     */
    public CustomFieldType getFieldtype() {
        return CustomFieldType.fromValue(getTypeId());
    }

    /**
     * Set field type properties from Enum.
     * @param fieldType Enum to use to set properties.
     */
    public void setFieldType(final CustomFieldType fieldType) {
        if (fieldType == null) {
            setType(null);
            setTypeId(null);
        } else {
            setType(fieldType.getName());
            setTypeId(fieldType.getValue());
        }
    }

    public String getCrmId() {
        return crmId;
    }

    public void setCrmId(final String crmId) {
        this.crmId = crmId;
    }

    public boolean isRecordMultipleResponses() {
        return isRecordMultipleResponses;
    }

    public void setRecordMultipleResponses(final boolean recordMultipleResponses) {
        isRecordMultipleResponses = recordMultipleResponses;
    }

    public boolean isUseValues() {
        return isUseValues;
    }

    public void setUseValues(final boolean useValues) {
        isUseValues = useValues;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "CustomField{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", fieldId='" + fieldId + '\''
            + ", type='" + type + '\''
            + ", typeId=" + typeId
            + ", fieldtype=" + getFieldtype()
            + ", crmId='" + crmId + '\''
            + ", isRecordMultipleResponses=" + isRecordMultipleResponses
            + ", isUseValues=" + isUseValues
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + '}';
    }
}
