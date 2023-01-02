package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.Manager;
import com.kpi.travelagency.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {

    @Query(value = "{email : ?0}", exists = true)
    Boolean findByEmail(String email);

    @Query(value = "{email : ?0}")
    Manager findManagerByEmail(String email);

}