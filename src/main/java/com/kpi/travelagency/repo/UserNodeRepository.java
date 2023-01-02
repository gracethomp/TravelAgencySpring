package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNodeRepository extends Neo4jRepository<UserNode, String> {
}
