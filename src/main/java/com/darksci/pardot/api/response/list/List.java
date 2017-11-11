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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public Boolean getIsDynamic() {
        return isDynamic;
    }

    public Boolean getIsCrmVisible() {
        return isCrmVisible;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setPublic(final Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setDynamic(final Boolean dynamic) {
        isDynamic = dynamic;
    }

    public void setCrmVisible(final Boolean crmVisible) {
        isCrmVisible = crmVisible;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
