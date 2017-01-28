package org.srang.madness.manager.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.srang.madness.manager.model.entities.Tournament;

/**
 * Created by srang on 1/11/17.
 */
public interface TournamentRepository extends CrudRepository<Tournament,Integer> {

    @Query("SELECT t FROM Tournament t WHERE t.active = true")
    Tournament getActiveTournament();
}
