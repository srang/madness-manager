package org.srang.madness.manager.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srang.madness.manager.model.entities.Game;
import org.srang.madness.manager.model.entities.Region;
import org.srang.madness.manager.model.repositories.BracketRepository;
import org.srang.madness.manager.model.repositories.GameRepository;
import org.srang.madness.manager.model.repositories.TeamRepository;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.srang.madness.manager.model.entities.Region.RegionType.*;

/**
 * Created by srang on 12/17/16.
 */
@Log
@Service
public class BracketService {
    @Autowired
    BracketRepository bracketRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    TeamRepository teamRepository;

    public Map<Region, List<Game>> generateMatchups() {
        List<Region> regions = Arrays.asList(EAST,WEST,SOUTH,MIDWEST).stream()
                .map(Region.RegionType::region).collect(toList());
        Map<Region, List<Game>> master = new HashMap<>();
        for (Region r : regions) {
            List<Game> games = new ArrayList<>();
            for (int i = 1; i < 9; i++) {
                games.add(Game.builder()
                        .isMaster(true)
                        .round(1)
                        .build()
                );
            }
            master.put(r, games);
        }
        return master;
    }
}
