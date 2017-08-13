package com.darksci.pardot.api.response.visitoractivity;

import com.darksci.pardot.api.response.campaign.Campaign;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

/**
 * Represents a Pardot Visitor Activity.
 */
public class VisitorActivity {
    private Long id;
    private Integer type;
    private String typeName;
    private String details;
    private Long emailId;
    private Long listEmailId;
    private Campaign campaign;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDetails() {
        return details;
    }

    public Long getEmailId() {
        return emailId;
    }

    public Long getListEmailId() {
        return listEmailId;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "VisitorActivity{"
            + "id=" + id
            + ", type=" + type
            + ", typeName='" + typeName + '\''
            + ", details='" + details + '\''
            + ", emailId=" + emailId
            + ", listEmailId=" + listEmailId
            + ", campaign=" + campaign
            + ", createdAt=" + createdAt
            + '}';
    }
}
