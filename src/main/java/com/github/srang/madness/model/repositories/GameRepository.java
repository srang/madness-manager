package com.github.srang.madness.model.repositories;

import org.springframework.data.repository.CrudRepository;
import com.github.srang.madness.model.entities.Bracket;
import com.github.srang.madness.model.entities.Game;

import java.util.List;

/**
 * Created by srang on 12/17/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByBracketAndRound(Bracket bracket, Integer round);
}
