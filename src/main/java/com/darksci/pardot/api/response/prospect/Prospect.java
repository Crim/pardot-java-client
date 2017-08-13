package com.darksci.pardot.api.response.prospect;

import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.list.ListSubscription;
import com.darksci.pardot.api.response.profile.Profile;
import com.darksci.pardot.api.response.visitor.Visitor;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import org.joda.time.LocalDateTime;

import java.util.List;

/**
 * Represents a Pardot Prospect.
 */
public class Prospect {
    private Long id;
    private Long campaignId;
    private String salutation;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private long prospectAccountId;

    private String website;
    private String jobTitle;
    private String department;
    private String country;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String state;
    private String territory;
    private String zip;

    private String phone;
    private String fax;

    private String source;
    private String annualRevenue;
    private String employees;
    private String industry;
    private String yearsInBusiness;

    private String comments;
    private String notes;

    private Integer score;
    private String grade;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastActivityAt;
    private String recentInteraction;

    private String crmLeadFid;
    private String crmContactFid;
    private String crmOwnerFid;
    private String crmAccountFid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime crmLastSync;
    private String crmUrl;

    private Boolean isDoNotEmail;
    private Boolean isDoNotCall;
    private Boolean optedOut;
    private Boolean isReviewed;
    private Boolean isStarred;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    // Related Objects
    private Campaign campaign;
    private Profile profile;

    @JacksonXmlElementWrapper(localName = "visitor_activities")
    private List<VisitorActivity> visitorActivities;

    @JacksonXmlElementWrapper(localName = "lists")
    private List<ListSubscription> listSubscriptions;

    @JacksonXmlElementWrapper(localName = "visitors")
    private List<Visitor> visitors;

    public Long getId() {
        return id;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public long getProspectAccountId() {
        return prospectAccountId;
    }

    public String getWebsite() {
        return website;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public String getCountry() {
        return country;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getTerritory() {
        return territory;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getSource() {
        return source;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public String getEmployees() {
        return employees;
    }

    public String getIndustry() {
        return industry;
    }

    public String getYearsInBusiness() {
        return yearsInBusiness;
    }

    public String getComments() {
        return comments;
    }

    public String getNotes() {
        return notes;
    }

    public Integer getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    public LocalDateTime getLastActivityAt() {
        return lastActivityAt;
    }

    public String getRecentInteraction() {
        return recentInteraction;
    }

    public String getCrmLeadFid() {
        return crmLeadFid;
    }

    public String getCrmContactFid() {
        return crmContactFid;
    }

    public String getCrmOwnerFid() {
        return crmOwnerFid;
    }

    public String getCrmAccountFid() {
        return crmAccountFid;
    }

    public LocalDateTime getCrmLastSync() {
        return crmLastSync;
    }

    public String getCrmUrl() {
        return crmUrl;
    }

    public Boolean getDoNotEmail() {
        return isDoNotEmail;
    }

    public Boolean getDoNotCall() {
        return isDoNotCall;
    }

    public Boolean getOptedOut() {
        return optedOut;
    }

    public Boolean getReviewed() {
        return isReviewed;
    }

    public Boolean getStarred() {
        return isStarred;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Related Objects
    public Campaign getCampaign() {
        return campaign;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<VisitorActivity> getVisitorActivities() {
        return visitorActivities;
    }

    public List<ListSubscription> getListSubscriptions() {
        return listSubscriptions;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    @Override
    public String toString() {
        return "Prospect{"
            + "id=" + id
            + ", campaignId=" + campaignId
            + ", salutation='" + salutation + '\''
            + ", firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", email='" + email + '\''
            + ", company='" + company + '\''
            + ", prospectAccountId=" + prospectAccountId
            + ", website='" + website + '\''
            + ", jobTitle='" + jobTitle + '\''
            + ", department='" + department + '\''
            + ", country='" + country + '\''
            + ", addressOne='" + addressOne + '\''
            + ", addressTwo='" + addressTwo + '\''
            + ", city='" + city + '\''
            + ", state='" + state + '\''
            + ", territory='" + territory + '\''
            + ", zip='" + zip + '\''
            + ", phone='" + phone + '\''
            + ", fax='" + fax + '\''
            + ", source='" + source + '\''
            + ", annualRevenue='" + annualRevenue + '\''
            + ", employees='" + employees + '\''
            + ", industry='" + industry + '\''
            + ", yearsInBusiness='" + yearsInBusiness + '\''
            + ", comments='" + comments + '\''
            + ", notes='" + notes + '\''
            + ", score=" + score
            + ", grade='" + grade + '\''
            + ", lastActivityAt=" + lastActivityAt
            + ", recentInteraction='" + recentInteraction + '\''
            + ", crmLeadFid='" + crmLeadFid + '\''
            + ", crmContactFid='" + crmContactFid + '\''
            + ", crmOwnerFid='" + crmOwnerFid + '\''
            + ", crmAccountFid='" + crmAccountFid + '\''
            + ", crmLastSync=" + crmLastSync
            + ", crmUrl='" + crmUrl + '\''
            + ", isDoNotEmail=" + isDoNotEmail
            + ", isDoNotCall=" + isDoNotCall
            + ", optedOut=" + optedOut
            + ", isReviewed=" + isReviewed
            + ", isStarred=" + isStarred
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + ", campaign=" + campaign
            + ", profile=" + profile
            + ", visitorActivities=" + visitorActivities
            + ", listSubscriptions=" + listSubscriptions
            + ", visitors=" + visitors
            + '}';
    }
}
