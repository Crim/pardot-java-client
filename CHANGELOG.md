# Change Log
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## 4.0.0 (06/03/2021)

### NOTE: Breaking Change
Out of an abundance of caution, denoting this release as being a breaking change.
The `zip` field on [Account](https://github.com/Crim/pardot-java-client/commit/6f90634a81b733bc525f61218e228cadba1368ae#diff-218cecafc85bc0dfa03c626e9d9036657ddef6acb4f4f66362267f8a727eb9b6) was changed from an `Integer` type to a `String` type.  If you have
code that references this field, you will need to update your code to reflect this change.

- [PR-78](https://github.com/Crim/pardot-java-client/pull/78) Account 'zip' property changed from being an `Integer` type to a `String` to support worldwide zipcodes.  Thanks [@daniel-exceed](https://github.com/daniel-exceed)!

## 3.3.0 (05/02/2021)
- [PR-75](https://github.com/Crim/pardot-java-client/pull/75) Added support for querying and reading Visits.  Thanks [@dai-00](https://github.com/dai-00)!

#### Internal Dependency Updates
- Upgraded Jackson from version 2.11.2 to 2.11.4.


## 3.2.0 (02/09/2021)
- [ISSUE-68](https://github.com/Crim/pardot-java-client/issues/68) Add authentication method for grant_type=authorization_code using previously retrieved refresh_token.  See `ConfigurationBuilder.withSsoRefreshTokenLogin()`
- [ISSUE-70](https://github.com/Crim/pardot-java-client/issues/70) Adds ability to override the OAuth authentication endpoint when doing SSO authentication.  See optional parameter `AuthorizationServer` on the `ConfigurationBuilder.withSsoRefreshTokenLogin()` and `ConfigurationBuilder.withSsoLogin()` methods.

## 3.1.0 (10/23/2020)
- [ISSUE-65](https://github.com/Crim/pardot-java-client/issues/65) Adds missing Query options to `ProspectQuerytRequest` for `withUpdatedAfter()` and `withUpdatedBefore()`.

## 3.0.0 (09/21/2020)

### Breaking Changes
This release has several breaking changes. See [3.0.0 Migration Notes](3_0_0_migration_notes.MD) for details on breaking changes and how to upgrade.

- [ISSUE-58](https://github.com/Crim/pardot-java-client/issues/58) Add support for Salesforce SSO authentication.
- [PR-60](https://github.com/Crim/pardot-java-client/pull/60) Alters return values from `PardotClient.readXYZ()` and `PardotClient.deleteXYZ()` to allow for better error handling.

#### Internal Dependency Updates
- Upgraded Jackson from version 2.11.1 to 2.11.2.

## 2.1.0 (07/30/2020)
- [ISSUE-56](https://github.com/Crim/pardot-java-client/issues/56) Adds support for Dynamic Content.

#### Internal Dependency Updates
- Upgraded Jackson from version 2.10.2 to 2.11.1.
- Upgraded HttpComponents Client from version 4.5.11 to 4.5.12.

## 2.0.0 (03/05/2020)
- [ISSUE-50](https://github.com/Crim/pardot-java-client/issues/50) Improve support for record multiple fields. 

### Breaking Change

In order to better support record multiple value custom fields, the accessor on `Prospect` for `getCustomFields()` has been changed **FROM**  
`public Map<String, String> getCustomFields()` **TO** `public Map<String, ProspectCustomFieldValue> getCustomFields()`

For custom fields which are NOT record multiple value custom fields the accessor `public String getCustomField(final String customFieldName)` method will continue to return the stored value for the custom field.

For custom fields which ARE record multiple value custom fields the accessor `public String getCustomField(final String customFieldName)` method will only return the first stored value.  You can use the new accessor 
`public List<String> getCustomFieldValues(final String customFieldName)` to get all stored values for record multiple value custom fields.  


## 1.1.2 (02/20/2020)
#### Bugfixes
- [ISSUE-45](https://github.com/Crim/pardot-java-client/issues/45) Fixed bug preventing the library from auto-renewing a session when it expires.

#### Internal Dependency Updates
- Upgraded Jackson from version 2.10.1 to 2.10.2.
- Upgraded HttpComponents Client from version 4.5.10 to 4.5.11.
- Upgraded SLF4J from version 1.7.29 to 1.7.30.

## 1.1.1 (01/07/2020)
- Fixed bug in User create endpoint where setting a new user's role could only be set via a RoleId.  Now you can set the role by name or id.

## 1.1.0 (12/17/2019)

- Removed `org.apache.logging.log4j` dependency, instead relying on the org.slf4j logging interface/facade dependency explicitly.
  - If your project was depending on this transitive dependency you may need to add it to your own project:

  ```
  <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-api</artifactId>
      <version>2.12.1</version>
  </dependency>
  <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.12.1</version>
  </dependency>
  <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-slf4j-impl</artifactId>
      <version>2.12.1</version>
  </dependency>
  ```
  
- Adds support for additional user end points.
- Adds [RequestInterceptor](src/main/java/com/darksci/pardot/api/rest/interceptor/RequestInterceptor.java) interface to allow for end-user manipulation of requests prior to being sent over the wire.
- Adds [UserDefinedRequest](src/main/java/com/darksci/pardot/api/request/UserDefinedRequest.java) interface to allow for customizing/defining your own API requests.

```java
    /**
     * Example of defining a Custom API endpoint request.  The methods required to be implemented are
     * defined below with examples.
     *
     * You can make use of the methods defined on the parent 'BaseRequest' class to set request parameter
     * as needed.
     */
    public class MyTestRequest extends UserDefinedRequest<MyTestRequest, MyCustomReturnObject> {
        /**
         * Given the API's response String, this method should parse it into a more easily consumed object.
         * Alternatively, it could just return the API's response string.
         *
         * @return An object that represents the parsed API response.
         */
        @Override
        public ResponseParser<MyCustomReturnObject> getResponseParser() {
            return (apiResponseStringapiResponseString) -> {
                // Your own custom parsing Logic.
                return new MyCustomReturnObject(apiResponseString);
            };
        }

        /**
         * The API endpoint URL string.
         *
         * @return The API endpoint URL string.
         */
        @Override
        public String getApiEndpoint() {
            return "/prospect/query";
        }
       
        /**
         * Set the Id property.
         */ 
        public MyTestRequest withId(final long id) {
            return setParam("id", id);
        } 

        /**
         * Set other property.
         */ 
        public MyTestRequest withOtherProperty(final String value) {
            return setParam("other", value);
        }
    } 
```

```java
    /**
     * Example usage of the above class:
     */
    PardotClient apiClient = new PardotClient(new Configuration("username", "password", "api-key"));

    // Construct custom request class instance
    MyTestRequest myCustomRequest = new MyTestRequest()
        .withId(123L)
        .withOtherProperty("SomeValue");

    // Execute the request and get the parsed response returned
    MyCustomReturnObject parsedApiResponse = apiClient.userDefinedRequest(myCustomRequest);
```

## 1.0.1 (12/12/2019)

#### Bugfixes
- [Issue-35](https://github.com/Crim/pardot-java-client/issues/35) Submit POST parameters using UTF-8 charset by default.
- [Issue-36](https://github.com/Crim/pardot-java-client/issues/36) Sending email with the scheduled_time was broken due to improperly formatted value. 

#### Internal Dependency Updates
- org.apache.httpcomponents:httpclent from 4.5.6 to 4.5.10
- org.apache.logging.log4j from 2.11.0 to 2.12.1
- com.fasterxml.jackson.core:jackson-databind from 2.9.9 to 2.10.1

## 1.0.0 (08/19/2018)
### Breaking Change 

As of October 31, 2018 Pardot is disabling the TLS 1.0 encryption protocol.  This means that versions of this library
prior to 1.0.0 will cease to be able to connect to the Pardot Api.

Version 1.0.0 updates the library to use TLS 1.1 and 1.2 protocols. Everyone is encouraged to update
the library prior to October 31st 2018.

## 0.6.0 (08/09/2018)
- Adds support for Tags and TagObjects, Thanks [LoRez](https://github.com/lorez)!

## 0.5.0 (07/14/2018)
- Add support for Form, Email Template end points.
- Updates jackson dependency for [CVE-2018-7489](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2018-7489).

## 0.4.0 (12/25/2017)
- Add support for CustomField, CustomRedirect API, EmailClicks, and Opportunity end points.
- Client will change configured API version from 3 to 4 automatically upon login.
- Fixed bug in VisitorQueryRequest around querying for multiple foreign key ids.
- Fixed bug in ordering of request parameters.

## 0.3.0 (12/15/2017)
- Add support for Visitor and VisitorActivity API endpoints.
- Bugfix to Prospect parser.

## 0.2.0 (11/11/2017)
- Support Api version 4 via configuration method .withApiVersion4()
- Add support for List and ListMembership API endpoints.

## 0.1.0 (08/15/2017)
- Initial release!