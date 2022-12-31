package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{email : ?0}", exists = true)
    Boolean findByEmail(String email);

    @Query(value = "{email : ?0}")
    User findUserByEmail(String email);

}
