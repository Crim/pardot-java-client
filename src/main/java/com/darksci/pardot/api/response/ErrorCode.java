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

package com.darksci.pardot.api.response;

/**
 * List of Pardot API Response Error Codes.
 *
 * Incomplete List.
 */
public enum ErrorCode {
    // Returned if API Session becomes invalid.
    INVALID_API_OR_USER_KEY(1),
    INVALID_ACTION(2),
    INVALID_PROSPECT_ID(3),
    INVALID_PROSPECT_EMAIL_ADDRESS(4),
    INVALID_USER_ID(10),
    INVALID_ID(11),
    // Returned if authentication credentials are invalid.
    LOGIN_FAILED(15),
    INVALID_CAMPAIGN_ID(38),
    EMAIL_ADDRESS_IS_ALREADY_IN_USE(54),
    INVALID_LIST_ID(55),
    INVALID_EMAIL_FORMAT(65),
    // Returned if requested with API Version 3, but required to use Version 4.
    WRONG_API_VERSION(88);

    private final int code;

    ErrorCode(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}