package com.pzeszko.cleansound.repository;

import com.pzeszko.cleansound.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Pawel on 2017-01-03.
 */
@Repository
public interface UserRepository extends CrudRepositoryWithOptionalWrapper<User, Long> {

    Optional<User> findOneByEmail(String email);
}
