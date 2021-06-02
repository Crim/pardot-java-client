# Pardot Java API Client

[![Build Status](https://travis-ci.org/Crim/pardot-java-client.svg?branch=master)](https://travis-ci.org/Crim/pardot-java-client)

## What is it? 

This library is a fluent style API client for Pardot's API (version 3 and 4).

## Important Breaking Change to Pardot API

From February 1, 2021 Pardot is removing the ability to authenticate to the Pardot API using your Pardot username, password, and userkey ([Salesforce EOL Notice](https://help.salesforce.com/articleView?id=000353746&type=1&mode=1&language=en_US&utm_source=techcomms&utm_medium=email&utm_campaign=eol)).
This means that versions of this library **prior to 3.0.0** will cease to be able to authenticate to the Pardot Api.

Everyone is encouraged to update the library to version **3.0.0 or newer** and switch to using Salesforce SSO authentication prior to February 1, 2021. 
To support Salesforce SSO authentication required backwards compatibility breaking changes to be made to this library, so please read the [2.x.x to 3.0.0 Migration Guide](3_0_0_migration_notes.MD) 
which details the changes required to upgrade.

**Note** While most of Pardot's API is supported by this library, if there is a feature/end point that you
need that is not yet implemented, please read the **[How to Contribute](#how-to-contribute)** section, or **[Create an issue](https://github.com/Crim/pardot-java-client/issues)** 
requesting it. 

**Note** Use this library at your own risk!  Currently there are no known issues, but as an **unofficial** library,
 there are no guarantees.  
 
## How to use this library

This client library is released on Maven Central.  Add a new dependency to your project's POM file:

```xml
<dependency>
    <groupId>com.darksci</groupId>
    <artifactId>pardot-api-client</artifactId>
    <version>4.0.0</version>
</dependency>
```

Example Code using Salesforce SSO Authentication:
```java
/*
 * Create a new configuration object with your Salesforce SSO credentials.
 *
 * This configuration also allows you to define some optional details on your connection,
 * such as using an outbound proxy (authenticated or not).
 */
final ConfigurationBuilder configuration = Configuration.newBuilder()
    // This configures the client using the 'password' authentication flow.    
    .withSsoLogin(
        "YourSalesforceUsername",
        "YourSalesforcePassword",
        "YourConnectedAppClientId",
        "YourConnectedAppClientSecret",
        "YourPardotBusinessUnitId"
    );

/*
 * Alternatively, if you want to use the authorization_code authentication flow,
 * you can configure the client using a previously acquired refresh_token:
 */
Configuration.newBuilder()
    // This configures the client using the 'authorization_code' authentication flow.    
    .withSsoRefreshTokenLogin(
        "PreviousAcquiredRefreshTokenHere",
        "YourConnectedAppClientId",
        "YourConnectedAppClientSecret",
        "YourPardotBusinessUnitId"
    );  

/*
 * Optionally you can explicitly select which API version to use. If none is explicitly selected
 * the library will default to version 3, but the library will automatically upgrade to version
 * 4 if required to do so.
 */
configuration.withApiVersion3();

/* Or */
configuration.withApiVersion4();

/*
 * Create an instance of PardotClient, passing your configuration.
 */
final PardotClient client = new PardotClient(configuration);

/*
 * The client will automatically authenticate when you make your first request, no need to
 * explicitly login.
 *
 * Lets create a simple Account request, and execute it.
 */
final AccountReadRequest accountReadRequest = new AccountReadRequest();
final Account account = client.accountRead(accountReadRequest);

/*
 * Or lets do a more complex Campaign search.
 */
final CampaignQueryRequest campaignQueryRequest = new CampaignQueryRequest()
    .withUpdatedAfter(DateParameter.last7Days())
    .withIdLessThan(1234L)
    .withSortById()
    .withSortOrderDescending();
final CampaignQueryResponse.Result campaignQueryResponse = client.campaignQuery(campaignQueryRequest);

/*
 * And when you're done, call close on PardotClient.
 */
client.close();
```

Or Using the Try-With-Resources Pattern:
```java
/*
 * Since PardotClient implements Autoclosable, you can also use the try-with-resources pattern.
 */
try (final PardotClient client = new PardotClient(configuration)) {
    // Use client instance as needed
    client.accountRead(new AccountReadRequest());

    // client.close() is automatically called at the end of the try {} block.
}
```

## What Features are implemented?

### Authentication
Official Documentation: [Authentication](https://developer.pardot.com/kb/authentication/)

- Authenticating with Pardot's API using your Salesforce SSO Username, Password, and Connected Application details. [See Example](src/main/java/com/darksci/pardot/api/Example.java#L37).
- Authenticating with Pardot's API using a Salesforce SSO refresh_token and Connected Application details. [See Example](src/main/java/com/darksci/pardot/api/Example.java#L103).
- Authenticating with Pardot's API using Salesforce SSO against Test / Sandbox orgs. [See Example](src/main/java/com/darksci/pardot/api/Example.java#L155).
- Legacy authentication using your Pardot Username, Password, and User Token. [See Example](src/main/java/com/darksci/pardot/api/Example.java#L196). 

### Accounts
Official Documentation: [Accounts](http://developer.pardot.com/kb/api-version-3/accounts/)

- Read

### Campaigns
Official Documentation: [Campaigns](http://developer.pardot.com/kb/api-version-3/campaigns/)

- Create
- Query
- Read
- Update

### Custom Fields
Official Documentation: [Custom Fields](http://developer.pardot.com/kb/api-version-3/custom-fields/)

- Create
- Query
- Read
- Update

### Custom Redirects
Official Documentation: [Custom Redirects](http://developer.pardot.com/kb/api-version-3/custom-redirects/)

- Query
- Read

### Dynamic Content
Official Documentation: [Dynamic Content](http://developer.pardot.com/kb/api-version-3/dynamic-content/)

- Query
- Read

### Emails
Official Documentation: [Emails](http://developer.pardot.com/kb/api-version-3/emails/)

- Read
- Sending List Emails
- Sending One to One Emails
- Stats

### Email Clicks
Official Documentation: [Email Clicks](http://developer.pardot.com/kb/api-version-3/batch-email-clicks/)

- Query

### Email Templates
Official Documentation: [Email Templates](http://developer.pardot.com/kb/api-version-3/email-templates/)

- List One to One templates
- Read

### Forms
Official Documentation: [Forms](http://developer.pardot.com/kb/api-version-3/forms/)

- Create
- Delete
- Query
- Read
- Update

### Lists
Official Documentation: [Lists](http://developer.pardot.com/kb/api-version-3/lists/)

- Create
- Query
- Read
- Update

### List Memberships
Official Documentation: [ListMemberships](http://developer.pardot.com/kb/api-version-3/list-memberships/)

- Create
- Query
- Read
- Update

### Opportunities
Official Documentation: [Opportunities](http://developer.pardot.com/kb/api-version-3/opportunities/)

- Create
- Delete
- Query
- Read
- Undelete
- Update

### Prospects
Official Documentation: [Prospects](http://developer.pardot.com/kb/api-version-3/prospects/)

- Assign
- Create - Does not support multiple values for record-multiple fields.
- Delete
- Query
- Read
- Unassign
- Update - Does not support multiple values for record-multiple fields.
- Upsert - Does not support multiple values for record-multiple fields.

### Tags
Official Documentation: [Tags](http://developer.pardot.com/kb/api-version-3/tags/)

- Query
- Read

### TagObjects
Official Documentation: [TagObjects](http://developer.pardot.com/kb/api-version-3/tag-objects/)

- Query
- Read

### Users
Official Documentation: [Users](http://developer.pardot.com/kb/api-version-3/users/)

- Abilities of current API User
- Query
- Read

### Visitors
Official Documentation: [Visitors](http://developer.pardot.com/kb/api-version-3/visitors/)

- Assign
- Query
- Read

### Visitor Activities
Official Documentation: [VisitorActivities](http://developer.pardot.com/kb/api-version-3/visitor-activities/)

- Query
- Read

### Visits
Official Documentation: [Visits](https://developer.pardot.com/kb/api-version-3/visits/)

- Query
- Read

## How to Contribute 

Want to help implement the missing API end points?  Fork the repository, write some code, and 
submit a PR to the project!

Implementing new API requests really only requires implementing the two following interfaces, along with
minimal glue code.

### [Request](/blob/master/src/main/java/com/darksci/pardot/api/request/Request.java)
The Request interface can typically be implemented by extending either [BaseRequest](/blob/master/src/main/java/com/darksci/pardot/api/request/BaseRequest.java) or [BaseQueryRequest](/blob/master/src/main/java/com/darksci/pardot/api/request/BaseQueryRequest.java).
This defines the end point that the request will hit, along with what parameters will be
passed along with it.

### [ResponseParser](/blob/master/src/main/java/com/darksci/pardot/api/parser/ResponseParser.java)
The ResponseParser interface defines how to take the API's response and convert it back into
user friendly Plain Old Java Objects (POJOs).

## Contributors
[Crim](https://github.com/crim)
[LoRez](https://github.com/lorez)
[dai-00](https://github.com/dai-00)

## Releasing
Steps for performing a release:

1. Update release version: `mvn versions:set -DnewVersion=X.Y.Z`
2. Validate and then commit version: `mvn versions:commit`
3. Update CHANGELOG and README files.
4. Merge to master.
5. Deploy to Maven Central: `mvn clean deploy -P release`
7. Create release on Github project, uploading JAR artifacts.

## Changelog

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

[View Changelog](CHANGELOG.md)



