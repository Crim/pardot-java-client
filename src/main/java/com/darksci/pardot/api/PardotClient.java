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

package com.darksci.pardot.api;

import com.darksci.pardot.api.parser.ErrorResponseParser;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.parser.StringResponseParser;
import com.darksci.pardot.api.parser.account.AccountReadResponseParser;
import com.darksci.pardot.api.parser.campaign.CampaignQueryResponseParser;
import com.darksci.pardot.api.parser.campaign.CampaignReadResponseParser;
import com.darksci.pardot.api.parser.email.EmailReadResponseParser;
import com.darksci.pardot.api.parser.email.EmailStatsResponseParser;
import com.darksci.pardot.api.parser.list.ListQueryResponseParser;
import com.darksci.pardot.api.parser.list.ListReadResponseParser;
import com.darksci.pardot.api.parser.listmembership.ListMembershipQueryResponseParser;
import com.darksci.pardot.api.parser.listmembership.ListMembershipReadResponseParser;
import com.darksci.pardot.api.parser.login.LoginResponseParser;
import com.darksci.pardot.api.parser.prospect.ProspectQueryResponseParser;
import com.darksci.pardot.api.parser.prospect.ProspectReadResponseParser;
import com.darksci.pardot.api.parser.user.UserAbilitiesParser;
import com.darksci.pardot.api.parser.user.UserQueryResponseParser;
import com.darksci.pardot.api.parser.user.UserReadResponseParser;
import com.darksci.pardot.api.parser.visitor.VisitorQueryResponseParser;
import com.darksci.pardot.api.parser.visitor.VisitorReadResponseParser;
import com.darksci.pardot.api.parser.visitoractivity.VisitorActivityQueryResponseParser;
import com.darksci.pardot.api.parser.visitoractivity.VisitorActivityReadResponseParser;
import com.darksci.pardot.api.request.Request;
import com.darksci.pardot.api.request.account.AccountReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignCreateRequest;
import com.darksci.pardot.api.request.campaign.CampaignQueryRequest;
import com.darksci.pardot.api.request.campaign.CampaignReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignUpdateRequest;
import com.darksci.pardot.api.request.email.EmailReadRequest;
import com.darksci.pardot.api.request.email.EmailSendListRequest;
import com.darksci.pardot.api.request.email.EmailSendOneToOneRequest;
import com.darksci.pardot.api.request.email.EmailStatsRequest;
import com.darksci.pardot.api.request.list.ListCreateRequest;
import com.darksci.pardot.api.request.list.ListQueryRequest;
import com.darksci.pardot.api.request.list.ListReadRequest;
import com.darksci.pardot.api.request.list.ListUpdateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipCreateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipQueryRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipReadRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipUpdateRequest;
import com.darksci.pardot.api.request.login.LoginRequest;
import com.darksci.pardot.api.request.prospect.ProspectAssignRequest;
import com.darksci.pardot.api.request.prospect.ProspectCreateRequest;
import com.darksci.pardot.api.request.prospect.ProspectDeleteRequest;
import com.darksci.pardot.api.request.prospect.ProspectQueryRequest;
import com.darksci.pardot.api.request.prospect.ProspectReadRequest;
import com.darksci.pardot.api.request.prospect.ProspectUnassignRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpdateRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpsertRequest;
import com.darksci.pardot.api.request.user.UserAbilitiesRequest;
import com.darksci.pardot.api.request.user.UserQueryRequest;
import com.darksci.pardot.api.request.user.UserReadRequest;
import com.darksci.pardot.api.request.visitor.VisitorAssignRequest;
import com.darksci.pardot.api.request.visitor.VisitorQueryRequest;
import com.darksci.pardot.api.request.visitor.VisitorReadRequest;
import com.darksci.pardot.api.request.visitoractivity.VisitorActivityQueryRequest;
import com.darksci.pardot.api.request.visitoractivity.VisitorActivityReadRequest;
import com.darksci.pardot.api.response.ErrorResponse;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.response.email.Email;
import com.darksci.pardot.api.response.email.EmailStatsResponse;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListMembership;
import com.darksci.pardot.api.response.list.ListQueryResponse;
import com.darksci.pardot.api.response.listmembership.ListMembershipQueryResponse;
import com.darksci.pardot.api.response.login.LoginResponse;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.prospect.ProspectQueryResponse;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import com.darksci.pardot.api.response.user.UserQueryResponse;
import com.darksci.pardot.api.response.visitor.Visitor;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.darksci.pardot.api.rest.HttpClientRestClient;
import com.darksci.pardot.api.rest.RestClient;
import com.darksci.pardot.api.rest.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Interface for Pardot's API.
 */
