package com.darksci.pardot.api.response.customredirect;

import com.darksci.pardot.api.response.campaign.Campaign;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

/**
 * Represents a Pardot Custom Redirect.
 */
public class CustomRedirect {
    private Long id;
    private String name;
    private String url;
    private String destinationUrl;
    private Campaign campaign;
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

    public String getUrl() {
        return url;
    }

    public String getDestinationUrl() {
        return destinationUrl;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "CustomRedirect{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", url='" + url + '\''
            + ", destinationUrl='" + destinationUrl + '\''
            + ", campaign=" + campaign
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + '}';
    }
}
