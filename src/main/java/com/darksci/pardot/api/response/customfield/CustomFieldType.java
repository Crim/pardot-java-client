/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
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

/**
 * Enum Representing Custom Field types.
 */
public enum CustomFieldType {
    UNKNOWN(0, "UNKNOWN"),
    TEXT(1, "Text"),
    RADIO_BUTTON(2, "Radio Button"),
    CHECKBOX(3, "Checkbox"),
    DROPDOWN(4, "Dropdown"),
    TEXTAREA(5, "Text Area"),
    MULTI_SELECT(6, "Multi-Select"),
    HIDDEN(7, "Hidden"),
    NUMBER(8, "Number"),
    EMAIL(9, "Email"),
    EMAIL_VALID_MX(10, "Email with valid MX record"),
    EMAIL_NON_FREE(11, "Email from non-free provider"),
    DATE(12, "Date"),
    RELATIONAL(13, "Relational"),
    CRM_USER(14, "CRM User");

    private final int value;
    private final String name;

    CustomFieldType(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Human-readable/display name for the field type.
     *
     * @return Display name for field type.
     */
    public String getName() {
        return name;
    }

    /**
     * Internal integer value for the field type.
     *
     * @return Integer value of type.
     */
    public int getValue() {
        return value;
    }

    /**
     * Given a type value, return the appropriate enum representing it.
     * @param value value of type.
     * @return Enum.
     */
    public static CustomFieldType fromValue(final Integer value) {
        if (value == null) {
            return UNKNOWN;
        }

        switch (value) {
            case 1:
                return TEXT;
            case 2:
                return RADIO_BUTTON;
            case 3:
                return CHECKBOX;
            case 4:
                return DROPDOWN;
            case 5:
                return TEXTAREA;
            case 6:
                return MULTI_SELECT;
            case 7:
                return HIDDEN;
            case 8:
                return NUMBER;
            case 9:
                return EMAIL;
            case 10:
                return EMAIL_VALID_MX;
            case 11:
                return EMAIL_NON_FREE;
            case 12:
                return DATE;
            case 13:
                return RELATIONAL;
            case 14:
                return CRM_USER;
            default:
                return UNKNOWN;
        }
    }
}
