package com.github.srang.madness.model.forms;

import com.github.srang.madness.model.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by srang on 1/12/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameTouple {
    public Integer teamA;
    public Integer teamB;

    public GameTouple(Game game) {
        try {
            teamA = game.getTeamAlpha().getTeamId();
        } catch (NullPointerException e) {
            // team must not be populated, move on
        }
        try {
            teamB = game.getTeamBravo().getTeamId();
        } catch (NullPointerException e) {
            // team must not be populated, move on
        }
    }
}
