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
    private Long roleId;

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
        return "NewUser{" +
            ", email='" + email + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", jobTitle='" + jobTitle + '\'' +
            ", roleId='" + roleId + '\'' +
            ", phone='" + phone + '\'' +
            ", url='" + url + '\'' +
            ", timezone=" + timezone +
            ", isPasswordExpirable=" + isPasswordExpirable +
            ", crmUsername='" + crmUsername + '\'' +
            '}';
    }
}
