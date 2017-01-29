package com.github.srang.madness.model.repositories;

import com.github.srang.madness.model.entities.Team;
import com.github.srang.madness.model.types.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by srang on 12/17/16.
 */
public interface TeamRepository extends CrudRepository<Team, Integer> {

    @Query("SELECT t FROM Team t WHERE t.name != 'TBasdfasdfD'")
    List<Team> getRealTeams();

    List<Team> findByRegion(Region region);
}
