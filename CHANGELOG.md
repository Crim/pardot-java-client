# Change Log
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## 0.5.0 (01/21/18)
- Add support for Form, Email Template end points.
- Upgrade Jackson for [CVE-2017-17485](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2017-17485)

## 0.4.0 (12/25/17)
- Add support for CustomField, CustomRedirect API, EmailClicks, and Opportunity end points.
- Client will change configured API version from 3 to 4 automatically upon login.
- Fixed bug in VisitorQueryRequest around querying for multiple foreign key ids.
- Fixed bug in ordering of request parameters.

## 0.3.0 (12/15/17)
- Add support for Visitor and VisitorActivity API endpoints.
- Bugfix to Prospect parser.

## 0.2.0 (11/11/17)
- Support Api version 4 via configuration method .withApiVersion4()
- Add support for List and ListMembership API endpoints.

## 0.1.0 (08/15/17)
- Initial release!