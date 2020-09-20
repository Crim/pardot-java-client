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
    .withUsernameAndPasswordLogin(
        "YourPardotUsername",
        "YourPardotPassword",
        "YourPardotUserKey"
    );

// Call other methods on configuration instance as needed to complete configuration.

final PardotClient client = new PardotClient(configuration);
```

### Pardot Username and Password Authentication Scheme deprecrated in favor of Salesforce SSO Authentication.

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

See [Offical Pardot Developer Documentation](https://developer.pardot.com/kb/authentication/) for details on how to obtain the above required properties.