package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Country;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country);
    List<Country> findAll();
    Country updateCountry(Country country, Long country_id);
    void deleteCountryById(Long country_id);
}
