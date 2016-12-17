package org.srang.madness.manager.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srang.madness.manager.model.entities.Game;

/**
 * Created by srang on 12/17/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
}
