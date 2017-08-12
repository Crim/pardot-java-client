package com.pardot.api.request.user;

import com.pardot.api.request.DateParameter;

/**
 *
 */
public class UserRequestBuilderTest {
    public void test() {
        new UserQueryRequest()
            .withCreatedAfter(DateParameter.today())
            .withCreatedBefore(DateParameter.last7Days())
            .withIdGreaterThan(1);
    }
}