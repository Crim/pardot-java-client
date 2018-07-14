/**
 * Copyright 2017, 2018 Stephen Powis https://github.com/Crim/pardot-java-client
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
package com.darksci.pardot.api.response.visitoractivity;

import com.darksci.pardot.api.response.campaign.Campaign;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;

/**
 * Represents a Pardot Visitor Activity.
 */
public class VisitorActivity {
    private Long id;

    // Properties
    private Integer type;
    private String typeName;
    private String details;

    // FK References
    private Long visitorId;
    private Long prospectId;
    private Long emailId;
    private Long emailTemplateId;
    private Long fileId;
    private Long formId;
    private Long formHandlerId;
    private Long landingPageId;
    private Long listEmailId;
    private Long siteSearchQueryId;
    private Long multivariateTestVariationId;
    private Long paidSearchId;
    private Long visitorPageViewId;

    // Campaign detail
    private Campaign campaign;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public Long getProspectId() {
        return prospectId;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public VisitorActivityType getActivityType() {
        return VisitorActivityType.fromValue(getType());
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

    public Long getFileId() {
        return fileId;
    }

    public Long getFormId() {
        return formId;
    }

    public Long getFormHandlerId() {
        return formHandlerId;
    }

    public Long getLandingPageId() {
        return landingPageId;
    }

    public Long getEmailTemplateId() {
        return emailTemplateId;
    }

    public Long getSiteSearchQueryId() {
        return siteSearchQueryId;
    }

    public Long getMultivariateTestVariationId() {
        return multivariateTestVariationId;
    }

    public Long getPaidSearchId() {
        return paidSearchId;
    }

    public Long getVisitorPageViewId() {
        return visitorPageViewId;
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
            + ", activityType=" + getActivityType()
            + ", details='" + details + '\''
            + ", visitorId=" + visitorId
            + ", prospectId=" + prospectId
            + ", emailId=" + emailId
            + ", emailTemplateId=" + emailTemplateId
            + ", fileId=" + fileId
            + ", formId=" + formId
            + ", formHandlerId=" + formHandlerId
            + ", landingPageId=" + landingPageId
            + ", listEmailId=" + listEmailId
            + ", siteSearchQueryId=" + siteSearchQueryId
            + ", multivariateTestVariationId=" + multivariateTestVariationId
            + ", paidSearchId=" + paidSearchId
            + ", visitorPageViewId=" + visitorPageViewId
            + ", campaign=" + campaign
            + ", createdAt=" + createdAt
            + '}';
    }
}
