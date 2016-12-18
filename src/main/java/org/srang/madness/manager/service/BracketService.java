package org.srang.madness.manager.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srang.madness.manager.model.repositories.BracketRepository;
import org.srang.madness.manager.model.repositories.GameRepository;
import org.srang.madness.manager.model.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

//    public Map<Region, List<Game>> generateMatchups() {
//        List<Region> regions = Arrays.asList(EAST,WEST,SOUTH,MIDWEST).stream()
//                .map(Region.RegionType::region).collect(toList());
//
//        Map<Region, List<Game>> master = new HashMap<>();
//        for (Region r : regions) {
//            List<Game> games = new ArrayList<>();
//            for (int i = 1; i < 9; i++) {
//                games.add(Game.builder()
//                        .isMaster(true)
//                        .round(1)
//                        .teamAlpha()
//                        .build()
//                );
//            }
//            master.put(r, games);
//        }
//        return master;
    public List<Integer> generateMatchups() {
        List<Integer> firstTeams = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        List<Integer> ret = new ArrayList<>();
        int count = firstTeams.size();
        while(count > 1) {
            if((count + 1 ) % 2 == 1) {
                ret.add(0, firstTeams.remove(1));
            } else {
                ret.add(0, firstTeams.remove(count - 2));
            }
            count -= 1;
            log.warning("count: " + count);
        }
        ret.add(0, firstTeams.remove(0));
        /*
        $first_teams = collect(range(1,8));
        $ret = collect([]);
        while (($c=$first_teams->count()) > 1) {
            if (($c + 1) % 2) {
                $hold = $first_teams->shift();
                $ret->prepend($first_teams->shift());
                $first_teams->prepend($hold);
            } else {
                $hold = $first_teams->pop();
                $ret->prepend($first_teams->pop());
                $first_teams->push($hold);
            }
        }
        $r = $first_teams->pop();
        $ret->prepend($r);
         */
        return ret;
    }

    public final BracketRepository repository() {
        return this.bracketRepository;
    }
}
