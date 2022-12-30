package com.kpi.travelagency.service;

import com.kpi.travelagency.constants.TransportType;
import com.kpi.travelagency.entity.City;
import com.kpi.travelagency.entity.Country;
import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.repo.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        Tour tour = tourRepository.findById(id).orElse(null);
        return tour;
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


    //for filters:
    @Override
    public List<Tour> findAllByCountry(List<Tour> tours, String country) {
        List<Tour> filteredTours = new ArrayList<>();
        if(country==null || country.equals("")){
            return tours;
        }
        for (int i=0; i<tours.size();i++){
            if (tours.get(i).getCountry().getName().toUpperCase().equals(country.toUpperCase())==true){
                filteredTours.add(tours.get(i));
            }
        }
        return  filteredTours;
    }

    @Override
    public List<Tour> findAllByCity(List<Tour> tours, String city) {
        List<Tour> filteredTours = new ArrayList<>();
        if(city==null || city.equals("")){
            return tours;
        }
        for (int i=0; i<tours.size();i++){
            if (tours.get(i).getId_city().getName().toUpperCase().equals(city.toUpperCase())==true){
                filteredTours.add(tours.get(i));
            }
        }
        return filteredTours;
    }

    @Override
    public List<Tour> findAllBetweenDates(List<Tour> tours, LocalDate startDate, LocalDate endDate) {
        List<Tour> filteredTours = new ArrayList<>();
        if(startDate==null && endDate!=null){
            for (int i=0; i<tours.size();i++){
                LocalDate tourStartDate = tours.get(i).getStartDate();
                LocalDate tourEndDate = tours.get(i).getEndDate();
                if (endDate.isAfter(tourEndDate) || endDate.isEqual(tourEndDate)) {
                    filteredTours.add(tours.get(i));
                }
            }
            return filteredTours;
        }
        else if(startDate!=null && endDate==null){
            for (int i=0; i<tours.size();i++){
                LocalDate tourStartDate = tours.get(i).getStartDate();
                LocalDate tourEndDate = tours.get(i).getEndDate();
                if (startDate.isBefore(tourStartDate) ||startDate.isEqual(tourStartDate)){
                    filteredTours.add(tours.get(i));
                }
            }
            return filteredTours;
        }
        else if (startDate==null && endDate==null){
            return tours;
        }
        else if (startDate.toString().equals("") && endDate.toString().equals("")){
            return tours;
        }
        else{
            for (int i=0; i<tours.size();i++){
                LocalDate tourStartDate = tours.get(i).getStartDate();
                LocalDate tourEndDate = tours.get(i).getEndDate();
                if ((startDate.isBefore(tourStartDate) ||startDate.isEqual(tourStartDate))
                        && (endDate.isAfter(tourEndDate) || endDate.isEqual(tourEndDate))) {
                    filteredTours.add(tours.get(i));
                }
            }
            return filteredTours;
        }
    }

    @Override
    public List<Tour> findAllByTransportation(List<Tour> tours, String transportType) {
        List<Tour> filteredTours = new ArrayList<>();
        if(transportType==null || transportType.equals("")){
            return tours;
        }
        for (int i=0; i<tours.size();i++){
            if (tours.get(i).getTransportType().toString().equals(transportType.toUpperCase())==true){
                filteredTours.add(tours.get(i));
            }
        }
        return filteredTours;
    }

    @Override
    public List<Tour> findAllByPriceRange(List<Tour> tours, Double startPrice, Double endPrice) {
        List<Tour> filteredTours = new ArrayList<>();
        if(startPrice==null && endPrice==null){
            return tours;
        }
        else if(startPrice==null && endPrice!=null){
            for (int i=0; i<tours.size();i++){
                if (tours.get(i).getPrice()<=endPrice){
                    filteredTours.add(tours.get(i));
                }
            }
            return filteredTours;
        }
        else if(startPrice!=null && endPrice==null){
            for (int i=0; i<tours.size();i++){
                if (tours.get(i).getPrice()>=startPrice){
                    filteredTours.add(tours.get(i));
                }
            }
            return filteredTours;
        }
        else{
            for (int i=0; i<tours.size();i++){
                if (tours.get(i).getPrice()>=startPrice && tours.get(i).getPrice()<=endPrice){
                    filteredTours.add(tours.get(i));
                }
            }
            return filteredTours;
        }
    }

    @Override
    public List<Tour> findAllByHotelRating(List<Tour> tours, Integer hotelRating) {
        List<Tour> filteredTours = new ArrayList<>();
        if(hotelRating==null){
            return tours;
        }
        else{
            for (int i=0; i<tours.size();i++){
                if (tours.get(i).getId_hotel().getRating()==hotelRating){
                    filteredTours.add(tours.get(i));
                }
            }
            return filteredTours;
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

