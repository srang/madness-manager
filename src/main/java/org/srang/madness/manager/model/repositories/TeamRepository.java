package org.srang.madness.manager.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.srang.madness.manager.model.types.Region;
import org.srang.madness.manager.model.entities.Team;

import java.util.List;

/**
 * Created by srang on 12/17/16.
 */
public interface TeamRepository extends CrudRepository<Team, Integer> {

    @Query("SELECT t FROM Team t WHERE t.name != 'TBD'")
    List<Team> getRealTeams();

    List<Team> findByRegion(Region region);
}
