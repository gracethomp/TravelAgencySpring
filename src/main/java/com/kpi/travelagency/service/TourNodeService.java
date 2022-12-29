package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.TourNode;
import com.kpi.travelagency.repo.TourNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourNodeService {
    @Autowired
    private TourNodeRepository tourNodeRepository;
    public TourNode save(TourNode tourNode){
        return tourNodeRepository.save(tourNode);
    }
}
