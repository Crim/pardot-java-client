package com.pardot.api.request.user;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class User {

    private Long id;
    private Long account;
    private String email;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String role;
    private String createdAt;
    private String updatedAt;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public Long getAccount() {
        return account;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getRole() {
        return role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", account=" + account +
            ", email='" + email + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", jobTitle='" + jobTitle + '\'' +
            ", role='" + role + '\'' +
            ", createdAt='" + createdAt + '\'' +
            ", updatedAt='" + updatedAt + '\'' +
            '}';
    }
}
