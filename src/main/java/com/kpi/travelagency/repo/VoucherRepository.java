package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.TourNode;
import com.kpi.travelagency.entity.UserNode;
import com.kpi.travelagency.entity.Voucher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends Neo4jRepository<Voucher, Integer> {
    @Query("MATCH(n:Voucher{id:-1}) set n.id = ID(n) RETURN ID(n)")
    Integer setId();
    @Query("match (n:Voucher) with n match (e:User) where n.id = :#{#voucher.id} and e.id = :#{#user.id} create (e)-[:issued]->(n)")
    void makeOrder(@Param("voucher") Voucher voucher, @Param("user") UserNode userNode);
    @Query("match (n:Voucher) with n match (t:Tour) where n.id = :#{#voucher.id} and t.id = :#{#tour.id} create (t)-[:ordered_here]->(n)")
    void connectVoucherTour(@Param("voucher") Voucher voucher, @Param("tour") TourNode tourNode);
    @Query("match (n:User)-[:issued]-(u:Voucher) where n.id = :#{#user.id} return u")
    List<Voucher> vouchersByUserID(@Param("user") UserNode userNode);
    @Query("match (n:Tour)-[:ordered_here]-(u:Voucher) where n.id = :#{#tour.id} return u")
    List<Voucher> vouchersByTourID(@Param("tour") TourNode tourNode);
    @Query("match (n:Tour)-[:ordered_here]-(u:Voucher) where u.id = :#{#voucher.id} return n.id")
    List<Integer> getTourIdByVoucher(@Param("voucher") Voucher voucher);
    @Query("match (v:Voucher) where v.id = :#{#voucher.id} set v.status = :#{#status}")
    void setStatus(@Param("status") String status, @Param("voucher") Voucher voucher);
    @Query("match (n:Tour)-[:ordered_here]-(u:Voucher) where n.id = :#{#tourID} return count(u)")
    Integer getVoucherCountByTour(@Param("tourID") Integer tourID);
    @Query("match (n:Tour)-[:ordered_here]-(u:Voucher) where u.id = :#{#voucher.id} return n")
    List<TourNode> getTourNodes(@Param("voucher") Voucher voucher);
}