public class PardotClient implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(PardotClient.class);

    /**
     * Our API Configuration.
     */
    private final Configuration configuration;

    /**
     * Underlying RestClient to use.
     */
    private final RestClient restClient;

    /**
     * Internal State flag.
     */
    private boolean isInitialized = false;

    /**
     * Default Constructor.
     * @param configuration Pardot Api Configuration.
     */
    public PardotClient(final Configuration configuration) {
        this.configuration = configuration;
        this.restClient = new HttpClientRestClient();
    }

    /**
     * Constructor for injecting a RestClient implementation.
     * Typically only used in testing.
     * @param configuration Pardot Api Configuration.
     * @param restClient RestClient implementation to use.
     */
    public PardotClient(final Configuration configuration, final RestClient restClient) {
        this.configuration = configuration;
        this.restClient = restClient;
    }

    private <T> T submitRequest(final Request request, ResponseParser<T> responseParser) {
        // Ugly hack,
        // avoid doing login check if we're doing a login request.
        if (!(request instanceof LoginRequest)) {
            // Check for auth token
            checkLogin();
        }

        // Submit request
        final RestResponse restResponse = getRestClient().submitRequest(request);
        final int responseCode = restResponse.getHttpCode();
        String responseStr = restResponse.getResponseStr();

        // If we have a valid response
        logger.info("Response: {}", restResponse);

        // Check for invalid http status codes
        if (responseCode >= 200 && responseCode < 300) {
            // These response codes have no values
            if (responseCode == 205 && responseStr == null) {
                // Avoid NPE
                responseStr = "";
            }

            // High level check for error response
            if (responseStr.contains("<rsp stat=\"fail\"")) {
                try {
                    // Parse error response
                    final ErrorResponse error = new ErrorResponseParser().parseResponse(restResponse.getResponseStr());

                    // throw exception
                    throw new InvalidRequestException(error.getMessage(), error.getCode());
                } catch (IOException exception) {
                    throw new ParserException(exception.getMessage(), exception);
                }
            }
            try {
                return responseParser.parseResponse(restResponse.getResponseStr());
            } catch (IOException exception) {
                throw new ParserException(exception.getMessage(), exception);
            }
        }
        // Otherwise throw an exception.
        throw new InvalidRequestException("Invalid http response code from server: " + restResponse.getHttpCode(), restResponse.getHttpCode());
    }

    /**
     * @return Return Pardot API Configuration.
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * package protected for access in tests.
     * @return Rest Client.
     */
    RestClient getRestClient() {
        // If we haven't initialized.
        if (!isInitialized) {
            // Call Init.
            restClient.init(getConfiguration());

            // Flip state flag
            isInitialized = true;
        }

        // return our rest client.
        return restClient;
    }

    /**
     * Check to see if we're already logged in and have an API key.
     * If no existing API key is found, this will attempt to authenticate and
     * get a new API key.
     */
    private void checkLogin() {
        if (configuration.getApiKey() != null) {
            return;
        }
        // Otherwise attempt to authenticate.
        final LoginResponse response = login(new LoginRequest()
            .withEmail(configuration.getEmail())
            .withPassword(configuration.getPassword())
        );

        // If we have an API key.
        if (response.getApiKey() != null) {
            // Set it.
            getConfiguration().setApiKey(response.getApiKey());
        }
    }

    /**
     * Make login request
     * @param request Login request definition.
     * @return LoginResponse returned from server.
     */
    public LoginResponse login(LoginRequest request) {
        return submitRequest(request, new LoginResponseParser());
    }

    /**
     * Make API request to read the account of the currently authenticated user.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Account accountRead(final AccountReadRequest request) {
        return submitRequest(request, new AccountReadResponseParser());
    }

    /**
     * Make API request to query one or more users.
     * @param request Request definition.
     * @return Parsed user query response.
     */
    public UserQueryResponse.Result userQuery(final UserQueryRequest request) {
        return submitRequest(request, new UserQueryResponseParser());
    }

    /**
     * Make API request to read the abilities of the currently authenticated user.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public UserAbilitiesResponse.Result userAbilities(final UserAbilitiesRequest request) {
        return submitRequest(request, new UserAbilitiesParser());
    }

    /**
     * Make API request to read a specific user.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public User userRead(final UserReadRequest request) {
        return submitRequest(request, new UserReadResponseParser());
    }

    /**
     * Make API request to query for one or more campaigns.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public CampaignQueryResponse.Result campaignQuery(final CampaignQueryRequest request) {
        return submitRequest(request, new CampaignQueryResponseParser());
    }

    /**
     * Make API request to read a specific campaign.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Campaign campaignRead(final CampaignReadRequest request) {
        return submitRequest(request, new CampaignReadResponseParser());
    }

    /**
     * Make API request to create a new Campaign.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Campaign campaignCreate(final CampaignCreateRequest request) {
        return submitRequest(request, new CampaignReadResponseParser());
    }

    /**
     * Make API request to update an existing Campaign.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Campaign campaignUpdate(final CampaignUpdateRequest request) {
        return submitRequest(request, new CampaignReadResponseParser());
    }

    /**
     * Make API request to read a specific Email.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Email emailRead(final EmailReadRequest request) {
        return submitRequest(request, new EmailReadResponseParser());
    }

    /**
     * Make API request to retrieve stats about a List Email Send.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public EmailStatsResponse.Stats emailStats(final EmailStatsRequest request) {
        return submitRequest(request, new EmailStatsResponseParser());
    }

    /**
     * Make API request to send a 1-to-1 prospect email.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Email emailSendOneToOne(final EmailSendOneToOneRequest request) {
        return submitRequest(request, new EmailReadResponseParser());
    }

    /**
     * Make API request to send a list email.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Email emailSendList(final EmailSendListRequest request) {
        return submitRequest(request, new EmailReadResponseParser());
    }

    /**
     * Make API request to query for one or more lists.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListQueryResponse.Result listQuery(final ListQueryRequest request) {
        return submitRequest(request, new ListQueryResponseParser());
    }

    /**
     * Make API request to read a specific list.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public List listRead(final ListReadRequest request) {
        return submitRequest(request, new ListReadResponseParser());
    }

    /**
     * Make API request to create a new List.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public List listCreate(final ListCreateRequest request) {
        return submitRequest(request, new ListReadResponseParser());
    }

    /**
     * Make API request to update an existing List.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public List listUpdate(final ListUpdateRequest request) {
        return submitRequest(request, new ListReadResponseParser());
    }

    /**
     * Make API request to query for one or more list memberships.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListMembershipQueryResponse.Result listMembershipQuery(final ListMembershipQueryRequest request) {
        return submitRequest(request, new ListMembershipQueryResponseParser());
    }

    /**
     * Make API request to read a listMembership.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListMembership listMembershipRead(final ListMembershipReadRequest request) {
        return submitRequest(request, new ListMembershipReadResponseParser());
    }

    /**
     * Make API request to create a new List Membership.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListMembership listMembershipCreate(final ListMembershipCreateRequest request) {
        return submitRequest(request, new ListMembershipReadResponseParser());
    }

    /**
     * Make API request to update an existing List Membership.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ListMembership listMembershipUpdate(final ListMembershipUpdateRequest request) {
        return submitRequest(request, new ListMembershipReadResponseParser());
    }

    /**
     * Make API request to read a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectRead(final ProspectReadRequest request) {
        return submitRequest(request, new ProspectReadResponseParser());
    }

    /**
     * Make API request to create a new prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectCreate(final ProspectCreateRequest request) {
        return submitRequest(request, new ProspectReadResponseParser());
    }

    /**
     * Make API request to update an existing prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectUpdate(final ProspectUpdateRequest request) {
        return submitRequest(request, new ProspectReadResponseParser());
    }

    /**
     * Make API request to upsert a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectUpsert(final ProspectUpsertRequest request) {
        return submitRequest(request, new ProspectReadResponseParser());
    }

    /**
     * Make API request to query prospects.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public ProspectQueryResponse.Result prospectQuery(final ProspectQueryRequest request) {
        return submitRequest(request, new ProspectQueryResponseParser());
    }

    /**
     * Make API request to delete prospects.
     * @param request Request definition.
     * @return true if success, false if error.
     */
    public boolean prospectDelete(final ProspectDeleteRequest request) {
        submitRequest(request, new StringResponseParser());
        return true;
    }

    /**
     * Make API request to assign a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectAssign(final ProspectAssignRequest request) {
        return submitRequest(request, new ProspectReadResponseParser());
    }

    /**
     * Make API request to unassign a prospect.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Prospect prospectUnassign(final ProspectUnassignRequest request) {
        return submitRequest(request, new ProspectReadResponseParser());
    }

    /**
     * Make API request to assign a visitor.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public Visitor visitorAssign(final VisitorAssignRequest request) {
        return submitRequest(request, new VisitorReadResponseParser());
    }

    /**
     * Make API request to query visitors.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public String visitorQuery(final VisitorQueryRequest request) {
        return submitRequest(request, new VisitorQueryResponseParser());
    }

    /**
     * Make API request to read a visitor activity.
     * @param request Request definition.
     * @return Parsed api response
     */
    public Visitor visitorRead(final VisitorReadRequest request) {
        return submitRequest(request, new VisitorReadResponseParser());
    }

    /**
     * Make API request to query visitorActivities.
     * @param request Request definition.
     * @return Parsed api response.
     */
    public String visitorActivityQuery(final VisitorActivityQueryRequest request) {
        return submitRequest(request, new VisitorActivityQueryResponseParser());
    }

    /**
     * Make API request to read a visitor activity.
     * @param request Request definition.
     * @return Parsed api response
     */
    public VisitorActivity visitorActivityRead(final VisitorActivityReadRequest request) {
        return submitRequest(request, new VisitorActivityReadResponseParser());
    }

    /**
     * Clean up instance, releasing any resources held internally.
     */
    public void close() {
        getRestClient().close();
    }

}