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

package com.darksci.pardot.api.request.user;

import com.darksci.pardot.api.response.user.NewUser;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserCreateRequestTest {

    /**
     * Tests the withUser() method where the NewUser has the role set by id.
     */
    @Test
    public void testWithUser_usingRoleId() {
        final String firstName = "FirstName";
        final String lastName = "MyLastName";
        final String phone = "123-123-1234";
        final String email = "test@test.com";
        final boolean isPasswordExpirable = false;
        final String crmUsername = "CrmUserNameHere";
        final String jobTitle = "This is A Job Title";
        final String url = "http://www.example.com";
        final DateTimeZone timeZone = DateTimeZone.getDefault();
        final Long roleId = 123L;
        final String roleName = null;

        final NewUser newUser = new NewUser()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setPasswordExpirable(isPasswordExpirable)
            .setCrmUsername(crmUsername)
            .setPhone(phone)
            .setTimezone(timeZone)
            .setJobTitle(jobTitle)
            .setUrl(url)

            // Set roleId first, then name, tho it shouldn't really matter.
            .setRoleId(roleId)
            .setRole(roleName);

        // Create request using user object.
        final UserCreateRequest request = new UserCreateRequest().withUser(newUser);

        // Validate properties got loaded
        final Map<String, String> properties = request.getRequestParameters();

        assertEquals("should have 10 properties.", 10, properties.size());

        assertEquals(firstName, properties.get("first_name"));
        assertEquals(lastName, properties.get("last_name"));
        assertEquals(email, properties.get("email"));
        assertEquals(crmUsername, properties.get("crm_username"));
        assertEquals("false", properties.get("is_password_expirable"));
        assertEquals(jobTitle, properties.get("job_title"));
        assertEquals(url, properties.get("url"));
        assertEquals(timeZone.getID(), properties.get("timezone"));
        assertEquals(phone, properties.get("phone"));
        assertEquals(Long.toString(roleId), properties.get("role_id"));
        assertFalse(properties.containsKey("role_name"));
    }

    /**
     * Tests the withUser() method where the NewUser has the role set by id.
     */
    @Test
    public void testWithUser_usingRoleName() {
        final String firstName = "FirstName";
        final String lastName = "MyLastName";
        final String phone = "123-123-1234";
        final String email = "test@test.com";
        final boolean isPasswordExpirable = false;
        final String crmUsername = "CrmUserNameHere";
        final String jobTitle = "This is A Job Title";
        final String url = "http://www.example.com";
        final DateTimeZone timeZone = DateTimeZone.getDefault();
        final Long roleId = null;
        final String roleName = "MyRoleName";

        final NewUser newUser = new NewUser()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setPasswordExpirable(isPasswordExpirable)
            .setCrmUsername(crmUsername)
            .setPhone(phone)
            .setTimezone(timeZone)
            .setJobTitle(jobTitle)
            .setUrl(url)

            // Set roleName first, then id, tho it shouldn't really matter.
            .setRole(roleName)
            .setRoleId(roleId);

        // Create request using user object.
        final UserCreateRequest request = new UserCreateRequest().withUser(newUser);

        // Validate properties got loaded
        final Map<String, String> properties = request.getRequestParameters();

        assertEquals("should have 10 properties.", 10, properties.size());

        assertEquals(firstName, properties.get("first_name"));
        assertEquals(lastName, properties.get("last_name"));
        assertEquals(email, properties.get("email"));
        assertEquals(crmUsername, properties.get("crm_username"));
        assertEquals("false", properties.get("is_password_expirable"));
        assertEquals(jobTitle, properties.get("job_title"));
        assertEquals(url, properties.get("url"));
        assertEquals(timeZone.getID(), properties.get("timezone"));
        assertEquals(phone, properties.get("phone"));
        assertEquals(roleName, properties.get("role_name"));
        assertFalse(properties.containsKey("role_id"));
    }
}