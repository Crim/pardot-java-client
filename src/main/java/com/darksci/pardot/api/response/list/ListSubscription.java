package com.darksci.pardot.api.response.list;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

/**
 * Represents a membership of a list.
 */
public class ListSubscription {
    private Long id;
    private Boolean didOptIn;
    private Boolean didOptOut;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    private List list;

    public Long getId() {
        return id;
    }

    public Boolean getDidOptIn() {
        return didOptIn;
    }

    public Boolean getDidOptOut() {
        return didOptOut;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ListSubscription{"
            + "id=" + id
            + ", didOptIn=" + didOptIn
            + ", didOptOut=" + didOptOut
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + ", list=" + list
            + '}';
    }
}
