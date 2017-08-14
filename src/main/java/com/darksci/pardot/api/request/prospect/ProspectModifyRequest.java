package com.darksci.pardot.api.request.prospect;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.prospect.Prospect;

/**
 * Abstract shared code between Create, Update, and Upsert Prospect operations.
 */
abstract class ProspectModifyRequest<T> extends BaseRequest<T> {

    /**
     * Define the campaign you want to create in pardot.
     * @param prospect The prospect you want to create in pardot.
     * @return CampaignCreateRequest builder.
     */
    public T withProspect(final Prospect prospect) {
        setParam("email", prospect.getEmail());
        setParam("first_name", prospect.getFirstName());
        setParam("last_name", prospect.getLastName());

        setParam("id", prospect.getId());
        setParam("campaign_id", prospect.getCampaignId());
        setParam("salutation", prospect.getSalutation());
        setParam("company", prospect.getCompany());
        setParam("prospect_account_d", prospect.getProspectAccountId());

        setParam("website", prospect.getWebsite());
        setParam("job_title", prospect.getJobTitle());
        setParam("department", prospect.getDepartment());
        setParam("country", prospect.getCountry());
        setParam("address_one", prospect.getAddressOne());
        setParam("address_two", prospect.getAddressTwo());
        setParam("city", prospect.getCity());
        setParam("state", prospect.getState());
        setParam("territory", prospect.getTerritory());
        setParam("zip", prospect.getZip());

        setParam("phone", prospect.getPhone());
        setParam("fax", prospect.getFax());

        setParam("source", prospect.getSource());
        setParam("annual_revenue", prospect.getAnnualRevenue());
        setParam("employees", prospect.getEmployees());
        setParam("industry", prospect.getIndustry());
        setParam("years_in_business", prospect.getYearsInBusiness());

        // TODO add other fields?  How to handle custom fields?

        return (T) this;
    }
}
