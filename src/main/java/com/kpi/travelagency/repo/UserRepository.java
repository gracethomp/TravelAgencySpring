package com.kpi.travelagency.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<String, Long> {
    String findUserByEmail();
}
