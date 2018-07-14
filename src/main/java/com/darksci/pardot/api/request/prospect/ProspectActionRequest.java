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
package com.darksci.pardot.api.request.prospect;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Represents a request to perform an action against a specific prospect, either by
 * Id or Email address.
 */
abstract class ProspectActionRequest<T> extends BaseRequest<T> {

    /**
     * Define which prospect to perform action on by Id.
     * @param prospectId Id of prospect to delete.
     * @return RequestBuilder
     */
    public T withProspectId(final Long prospectId) {
        setParam("email", null);
        return setParam("id", prospectId);
    }

    /**
     * Define which prospect to perform action on by email.
     * @param email Email of prospect to delete.
     * @return RequestBuilder
     */
    public T withProspectEmail(final String email) {
        setParam("id", null);
        return setParam("email", email);
    }
}
