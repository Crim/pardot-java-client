# Pardot Java API Client 2.x.x to 3.0.0 Migration Guide

## Authentication & Configuration Breaking Changes

In order to properly support the transition of the Pardot API from authenticating using Pardot username, password, and user keys, to 
Salesforce Single Signon, several breaking changes were made to how you configure the Pardot API Client.

### Configuration class replaced with ConfigurationBuilder.

Where before you created a `Configuration` object, that class has now been replaced by `ConfigurationBuilder`.

**Code that may have looked like this previously**
```java
final Configuration configuration = new Configuration("YourPardotUserNameHere", "PardotPassword", "UserKey");
final PardotClient client = new PardotClient(configuration);
```

**Should now look like this**
```java
final ConfigurationBuilder configuration = Configuration.newBuilder()
    // NOTE: Authenticating using this method will cease to function after ~ Feb. 1 2021.
    //       See section below about migrating to SSO authentication.
    .withUsernameAndPasswordLogin(
        "YourPardotUsername",
        "YourPardotPassword",
        "YourPardotUserKey"
    );

// Call other methods on configuration instance as needed to complete configuration.
final PardotClient client = new PardotClient(configuration);
```

### Pardot Username and Password Authentication Scheme deprecated in favor of Salesforce SSO Authentication.

From February 1, 2021 Pardot is removing the now legacy Pardot Username and Password authentication scheme ([Salesforce EOL Notice](https://help.salesforce.com/articleView?id=000353746&type=1&mode=1&language=en_US&utm_source=techcomms&utm_medium=email&utm_campaign=eol)).

You should switch to configuring authentication using the following method:

```java
final ConfigurationBuilder configuration = Configuration.newBuilder()
    .withSsoLogin(
        "YourSalesforceUsername",
        "YourSalesforcePassword",
        "YourConnectedAppClientId",
        "YourConnectedAppClientSecret",
        "YourPardotBusinessUnitId"
    );
final PardotClient client = new PardotClient(configuration);
```

See [Offical Pardot Developer Documentation](https://developer.pardot.com/kb/authentication/) and [Salesforce OAuth Setup](https://help.salesforce.com/articleView?id=remoteaccess_oauth_flows.htm) for details on how to obtain the above required properties.

## Read request methods now return Optionals

Previously methods on `PardotClient` for reading objects either returned the object you wished to retrieve,
or threw an `InvalidRequestException` if the record could not be found.

This often led to code like:
```java
// Try to lookup prospect by Email.
Prospect myProspect = null;
try {
    myProspect = client.prospectRead(new ProspectReadRequest()
        .selectByEmail('test@prospect.com')
    );
} catch (final InvalidRequestException exception) {
    // Prospect could not be found. Swallow exception.  
}

// Handle prospect if found
if (myProspect != null) {
    ...
}
```

With these methods now returning optionals, you no longer need to catch and handle `InvalidRequestException` 
when an instance is unable to be found.  The above code can be simlified into:

```java
// Check if the Optional is present
final Optional<Prospect> prospectResponse = client.prospectRead(new ProspectReadRequest()
    .selectByEmail('test@prospect.com')
);
if (prospectResponse.isPresent()) {
    ...
}

// Or use other methods available on Optional
client.prospectRead(new ProspectReadRequest()
    .selectByEmail('test@prospect.com')
).ifPresent((prospect) -> {
    // Make use of prospect if found
    logger.info("Found prospect: {}", prospect.getEmail());
});
```

## Delete request methods no longer return Booleans.

Previously methods on `PardotClient` for deleting objects always returned a value of `true` regardless
if the delete request was successful or not.  Version 3.0.0 changes those methods to now return a object
type of `Result<Boolean>`.  The [Result](src/main/java/com/darksci/pardot/api/response/Result.java) object
allows for returning a successful response, as well as an [ErrorResponse](src/main/java/com/darksci/pardot/api/response/ErrorResponse.java) 
instance when the request is not successful.

The quick way to migrate your code:  

```java
// Code that looked like the following examples:
final boolean result = client.userDelete(deleteRequest);
if (client.userDelete(deleteRequest)) {

// Now should look like:
final boolean result = client.userDelete(deleteRequest).isSuccess();
if (client.userDelete(deleteRequest.isSuccess())) {
```

But this also gives you additional flexibility in being able to handle errors more gracefully:
```java
// Handle success conditions:
client
    .userDelete(deleteRequest)
    .ifSuccess((success) -> logger.info("Successfully deleted user!"));

// Handle error conditions:
client
    .userDelete(deleteRequest)
    .ifError((error -> logger.info("Failed to delete user: {}", error.getMessage())));

// Or handle both cases:
client
    .userDelete(deleteRequest)
    .handle(
        (success) -> {
            logger.info("Successfully deleted user!");
            return true;
        },
        (error) -> {
            logger.info("Error deleting user: {}", error.getMessage());
            return false;
        });
```



