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

package com.darksci.pardot.api.response.emailtemplate;

/**
 * Represents EmailTemplate.Type field values.
 */
public enum EmailTemplateType {
    UNKNOWN(-1L),
    TEXT_ONLY(0L),
    HTML_ONLY(1L),
    TEXT_AND_HTML(2L);

    private final long value;

    /**
     * Constructor.
     * @param value value of enum.
     */
    EmailTemplateType(final long value) {
        this.value = value;
    }

    /**
     * Factory method.
     * @param value Value stored.
     * @return Enum representation of that value.
     */
    public static EmailTemplateType fromValue(final Long value) {
        if (value == 0L) {
            return TEXT_ONLY;
        } else if (value == 1L) {
            return HTML_ONLY;
        } else if (value == 2L) {
            return TEXT_AND_HTML;
        }
        return UNKNOWN;
    }
}
