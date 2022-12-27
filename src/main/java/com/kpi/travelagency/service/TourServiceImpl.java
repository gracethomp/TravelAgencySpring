package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    private boolean existsById(Long id){
        return tourRepository.existsById(id);
    }

    @Override
    public Tour findById(Long id){
        return tourRepository.findById(id).orElse(null);
    }

    @Override
    public Tour saveTour(Tour tour) throws Exception{
        if (tour.getId() != null && existsById(tour.getId())) {
            throw new Exception("Tour with id: " + tour.getId() + " already exists");
        }
        return tourRepository.save(tour);
    }
    @Override
    public List<Tour> findAll() {
        List<Tour> tours = new ArrayList<>(tourRepository.findAll());
        return tours;
    }

    @Override
    public void updateTour(Tour tour) throws Exception {
        if (!existsById(tour.getId())) {
            throw new Exception("Cannot find tour with id: " + tour.getId());
        }
        tourRepository.save(tour);
    }

    @Override
    public void deleteTourById(Long id) throws Exception{
        if (!existsById(id)) {
            throw new Exception("Cannot find tour with id: " + id);
        }
        else {
            tourRepository.deleteById(id);
        }
    }


    /*public List<Tour> findAll(int pageNumber, int rowPerPage) {
            List<Tour> tours = new ArrayList<>();
            Pageable sortedByLastUpdateDesc = PageRequest.of(pageNumber - 1, rowPerPage,
                    Sort.by("id").ascending());
            tourRepository.findAll(sortedByLastUpdateDesc);
            return tours;
        }*/
}
