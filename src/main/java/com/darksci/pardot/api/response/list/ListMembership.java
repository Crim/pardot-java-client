package com.darksci.pardot.api.response.list;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

/**
 * Represents a Pardot ListMembership.
 */
public class ListMembership {
    private Long id;
    private Long listId;
    private Long prospectId;
    private Boolean optedOut = false;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(final long listId) {
        this.listId = listId;
    }

    public Long getProspectId() {
        return prospectId;
    }

    public void setProspectId(final long prospectId) {
        this.prospectId = prospectId;
    }

    public Boolean getOptedOut() {
        return optedOut;
    }

    public void setOptedOut(final boolean optedOut) {
        this.optedOut = optedOut;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ListMembership{"
            + "id=" + id
            + ", listId=" + listId
            + ", prospectId=" + prospectId
            + ", optedOut=" + optedOut
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + '}';
    }
}
