package org.srang.madness.manager.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.srang.madness.manager.model.entities.User;

import java.util.List;

/**
 * Created by srang on 12/3/16.
 */
public interface UserRepository  extends CrudRepository<User, Integer>{
    List<User> findByLastName(String last);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);
    User findByUsername(String username);
}
