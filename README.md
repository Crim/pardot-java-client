# Pardot Java API Client

[![Build Status](https://travis-ci.org/Crim/pardot-java-client.svg?branch=master)](https://travis-ci.org/Crim/pardot-java-client)

## What is it? 

This library intends to be a fluent style API client for Pardot's API (version 3 and 4).

**Note** It currently is not fully featured/fully implemented. If there is a feature/end point that you
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
    <version>0.2.0</version>
</dependency>
```

Example Code:
```java
/*
 * Create a new configuration object with your Pardot credentials.
 *
 * This configuration also allows you to define some optional details on your connection,
 * such as using an outbound proxy (authenticated or not).
 */
final Configuration configuration = new Configuration("YourPardotUserNameHere", "PardotPassword", "UserKey");

/*
 * Optionally select which API version to use, if none is explicitly selected
 * the library will default to version 3.
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
final Configuration configuration = new Configuration("YourPardotUserNameHere", "PardotPassword", "UserKey");
try (final PardotClient client = new PardotClient(configuration)) {
    // Use client instance as needed
    client.accountRead(new AccountReadRequest());

    // client.close() is automatically called at the end of the try {} block.
}
```

## What Features are implemented?

### Authentication
Official Documentation: [Authentication](http://developer.pardot.com/#authentication)

Authenticating with Pardot's API using your Pardot Username, Password, and User Token.  

### Accounts
Official Documentation: [Accounts](http://developer.pardot.com/kb/api-version-3/accounts/)

- Read


### Campaigns
Official Documentation: [Campaigns](http://developer.pardot.com/kb/api-version-3/campaigns/)

- Create
- Query
- Read
- Update

### Emails
Official Documentation: [Emails](http://developer.pardot.com/kb/api-version-3/emails/)

- Read
- Sending List Emails
- Sending One to One Emails
- Stats

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

### Users
Official Documentation: [Users](http://developer.pardot.com/kb/api-version-3/users/)

- Abilities of current API User
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

## Changelog

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

[View Changelog](CHANGELOG.md)



