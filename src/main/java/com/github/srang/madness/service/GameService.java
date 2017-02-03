package com.github.srang.madness.service;

import com.github.srang.madness.model.entities.Game;
import com.github.srang.madness.model.entities.Team;
import com.github.srang.madness.model.repositories.GameRepository;
import com.github.srang.madness.model.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by srang on 1/28/17.
 */
@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    TeamRepository teamRepository;

    // todo get rid of aorb
    public Game setTeamForGame(String aOrB, Integer teamId, Game game) {
        if (teamId != null) {
            Team team = teamRepository.findOne(teamId);
            switch (aOrB) {
                case "A":
                    game.setTeamAlpha(team);
                    break;
                case "B":
                    game.setTeamBravo(team);
                    break;
            }
            return gameRepository.save(game);
        } else {
            return null;
        }
    }

    public Team getWinner(Game game) {
        return null;
    }
}
