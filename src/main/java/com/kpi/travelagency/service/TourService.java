package com.kpi.travelagency.service;

import com.kpi.travelagency.constants.TransportType;
import com.kpi.travelagency.entity.City;
import com.kpi.travelagency.entity.Country;
import com.kpi.travelagency.entity.Tour;

import java.time.LocalDate;
import java.util.List;

public interface TourService {
    //for CRUD:
    Tour findById(Long id);
    Tour saveTour(Tour tour) throws Exception;
    List<Tour> findAll();
    void updateTour(Tour tour) throws Exception;
    void deleteTourById(Long id) throws Exception;

    //for filtering data:
    List<Tour> findAllByCountry(List<Tour> tours, String country);
    List<Tour> findAllByCity(List<Tour> tours, String city);
    List<Tour> findAllBetweenDates(List<Tour> tours, LocalDate startDate, LocalDate endDate);
    List<Tour> findAllByTransportation(List<Tour> tours, String transportType);
    List<Tour> findAllByPriceRange(List<Tour> tours, Double startPrice, Double endPrice);
    List<Tour> findAllByHotelRating(List<Tour> tours, Integer hotelRating);

}
