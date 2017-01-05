package org.srang.madness.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srang.madness.manager.model.entities.Team;
import org.srang.madness.manager.model.repositories.TeamRepository;

import java.util.List;

/**
 * Created by srang on 12/21/16.
 */
@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.getRealTeams();
    }
}
