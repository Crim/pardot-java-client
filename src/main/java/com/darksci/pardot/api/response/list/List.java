/**
 * Copyright 2017 Stephen Powis
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
