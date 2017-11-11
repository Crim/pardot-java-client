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

package com.darksci.pardot.api.request.user;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a User read request.
 */
public class UserReadRequest extends BaseRequest<UserReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "user/do/read";
    }

    /**
     * Returns the data for the user specified by email.
     * @param email The email address of the target user.
     * @return UserReadRequest builder.
     */
    public UserReadRequest selectByEmail(final String email) {
        if (email != null) {
            selectById(null);
        }
        return setParam("email", email);
    }

    /**
     * Returns the data for the user specified by id.
     * @param id The Pardot ID of the target user.
     * @return UserReadRequest builder.
     */
    public UserReadRequest selectById(final Long id) {
        if (id != null) {
            selectByEmail(null);
        }
        return setParam("id", id);
    }
}
