package com.github.srang.madness.model.repositories;

import com.github.srang.madness.model.entities.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by srang on 1/11/17.
 */
public interface TournamentRepository extends CrudRepository<Tournament,Integer> {

    @Query("SELECT t FROM Tournament t WHERE t.active = true")
    Tournament getActiveTournament();
}
