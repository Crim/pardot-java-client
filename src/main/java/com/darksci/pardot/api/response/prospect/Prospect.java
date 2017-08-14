package com.darksci.pardot.api.response.prospect;

import com.darksci.pardot.api.parser.PardotBooleanSerializer;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.list.ListSubscription;
import com.darksci.pardot.api.response.profile.Profile;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.visitor.Visitor;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.joda.time.LocalDateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a Pardot Prospect.
 */
@JsonIgnoreProperties({ "password" })
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

    private String salesforceFid;
    private String crmLeadFid;
    private String crmContactFid;
    private String crmOwnerFid;
    private String crmAccountFid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime crmLastSync;
    private String crmUrl;

    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "is_do_not_email")
    private Boolean isDoNotEmail;

    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "is_do_not_call")
    private Boolean isDoNotCall;

    @JsonDeserialize(using = PardotBooleanSerializer.class)
    private Boolean optedOut;

    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "is_reviewed")
    private Boolean isReviewed;

    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "is_starred")
    private Boolean isStarred;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    // Assigned User
    private AssignedTo assignedTo;

    // Custom fields
    private Map<String, String> customFields = new HashMap<>();

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

    public String getSalesforceFid() {
        return salesforceFid;
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

    public Boolean getIsDoNotEmail() {
        return isDoNotEmail;
    }

    public Boolean getIsDoNotCall() {
        return isDoNotCall;
    }

    public Boolean getIsOptedOut() {
        return optedOut;
    }

    public Boolean getIsReviewed() {
        return isReviewed;
    }

    public Boolean getIsStarred() {
        return isStarred;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Assigned User
    public AssignedTo getAssignedTo() {
        return assignedTo;
    }

    /**
     * Utility method to get assigned user, if defined.
     * @return Assigned User.
     */
    public User getAssignedUser() {
        if (getAssignedTo() != null) {
            return getAssignedTo().getUser();
        }
        return null;
    }

    // Custom fields
    @JsonAnyGetter
    public Map<String, String> getCustomFields() {
        return customFields;
    }

    /**
     * Utility method to get custom field value
     * @param customFieldName Field to retrieve value for.
     * @return Value of the custom field.
     */
    public String getCustomField(final String customFieldName) {
        return getCustomFields().get(customFieldName);
    }

    @JsonAnySetter
    public void setCustomField(final String fieldName, final String fieldValue) {
        customFields.put(fieldName, fieldValue);
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


    // Setters
    public void setId(final Long id) {
        this.id = id;
    }

    public void setCampaignId(final Long campaignId) {
        this.campaignId = campaignId;
    }

    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public void setProspectAccountId(final long prospectAccountId) {
        this.prospectAccountId = prospectAccountId;
    }

    public void setWebsite(final String website) {
        this.website = website;
    }

    public void setJobTitle(final String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setAddressOne(final String addressOne) {
        this.addressOne = addressOne;
    }

    public void setAddressTwo(final String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public void setTerritory(final String territory) {
        this.territory = territory;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setFax(final String fax) {
        this.fax = fax;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    public void setAnnualRevenue(final String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public void setEmployees(final String employees) {
        this.employees = employees;
    }

    public void setIndustry(final String industry) {
        this.industry = industry;
    }

    public void setYearsInBusiness(final String yearsInBusiness) {
        this.yearsInBusiness = yearsInBusiness;
    }

    public void setComments(final String comments) {
        this.comments = comments;
    }

    public void setNotes(final String notes) {
        this.notes = notes;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    public void setGrade(final String grade) {
        this.grade = grade;
    }

    public void setLastActivityAt(final LocalDateTime lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
    }

    public void setRecentInteraction(final String recentInteraction) {
        this.recentInteraction = recentInteraction;
    }

    public void setSalesforceFid(final String salesforceFid) {
        this.salesforceFid = salesforceFid;
    }

    public void setCrmLeadFid(final String crmLeadFid) {
        this.crmLeadFid = crmLeadFid;
    }

    public void setCrmContactFid(final String crmContactFid) {
        this.crmContactFid = crmContactFid;
    }

    public void setCrmOwnerFid(final String crmOwnerFid) {
        this.crmOwnerFid = crmOwnerFid;
    }

    public void setCrmAccountFid(final String crmAccountFid) {
        this.crmAccountFid = crmAccountFid;
    }

    public void setCrmLastSync(final LocalDateTime crmLastSync) {
        this.crmLastSync = crmLastSync;
    }

    public void setCrmUrl(final String crmUrl) {
        this.crmUrl = crmUrl;
    }

    public void setDoNotEmail(final Boolean doNotEmail) {
        isDoNotEmail = doNotEmail;
    }

    public void setDoNotCall(final Boolean doNotCall) {
        isDoNotCall = doNotCall;
    }

    public void setOptedOut(final Boolean optedOut) {
        this.optedOut = optedOut;
    }

    public void setReviewed(final Boolean reviewed) {
        isReviewed = reviewed;
    }

    public void setStarred(final Boolean starred) {
        isStarred = starred;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCampaign(final Campaign campaign) {
        this.campaign = campaign;
    }

    public void setProfile(final Profile profile) {
        this.profile = profile;
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
            + ", salesforceFid='" + salesforceFid + '\''
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
            + ", assignedTo=" + assignedTo
            + ", customFields=" + customFields
            + ", campaign=" + campaign
            + ", profile=" + profile
            + ", visitorActivities=" + visitorActivities
            + ", listSubscriptions=" + listSubscriptions
            + ", visitors=" + visitors
            + '}';
    }

    /**
     * Holds value in the assignedTo field.
     */
    private static class AssignedTo {
        private User user;

        public User getUser() {
            return user;
        }
    }
}
