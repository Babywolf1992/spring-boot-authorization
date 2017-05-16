package com.babywolf.repository;

import com.babywolf.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by babywolf on 17/5/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
