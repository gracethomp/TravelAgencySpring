package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.TourNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourNodeRepository extends Neo4jRepository<TourNode, Integer> {
}
