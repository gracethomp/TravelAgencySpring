package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.repo.TourRepository;
import com.kpi.travelagency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }
    @Override
    public List<Tour> findAll() {
        List<Tour> tours = new ArrayList<>(tourRepository.findAll());
        return tours;
    }

    @Override //need to finish later
    public Tour updateTour(Tour tour, Long tourId) {
        return null;
    }

    @Override
    public void deleteTourById(Long tourId) {
        tourRepository.deleteById(tourId);
    }

    @Override
    public Optional<Tour> getTourById(Long tourId){
        return tourRepository.findById(tourId);
    }

     /*public List<Tour> findAll(int pageNumber, int rowPerPage) {
             List<Tour> tours = new ArrayList<>();
             Pageable sortedByLastUpdateDesc = PageRequest.of(pageNumber - 1, rowPerPage,
                     Sort.by("id").ascending());
             tourRepository.findAll(sortedByLastUpdateDesc);
             return tours;
         }*/
}
