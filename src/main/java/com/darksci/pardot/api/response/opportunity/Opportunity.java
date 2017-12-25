package com.darksci.pardot.api.response.opportunity;

import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.joda.time.DateTime;

import java.util.Collections;
import java.util.List;

/**
 * Represents a Pardot Opportunity.
 */
public class Opportunity {
    private Long id;
    private String name;
    private Integer value;
    private Integer probability;
    private String type;
    private String stage;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime updatedAt;
    
    // Foreign Objects
    private Campaign campaign;

    @JacksonXmlProperty(localName = "prospects")
    private Prospects prospects = new Prospects();

    @JacksonXmlProperty(localName = "opportunity_activities")
    private OpportunityActivities opportunityActivities = new OpportunityActivities();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getProbability() {
        return probability;
    }

    public Integer getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getStage() {
        return stage;
    }

    public String getStatus() {
        return status;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public List<Prospect> getProspects() {
        if (prospects == null) {
            prospects = new Prospects();
        }
        return prospects.getProspects();
    }

    public List<VisitorActivity> getOpportunityActivities() {
        if (opportunityActivities == null) {
            opportunityActivities = new OpportunityActivities();
        }
        return opportunityActivities.getVisitorActivities();
    }

    /**
     * Wrapper class around Prospects.
     */
    private static class Prospects {
        @JacksonXmlProperty(localName = "prospect")
        private List<Prospect> prospects = Collections.emptyList();

        private List<Prospect> getProspects() {
            if (prospects == null) {
                prospects = Collections.emptyList();
            }
            return Collections.unmodifiableList(prospects);
        }
    }

    /**
     * Wrapper class around Activities.
     */
    private static class OpportunityActivities {
        @JacksonXmlProperty(localName = "visitor_activity")
        private List<VisitorActivity> visitorActivities = Collections.emptyList();

        private List<VisitorActivity> getVisitorActivities() {
            if (visitorActivities == null) {
                visitorActivities = Collections.emptyList();
            }
            return Collections.unmodifiableList(visitorActivities);
        }
    }

    @Override
    public String toString() {
        return "Opportunity{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", value='" + value + '\''
            + ", probability=" + probability
            + ", type='" + type + '\''
            + ", stage='" + stage + '\''
            + ", status='" + status + '\''
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + ", campaign=" + campaign
            + ", prospects=" + getProspects()
            + ", opportunityActivities=" + getOpportunityActivities()
            + '}';
    }
}
