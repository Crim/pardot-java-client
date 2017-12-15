/**
 * Copyright 2017 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.response.visitor;

import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Pardot visitor.
 */
public class Visitor {
    private Long id;
    private Long prospectId;
    private Integer pageViewCount = 0;
    private String ipAddress;
    private String hostname;
    private String campaignParameter;
    private String mediumParameter;
    private String sourceParameter;
    private String contentParameter;
    private String termParameter;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @JacksonXmlElementWrapper(localName = "visitor_activities")
    private List<VisitorActivity> visitorActivities;

    public Long getId() {
        return id;
    }

    public Long getProspectId() {
        return prospectId;
    }

    public Integer getPageViewCount() {
        if (pageViewCount == null) {
            return 0;
        }
        return pageViewCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getHostname() {
        return hostname;
    }

    public String getCampaignParameter() {
        return campaignParameter;
    }

    public String getMediumParameter() {
        return mediumParameter;
    }

    public String getSourceParameter() {
        return sourceParameter;
    }

    public String getContentParameter() {
        return contentParameter;
    }

    public String getTermParameter() {
        return termParameter;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<VisitorActivity> getVisitorActivities() {
        if (visitorActivities == null) {
            return new ArrayList<>();
        }
        return visitorActivities;
    }

    @Override
    public String toString() {
        return "Visitor{"
            + "id=" + id
            + ", prospectId=" + prospectId
            + ", pageViewCount=" + pageViewCount
            + ", ipAddress='" + ipAddress + '\''
            + ", hostname='" + hostname + '\''
            + ", campaignParameter='" + campaignParameter + '\''
            + ", mediumParameter='" + mediumParameter + '\''
            + ", sourceParameter='" + sourceParameter + '\''
            + ", contentParameter='" + contentParameter + '\''
            + ", termParameter='" + termParameter + '\''
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + ", visitorActivities=" + visitorActivities
            + '}';
    }
}
