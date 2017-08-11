package com.pardot.api.rest.responses.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getUpdatedAt() {
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
