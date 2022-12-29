package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Country;
import com.kpi.travelagency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    @Autowired private CountryService countryService;

    //save
    @PostMapping("/countries")
    public Country saveCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    //read
    @GetMapping("/countries")
    public List<Country> findAll(){
        return countryService.findAll();
    }

    //update
    @PutMapping("/countries/{id}")
    public Country updateCountry(@RequestBody Country country, @PathVariable("id") Long countryId){
        return countryService.updateCountry(country,countryId);
    }

    //delete
    @DeleteMapping("/countries/{id}")
    public String deleteCountryById(@PathVariable("id") Long countryId){
        countryService.deleteCountryById(countryId);
        return "Deleted Successfully";
    }
}
