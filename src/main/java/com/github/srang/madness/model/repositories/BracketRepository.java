package com.github.srang.madness.model.repositories;

import com.github.srang.madness.model.entities.Bracket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by srang on 12/17/16.
 */
public interface BracketRepository extends CrudRepository<Bracket, Integer> {
    @Query("SELECT b FROM Bracket b WHERE b.isMaster = true")
    Bracket findMasterBracket();
}
