package com.kpi.travelagency.service;

import java.time.LocalDate;

public interface TourService {
    void createTour(Long id);
    void editTour(String tour);
    void deleteTour(String tour);
    void getInfoTour(String tour);
    void findTourByDirection(String direction);
    void findTourByRating(String rating);
    void findByDate(LocalDate localDateFrom);
}
