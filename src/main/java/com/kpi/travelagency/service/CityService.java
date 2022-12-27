package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.City;

import java.util.List;

public interface CityService {
    City saveCity(City city);
    List<City> findAll();
    City updateCity(City country, Long city_id);
    void deleteCityById(Long city_id);
}
