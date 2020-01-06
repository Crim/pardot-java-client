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

package com.darksci.pardot.api.request.user;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.user.User;

/**
 * Defines request to update a Pardot User's role.
 *
 * It appears as tho the API today only supports updating the role field of a user over the API,
 * and does not support updating any other fields??
 */
public class UserUpdateRoleRequest extends BaseRequest<UserUpdateRoleRequest> {
    @Override
    public String getApiEndpoint() {
        return "user/do/update";
    }

    /**
     * Define the User you want to update in pardot.
     *
     * @param user The user you want to update in pardot.
     * @return UserUpdateRequest builder.
     */
    public UserUpdateRoleRequest withUser(final User user) {
        return withUserId(user.getId())
            .withRoleName(user.getRole());
    }

    /**
     * Define the User you want to update in pardot using their Email address.
     *
     * @param email The user's email you want to update in pardot.
     * @return UserUpdateRequest builder.
     */
    public UserUpdateRoleRequest withUserEmail(final String email) {
        setParam("id", null);
        return setParam("email", email);
    }

    /**
     * Define the User you want to update in pardot using their Email address.
     *
     * @param userId The user's id you want to update in pardot.
     * @return UserUpdateRequest builder.
     */
    public UserUpdateRoleRequest withUserId(final Long userId) {
        setParam("id", userId);
        return setParam("email", null);
    }

    /**
     * Define the role you want to assign to the user in Pardot.
     *
     * @param roleId The Id of the role you want to assign to the user.
     * @return UserUpdateRequest builder.
     */
    public UserUpdateRoleRequest withRoleId(final Long roleId) {
        setParam("role_name", null);
        return setParam("role_id", roleId);
    }

    /**
     * Define the role you want to assign to the user in Pardot.
     *
     * @param roleName The name of the role you want to assign to the user.
     * @return UserUpdateRequest builder.
     */
    public UserUpdateRoleRequest withRoleName(final String roleName) {
        setParam("role_name", roleName);
        return setParam("role_id", null);
    }
}
