package com.darksci.pardot.api.response.list;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

/**
 * Represents a Pardot List.
 */
public class List {
    private Long id;
    private String name;
    private String title;
    private String description;
    private Boolean isPublic;
    private Boolean isDynamic;
    private Boolean isCrmVisible;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public Boolean getDynamic() {
        return isDynamic;
    }

    public Boolean getCrmVisible() {
        return isCrmVisible;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "List{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", title='" + title + '\''
            + ", description='" + description + '\''
            + ", isPublic=" + isPublic
            + ", isDynamic=" + isDynamic
            + ", isCrmVisible=" + isCrmVisible
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + '}';
    }
}
