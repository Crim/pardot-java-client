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

package com.darksci.pardot.api.response.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.joda.time.DateTime;

/**
 * Represents a Pardot Account.
 */
public class Account {
    private Long id;
    private String company;
    private String level;
    private String website;
    private String vanityDomain;
    private Long pluginCampaignId;
    private String trackingCodeTemplate;
    @JacksonXmlProperty(localName = "address1")
    private String addressOne;
    @JacksonXmlProperty(localName = "address2")
    private String addressTwo;
    private String city;
    private String state;
    private String territory;
    private String zip;
    private String country;
    private String phone;
    private String fax;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime updatedAt;

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getLevel() {
        return level;
    }

    public String getWebsite() {
        return website;
    }

    public String getVanityDomain() {
        return vanityDomain;
    }

    public Long getPluginCampaignId() {
        return pluginCampaignId;
    }

    public String getTrackingCodeTemplate() {
        return trackingCodeTemplate;
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

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Account{"
            + "id=" + id
            + ", company='" + company + '\''
            + ", level='" + level + '\''
            + ", website='" + website + '\''
            + ", vanityDomain='" + vanityDomain + '\''
            + ", pluginCampaignId=" + pluginCampaignId
            + ", trackingCodeTemplate='" + trackingCodeTemplate + '\''
            + ", addressOne='" + addressOne + '\''
            + ", addressTwo='" + addressTwo + '\''
            + ", city='" + city + '\''
            + ", state='" + state + '\''
            + ", territory='" + territory + '\''
            + ", zip=" + zip
            + ", country='" + country + '\''
            + ", phone='" + phone + '\''
            + ", fax='" + fax + '\''
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + '}';
    }
}
