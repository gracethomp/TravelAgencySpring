package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Tour;

import java.util.List;

public interface TourService {
    Tour findById(Long id);
    Tour saveTour(Tour tour) throws Exception;
    List<Tour> findAll();
    void updateTour(Tour tour) throws Exception;
    void deleteTourById(Long id) throws Exception;
}
