package com.kpi.travelagency.controller;

import com.kpi.travelagency.entity.City;
import com.kpi.travelagency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired private CityService cityService;

    //save
    @PostMapping("/cities")
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    //read
    @GetMapping("/cities")
    public List<City> findAll(){
        return cityService.findAll();
    }

    //update
    @PutMapping("/cities/{id}")
    public City updateCity(@RequestBody City city, @PathVariable("id") Long cityId){
        return cityService.updateCity(city,cityId);
    }

    //delete
    @DeleteMapping("/cities/{id}")
    public String deleteCityById(@PathVariable("id") Long cityId){
        cityService.deleteCityById(cityId);
        return "Deleted Successfully";
    }
}
