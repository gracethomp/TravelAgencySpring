package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

}
