package com.github.srang.madness.service;

import com.github.srang.madness.model.entities.Team;
import com.github.srang.madness.model.repositories.TeamRepository;
import com.github.srang.madness.model.types.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.srang.madness.model.forms.CreateMasterBracketForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toMap;

/**
 * Created by srang on 12/21/16.
 */
@Service
public class TeamService {
    @Value("${org.srang.madness.region.size}")
    Integer regionSize;
    @Autowired
    TeamRepository teamRepository;

    public Map<Integer, Team> getTeams() {
        return teamRepository.getRealTeams().stream()
                .sorted(comparing(Team::getTeamId))
                .collect(toMap(Team::getTeamId, t -> t));
    }

    public Map<Integer, Integer> getRankedRegionTeams(Region region) {
        List<Team> teams = teamRepository.findByRegion(region);
        if (teams == null) {
            teams = new ArrayList<>();
        }
        return teams.stream()
                .filter(t -> t.getRank() != null)
                .sorted(comparing(Team::getRank))
                .collect(toMap(Team::getRank, Team::getTeamId));
    }

    public void setTeamRegionRank(Integer teamId, Integer regionId, Integer rank) {
        Team team = teamRepository.findOne(teamId);
        team.setRank(rank);
        team.setRegion(Region.RegionType.valueOf(regionId).region());
        teamRepository.save(team);
    }

    @Transactional
    public void saveTeamsRanks(CreateMasterBracketForm bracketForm) {
        bracketForm.getRankedTeams().forEach((regionId, teams) -> {
            teams.forEach((rank, teamId) -> {
                if (teamId != null) {
                    setTeamRegionRank(teamId, regionId, rank);
                }
            });
        });
    }
}
