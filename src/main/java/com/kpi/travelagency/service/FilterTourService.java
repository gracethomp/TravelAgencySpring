package com.kpi.travelagency.service;


import com.kpi.travelagency.entity.FilterTourData;
import com.kpi.travelagency.entity.Tour;

public interface FilterTourService {
    FilterTourData saveData(FilterTourData data) throws Exception;
    FilterTourData findById(Long id);
}
