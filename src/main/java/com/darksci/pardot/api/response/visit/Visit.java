/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.response.visit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Pardot visit.
 */
public class Visit {
    private Long id;
    private Long visitorId;
    private Long prospectId;
    private Integer visitorPageViewCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime firstVisitorPageViewAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastVisitorPageViewAt;
    private Integer durationInSeconds;
    private String campaignParameter;
    private String mediumParameter;
    private String sourceParameter;
    private String contentParameter;
    private String termParameter;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @JacksonXmlElementWrapper(localName = "visitor_page_views")
    private List<VisitorPageView> visitorPageViews;

    public Long getId() { return id; }

    public Long getVisitorId() { return visitorId; }

    public Long getProspectId() { return prospectId; }

    public Integer getVisitorPageViewCount() { return visitorPageViewCount; }

    public LocalDateTime getFirstVisitorPageViewAt() { return firstVisitorPageViewAt; }

    public LocalDateTime getLastVisitorPageViewAt() { return lastVisitorPageViewAt; }

    public Integer getDurationInSeconds() { return durationInSeconds; }

    public String getCampaignParameter() { return campaignParameter; }

    public String getMediumParameter() { return mediumParameter; }

    public String getSourceParameter() { return sourceParameter; }

    public String getContentParameter() { return contentParameter; }

    public String getTermParameter() { return termParameter; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    /**
     * Visitor Page Views associated to the visit, or empty list if none.
     *
     * @return Associated Visitor Page Views, or empty list if none.
     */
    public List<VisitorPageView> getVisitorPageViews() {
        if (visitorPageViews == null) {
            return new ArrayList<>();
        }
        return visitorPageViews;
    }

    @Override
    public String toString() {
        return "Visitor{"
            + "id=" + id
            + ", visitorId=" + visitorId
            + ", prospectId=" + prospectId
            + ", visitorPageViewCount=" + visitorPageViewCount
            + ", firstVisitorPageViewAt=" + firstVisitorPageViewAt
            + ", lastVisitorPageViewAt=" + lastVisitorPageViewAt
            + ", durationInSeconds=" + durationInSeconds
            + ", campaignParameter='" + campaignParameter + '\''
            + ", mediumParameter='" + mediumParameter + '\''
            + ", sourceParameter='" + sourceParameter + '\''
            + ", contentParameter='" + contentParameter + '\''
            + ", termParameter='" + termParameter + '\''
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + '}';
    }
}
