package com.github.srang.madness.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.github.srang.madness.model.entities.Team;
import com.github.srang.madness.model.repositories.TeamRepository;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

/**
 * Created by srang on 1/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamServiceTest {
    @Mock
    TeamRepository teamRepository;

    @InjectMocks
    TeamService teamService;

    @Test
    public void testGetTeams() throws Exception {
        Team team1 = Team.builder().teamId(1).name("name").build();
        Team team2 = Team.builder().teamId(2).name("asdf").build();
        when(teamRepository.getRealTeams()).thenReturn(Arrays.asList(
                team2,
                team1
        ));
        Map<Integer, Team> teams = teamService.getTeams();
        assertThat(teams.get(1).getName(), is("name"));
        assertThat(teams.get(2).getName(), is("asdf"));
    }
}
