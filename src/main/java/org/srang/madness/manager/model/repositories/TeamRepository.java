package org.srang.madness.manager.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srang.madness.manager.model.entities.Team;

/**
 * Created by srang on 12/17/16.
 */
public interface TeamRepository extends CrudRepository<Team, Integer> {
}
