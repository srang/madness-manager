package com.github.srang.madness.model.forms;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by srang on 1/28/17.
 */
public class FormMapTest {
    @Test
    public void testBracketForm() throws Exception {
        BracketForm form = new BracketForm();
        Map<Integer, Map<Integer, GameTouple>> t = form.getGames();
        assertThat(t, not(nullValue()));
        assertThat(t.get(0), not(nullValue()));

    }
}
