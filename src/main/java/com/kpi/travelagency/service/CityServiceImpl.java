package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.City;
import com.kpi.travelagency.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository repo;
    @Override
    public City saveCity(City city) {
        return repo.save(city);
    }

    @Override
    public List<City> findAll() {
        return (List<City>) repo.findAll();
    }

    @Override //need to finish later
    public City updateCity(City country, Long city_id) {
        return null;
    }

    @Override
    public void deleteCityById(Long city_id) {
        repo.deleteById(city_id);
    }
}
