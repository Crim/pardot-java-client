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
            .withRoleId(user.getRoleId())
            .withPhone(user.getPhone())
            .withUrl(user.getUrl())
            .withPasswordExpireable(user.isPasswordExpirable());

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
     * @param email email address of user.
     * @return UserCreateRequet builder.
     */
    public UserCreateRequest withEmail(final String email) {
        setParam("email", email);
        return this;
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
     * @param firstName first_name of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withFirstName(final String firstName) {
        setParam("first_name", firstName);
        return this;
    }

    /**
     * @param lastName last name of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withLastName(final String lastName) {
        setParam("last_name", lastName);
        return this;
    }

    /**
     * @param jobTitle job title of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withJobTitle(final String jobTitle) {
        setParam("job_title", jobTitle);
        return this;
    }

    /**
     * @param roleId roleId for new user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withRoleId(final Long roleId) {
        return setParam("role", roleId);
    }

    /**
     * @param phone phone of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withPhone(final String phone) {
        setParam("phone", phone);
        return this;
    }

    /**
     * @param url url of user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withUrl(final String url) {
        setParam("url", url);
        return this;
    }

    /**
     * @param isExpirable does the users password expire?
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withPasswordExpireable(final Boolean isExpirable) {
        setBooleanParam("is_password_expirable", isExpirable);
        return this;
    }

    /**
     * @param timezoneString timezone for the user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withTimezone(final String timezoneString) {
        setParam("timezone", timezoneString);
        return this;
    }

    /**
     * @param dateTimeZone timezone for the user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withTimezone(final DateTimeZone dateTimeZone) {
        withTimezone(dateTimeZone.getID());
        return this;
    }

    /**
     * @param crmUsername crm username for the user.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withCrmUsername(final String crmUsername) {
        setParam("crm_username", crmUsername);
        return this;
    }

    /**
     * Should Pardot send the activation email to the new user on creation?
     * Defaults to true if not explicitly defined.
     *
     * @param sendEmail should Pardot send the activation email.
     * @return UserCreateRequest builder.
     */
    public UserCreateRequest withSendActivationEmail(final boolean sendEmail) {
        setBooleanParam("send_activation", sendEmail);
        return this;
    }
}
