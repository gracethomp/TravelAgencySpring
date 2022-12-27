package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.Voucher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends Neo4jRepository<Voucher, Integer> {
}
