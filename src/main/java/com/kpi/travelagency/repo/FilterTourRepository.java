package com.kpi.travelagency.repo;

import com.kpi.travelagency.entity.FilterTourData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterTourRepository extends JpaRepository<FilterTourData,Long> {
}
