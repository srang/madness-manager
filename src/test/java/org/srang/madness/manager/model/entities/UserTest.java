package org.srang.madness.manager.model.entities;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by srang on 12/17/16.
 */
public class UserTest {
    @Test
    public void testUserGetRoles() {
        String username = "jdoe";
        User u = User.builder().username(username)
                .userRole(new UserRole(username, "ROLE_USER"))
                .userRole(new UserRole(username, "ROLE_ADMIN"))
                .build();
        List<String> roles = u.getRoles();
        assertThat(roles, is(Arrays.asList("ROLE_USER", "ROLE_ADMIN")));
    }
}
