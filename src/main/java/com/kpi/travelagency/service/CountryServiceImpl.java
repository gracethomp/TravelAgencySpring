package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Country;
import com.kpi.travelagency.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository repo;

    @Override
    public Country saveCountry(Country country) {
        return repo.save(country);
    }

    @Override
    public List<Country> findAll() {
        return (List<Country>) repo.findAll();
    }

    @Override
    public Country updateCountry(Country country, Long country_id) {
        Country countDB = repo.findById(country_id).get();
        if (Objects.nonNull(country.getName())
                && !"".equalsIgnoreCase(
                country.getName())) {
            countDB.setName(
                    country.getName());
        }
        return repo.save(countDB);
    }

    @Override
    public void deleteCountryById(Long country_id) {
        repo.deleteById(country_id);
    }
}
