package org.srang.madness.manager.model.forms;

import lombok.Getter;
import lombok.Setter;
import org.srang.madness.manager.model.entities.Bracket;
import org.srang.madness.manager.model.entities.Game;
import org.srang.madness.manager.service.BracketService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.srang.madness.manager.model.types.Round.SALACIOUS;

/**
 * Created by srang on 1/8/17.
 */
@Getter
@Setter
public class BracketForm {


    public BracketForm() {
    }

    public BracketForm(final BracketService service) {
        Bracket master = service.getMaster();
        games = new HashMap<>();
        List<Game> firstRound = service.getRound(master, SALACIOUS);
        games.put(null, null);
    }

    private class GameTouple {
        Integer teamA;
        Integer teamB;
    }

    Map<Integer, Map<Integer,GameTouple>> games;
    String name;
    Integer user;
}
