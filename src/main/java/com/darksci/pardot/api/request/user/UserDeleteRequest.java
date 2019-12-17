/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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
 * For deleting existing users from Pardot.
 */
public class UserDeleteRequest extends BaseRequest<UserDeleteRequest> {
    @Override
    public String getApiEndpoint() {
        return "user/do/delete";
    }

    /**
     * Returns the data for the user specified by email.
     * @param email The email address of the target user.
     * @return UserDeleteRequest builder.
     */
    public UserDeleteRequest deleteByEmail(final String email) {
        if (email != null) {
            deleteById(null);
        }
        return setParam("email", email);
    }

    /**
     * Returns the data for the user specified by id.
     * @param userId The Pardot ID of the target user to delete
     * @return UserDeleteRequest builder.
     */
    public UserDeleteRequest deleteById(final Long userId) {
        if (userId != null) {
            deleteByEmail(null);
        }
        return setParam("id", userId);
    }
}