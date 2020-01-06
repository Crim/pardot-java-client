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
import com.darksci.pardot.api.response.user.NewUser;
import org.joda.time.DateTimeZone;

/**
 * For creating new Users using Pardot's API.
 * No update end point appears to exist :/
 */
public class UserCreateRequest extends BaseRequest<UserCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "user/do/create";
    }

    /**
     * Define the user you want to create in pardot.
     * @param user The user you want to create in pardot.
     * @return CampaignCreateRequest builder.
     */
    public UserCreateRequest withUser(final NewUser user) {
        this
            // Identifying fields
            .withEmail(user.getEmail())

            // Default fields
            .withFirstName(user.getFirstName())
            .withLastName(user.getLastName())
            .withJobTitle(user.getJobTitle())
            .withPhone(user.getPhone())
            .withUrl(user.getUrl())
            .withPasswordExpireable(user.isPasswordExpirable());

        // Determine if role is being passed as a name or id.
        if (user.getRoleId() != null) {
            // RoleId is not null, so let's use that.
            withRole(user.getRoleId());
        } else if (user.getRole() != null) {
            // Role Name is not null, so lets use that.
            withRole(user.getRole());
        }

        // Optional Timezone
        if (user.getTimezone() != null) {
            withTimezone(user.getTimezone());
        }
        // Optional Crm Username.
        if (user.getCrmUsername() != null && user.getCrmUsername().trim().length() > 0) {
            withCrmUsername(user.getCrmUsername());
        }

        return this;
    }

    /**
     * Define the Email field on the user.
     *
     * @param email email address of user.
     * @return UserCreateRequet builder.
     */
    public UserCreateRequest withEmail(final String email) {
        return setParam("email", email);
    }

    /**
     * API only accepts an email address for the new user, and uses that value as
     * the username.  There exists no way to define a username other than by email address.
     *
     * @param email email address of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withUsername(final String email) {
        return withEmail(email);
    }

    /**
     * Define the First Name field on the user.
     *
     * @param firstName first_name of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withFirstName(final String firstName) {
        return setParam("first_name", firstName);
    }

    /**
     * Define the Last Name field on the user.
     *
     * @param lastName last name of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withLastName(final String lastName) {
        return setParam("last_name", lastName);
    }

    /**
     * Define the Job Title field on the user.
     *
     * @param jobTitle job title of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withJobTitle(final String jobTitle) {
        return setParam("job_title", jobTitle);
    }

    /**
     * Define the Role field on the user by the role's id.
     *
     * @param roleId roleId for new user.
     * @return UserCreateRequest builder.
     * @deprecated see withRole(Long)
     */
    public UserCreateRequest withRoleId(final Long roleId) {
        return withRole(roleId);
    }

    /**
     * Define the Role field on the user by name of the role.
     *
     * @param roleName name of the role for new user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withRole(final String roleName) {
        // If roleName was passed
        if (roleName != null ) {
            // Clear out role_id property.
            setParam("role_id", null);
        }
        return setParam("role_name", roleName);
    }

    /**
     * Define the Role field on the user by name of the role.
     *
     * @param roleId id of the role for new user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withRole(final Long roleId) {
        // If roleId was passed
        if (roleId != null) {
            // Clear out role_name property.
            setParam("role_name", null);
        }
        return setParam("role_id", roleId);
    }

    /**
     * Define the Phone field on the user.
     *
     * @param phone phone of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withPhone(final String phone) {
        return setParam("phone", phone);
    }

    /**
     * Define the URL field on the user.
     *
     * @param url url of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withUrl(final String url) {
        return setParam("url", url);
    }

    /**
     * Define if the User's password should expire.
     *
     * @param isExpirable does the users password expire?
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withPasswordExpireable(final Boolean isExpirable) {
        return setBooleanParam("is_password_expirable", isExpirable);
    }

    /**
     * Define the Timezone field on the user.
     *
     * @param timezoneString timezone for the user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withTimezone(final String timezoneString) {
        return setParam("timezone", timezoneString);
    }

    /**
     * Define the Timezone field on the user.
     *
     * @param dateTimeZone timezone for the user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withTimezone(final DateTimeZone dateTimeZone) {
        return withTimezone(dateTimeZone.getID());
    }

    /**
     * Define the CRM User field on the user.
     *
     * @param crmUsername crm username for the user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withCrmUsername(final String crmUsername) {
        return setParam("crm_username", crmUsername);
    }

    /**
     * Should Pardot send the activation email to the new user on creation?
     * Defaults to true if not explicitly defined.
     *
     * @param sendEmail should Pardot send the activation email.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withSendActivationEmail(final boolean sendEmail) {
        return setBooleanParam("send_activation", sendEmail);
    }
}
