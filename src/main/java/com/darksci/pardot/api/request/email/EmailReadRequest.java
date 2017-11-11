/**
 * Copyright 2017 Stephen Powis
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

package com.darksci.pardot.api.request.email;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a User read request.
 */
public class EmailReadRequest extends BaseRequest<EmailReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "email/do/read";
    }


    public EmailReadRequest selectById(final Long id) {
        return setParam("id", id);
    }

    /**
     * When set to false, the email will not include the html nor text body message.
     * Defaults to true.
     * @param includeMessage Should the response include the html and text bodies.
     * @return EmailReadRequest builder.
     */
    public EmailReadRequest withIncludeMessageInResponse(boolean includeMessage) {
        String value = "true";
        if (!includeMessage) {
            value = "false";
        }
        return setParam("include_message", value);
    }
}
