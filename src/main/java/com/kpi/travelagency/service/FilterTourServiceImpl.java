package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.FilterTourData;
import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.repo.FilterTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterTourServiceImpl implements FilterTourService {
    @Autowired
    FilterTourRepository filterTourRepository;
    private boolean existsById(Long id){
        return filterTourRepository.existsById(id);
    }
    @Override
    public FilterTourData saveData(FilterTourData data) throws Exception {
        if (data.getId() != null && existsById(data.getId())) {
            throw new Exception("Filter data with id: " + data.getId() + " already exists");
        }
        return filterTourRepository.save(data);
    }

    @Override
    public FilterTourData findById(Long id) {
        FilterTourData data = filterTourRepository.findById(id).orElse(null);
        return data;
    }
}
