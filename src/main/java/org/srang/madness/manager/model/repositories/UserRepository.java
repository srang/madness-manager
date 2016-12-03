package org.srang.madness.manager.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srang.madness.manager.model.entities.User;

import java.util.List;

/**
 * Created by srang on 12/3/16.
 */
public interface UserRepository  extends CrudRepository<User, Integer>{
    public List<User> findByLastName(String last);
}
