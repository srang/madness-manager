package org.srang.madness.manager.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.srang.madness.manager.model.entities.Bracket;

/**
 * Created by srang on 12/17/16.
 */
public interface BracketRepository extends CrudRepository<Bracket, Integer> {
    @Query("SELECT b FROM Bracket b WHERE b.isMaster = true")
    Bracket findMasterBracket();
}
