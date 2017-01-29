package com.github.srang.madness.model.entities;

import com.github.javafaker.Faker;
import com.github.srang.datafactory.BaseFactory;
import com.github.srang.datafactory.DataFactory;
import com.github.srang.util.BracketFieldPopulationStrategy;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by srang on 12/17/16.
 */
public class UserTest {
    @Test
    public void testUserGetRoles() {
        String username = "jdoe";
        User u = User.builder().username(username)
                .build();
        u.addRole("ROLE_USER");
        u.addRole("ROLE_ADMIN");
        List<String> roles = u.getRoles();
        assertThat(roles, is(Arrays.asList("ROLE_USER", "ROLE_ADMIN")));
    }

    @Test
    public void testFactory() {
        DataFactory<Game> factory = new BaseFactory<>(Game.class, new BracketFieldPopulationStrategy(new Faker()));
        Game u = factory.generate();
        assertThat(u, not(nullValue()));
    }
}
