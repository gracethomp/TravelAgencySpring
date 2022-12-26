package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    /*public List<Tour> findAll(int pageNumber, int rowPerPage) {
        List<Tour> tours = new ArrayList<>();
        Pageable sortedByLastUpdateDesc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        tourRepository.findAll(sortedByLastUpdateDesc);
        return tours;
    }*/
    public List<Tour> findAll() {
        List<Tour> tours = new ArrayList<>(tourRepository.findAll());
        return tours;
    }
}
