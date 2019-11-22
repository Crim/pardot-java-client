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

package com.darksci.pardot.api.response.user;

import org.joda.time.DateTimeZone;

/**
 * Represents a User for the Create endpoint.
 */
public class NewUser {

    private String email;
    private String firstName;
    private String lastName;
    private String jobTitle;

    // Role can be set EITHER by Id or Name.
    private Long roleId;
    private String role;

    private String phone = null;
    private String url = null;
    private DateTimeZone timezone = null;
    private boolean isPasswordExpirable = false;
    private String crmUsername = null;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(final String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(final Long roleId) {
        this.roleId = roleId;

        // Null out role name.
        if (roleId != null) {
            this.role = null;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;

        // Null out roleId
        if (role != null) {
            roleId = null;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public DateTimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(final DateTimeZone timezone) {
        this.timezone = timezone;
    }

    public boolean isPasswordExpirable() {
        return isPasswordExpirable;
    }

    public void setPasswordExpirable(final boolean passwordExpirable) {
        isPasswordExpirable = passwordExpirable;
    }

    public String getCrmUsername() {
        return crmUsername;
    }

    public void setCrmUsername(final String crmUsername) {
        this.crmUsername = crmUsername;
    }

    @Override
    public String toString() {
        return "NewUser{"
            + ", email='" + email + '\''
            + ", firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", jobTitle='" + jobTitle + '\''
            + ", roleId='" + roleId + '\''
            + ", phone='" + phone + '\''
            + ", url='" + url + '\''
            + ", timezone=" + timezone
            + ", isPasswordExpirable=" + isPasswordExpirable
            + ", crmUsername='" + crmUsername + '\''
            + '}';
    }
}
