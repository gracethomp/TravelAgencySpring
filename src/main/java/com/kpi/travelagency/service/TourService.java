package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Tour;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TourService {
    Tour saveTour(Tour tour);
    List<Tour> findAll();
    Tour updateTour(Tour tour, Long tourId);
    void deleteTourById(Long tourId);
    Optional<Tour> getTourById(Long tourId);
}
