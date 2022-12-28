package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.UserNode;
import com.kpi.travelagency.entity.Voucher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends Neo4jRepository<Voucher, Integer> {
    @Query("MATCH(n:Voucher{id:-1}) set n.id = ID(n) RETURN ID(n)")
    Integer setId();
    @Query("match (n:Voucher) with n match (e:User) where n.id = :#{#voucher.id} create (e)-[:issued]->(n)")
    void makeOrder(@Param("voucher") Voucher voucher, @Param("user") UserNode userNode);
}
