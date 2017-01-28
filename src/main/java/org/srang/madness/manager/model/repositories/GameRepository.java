package org.srang.madness.manager.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srang.madness.manager.model.entities.Bracket;
import org.srang.madness.manager.model.entities.Game;

import java.util.List;

/**
 * Created by srang on 12/17/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByBracketAndRound(Bracket bracket, Integer round);
}
