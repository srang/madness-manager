package com.github.srang.madness.model.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import com.github.srang.madness.model.entities.Bracket;
import com.github.srang.madness.model.entities.Game;
import com.github.srang.madness.service.BracketService;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static com.github.srang.madness.model.types.Round.SALACIOUS;

/**
 * Created by srang on 1/8/17.
 */
@Getter
@Setter
@Log
public class BracketForm {


    public BracketForm() {
        games = new FormMap<>(() -> new FormMap<Integer, GameTouple>(GameTouple.class));
    }

    public BracketForm(final BracketService service) {
        Bracket master = service.getMaster();
        games = new FormMap<>(() -> new FormMap<Integer, GameTouple>(GameTouple.class));
        games.put(SALACIOUS.id(), service.getRound(master, SALACIOUS).stream().collect(toMap(
                Game::getGameIndex,
                game -> {
                    GameTouple touple = new GameTouple();
                    touple.setTeamA(game.getTeamAlpha().getTeamId());
                    touple.setTeamB(game.getTeamBravo().getTeamId());
                    return touple;
                })
        ));

    }

    public BracketForm(final BracketService service, Bracket existing) {
        // fill in bracket form from existing bracket
        games = new HashMap<>();
        service.rounds().forEach((round) -> {
            games.put(round.id(), service.getRound(existing, round).stream().collect(
                    toMap(Game::getGameIndex, game -> new GameTouple(game))
            ));
        });
    }

    // < round, < game_index,gametouple >
    Map<Integer, Map<Integer, GameTouple>> games;
    String name;
    Integer user;
}
