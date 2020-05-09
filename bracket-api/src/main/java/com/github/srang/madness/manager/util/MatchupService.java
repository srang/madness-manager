package com.github.srang.madness.manager.util;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class MatchupService {
    public List<Integer> seedMatchups(Integer numParticipants) {
        Integer rounds = (int) (Math.log(numParticipants) / Math.log(2) - 1 + 1e-10);
        List<Integer> matchups = Arrays.asList(1, 2);
        for (int i = 0; i < rounds; i++) {
            matchups = matchupLayer(matchups);
        }
        return matchups;
    }

    private List<Integer> matchupLayer(List<Integer> matchups) {
        List<Integer> output = new ArrayList<>();
        int length = matchups.size() * 2 + 1;
        matchups.forEach((Integer item) -> {
            output.add(item);
            output.add(length-item);
        });
        return output;
    }
}
