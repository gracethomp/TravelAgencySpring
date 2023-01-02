package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.*;
import com.kpi.travelagency.repo.HotelRepository;
import com.kpi.travelagency.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class TourManagerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TourService tourService;
    @Autowired
    CountryService countryService;
    @Autowired
    CityService cityService;
    @Autowired
    HotelService hotelService;
    @Autowired
    FilterTourService filterTourService;


    @GetMapping("/toursManager")
    public String tours(Model model) {
        FilterTourData data = new FilterTourData();
        model.addAttribute("filterData",data);
        List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "toursManager";
    }

    @GetMapping("/toursManager/filtered/{id}")
    public String toursFilter(Model model, @PathVariable("id") Long id) {
        try {
            FilterTourData data = filterTourService.findById(id);
            model.addAttribute("filterData",data);
            List<Tour> toursAll = tourService.findAll();
            List<Tour> filteredTours1 = tourService.findAllByCountry(toursAll, data.getCountry());
            List<Tour> filteredTours2 = tourService.findAllByCity(filteredTours1,data.getCity());
            List<Tour> filteredTours3 = tourService.findAllByTransportation(filteredTours2,data.getTransportType());
            List<Tour> filteredTours4 = tourService.findAllByHotelRating(filteredTours3,data.getHotelRating());
            List<Tour> filteredTours5 = tourService.findAllByPriceRange(filteredTours4, data.getStartPrice(), data.getEndPrice());
            List<Tour> filteredTours6 =tourService.findAllBetweenDates(filteredTours5,data.getStartDate(),data.getEndDate());
            List<Tour> tours = filteredTours6;
            model.addAttribute("tours", tours);
            return "toursManager";
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "toursManager";
        }
    }


    @PostMapping("/toursManager")
    public String saveFilterData(Model model,
                                 @ModelAttribute("filterData") FilterTourData data) throws Exception {
        try {
            FilterTourData newData = filterTourService.saveData(data);
            List<Tour> tours = tourService.findAll();
            model.addAttribute("tours", tours);
            return "toursManager";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage",errorMessage);
            return "toursManager";
        }
    }

    @GetMapping(value = "/toursManager/{id}")
    public String getTourById(Model model, @PathVariable Long id){
        Tour tour = null;
        try {
            tour = tourService.findById(id);
            model.addAttribute("allowDelete", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("tour",tour);
        return "viewTour";
    }

    @GetMapping("/toursManager/createTour")
    public String createTour(Model model){
        Tour tour = new Tour();
        model.addAttribute("add",true);
        model.addAttribute("tour",tour);
        List<Country> countries = countryService.findAll();
        List<City> cities = cityService.findAll();
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("cities", cities);
        model.addAttribute("hotels", hotels);
        return "createTour";
    }

    @PostMapping("/toursManager/createTour")
    public String addTour(Model model,
                          @ModelAttribute("tour") Tour tour) throws Exception {
        try {
            Tour newTour = tourService.saveTour(tour);
            return "redirect:/toursManager";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage",errorMessage);
            model.addAttribute("add",true);
            return "createTour";
        }
    }

    @GetMapping(value = {"/toursManager/{id}/editTour"})
    public String showEditTour(Model model, @PathVariable Long id) {
        Tour tour = null;
        try {
            tour = tourService.findById(id);
        } catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("add",false);
        model.addAttribute("tour",tour);

        //for listing and selecting countries / cities / hotels
        List<Country> countries = countryService.findAll();
        List<City> cities = cityService.findAll();
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("cities", cities);
        model.addAttribute("hotels", hotels);

        //for selecting transportation type
        String type = String.valueOf(tour.getTransportType());
        if (type=="BUS"){
            model.addAttribute("bus", true);
            model.addAttribute("train", false);
            model.addAttribute("plane", false);
        }
        else if (type == "TRAIN"){
            model.addAttribute("bus", false);
            model.addAttribute("train", true);
            model.addAttribute("plane", false);
        }
        else if (type == "PLANE"){
            model.addAttribute("bus", false);
            model.addAttribute("train", false);
            model.addAttribute("plane", true);
        }
        else{
            model.addAttribute("bus", false);
            model.addAttribute("train", false);
            model.addAttribute("plane", false);
        }
        return "createTour";
    }

    @PostMapping(value = {"/toursManager/{id}/editTour"})
    public String updateTour(Model model,
                             @PathVariable Long id,
                             @ModelAttribute("tour") Tour tour){
        try{
            tour.setId(id);
            tourService.updateTour(tour);
            return "redirect:/toursManager";
        } catch (Exception ex){
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add",false);
            return "createTour";
        }
    }

    @GetMapping(value = {"/toursManager/{id}/delete"})
    public String showDeleteTour(
            Model model, @PathVariable Long id) {
        Tour tour = null;
        try{
            tour = tourService.findById(id);
        } catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("allowDelete",true);
        model.addAttribute("tour",tour);
        return "viewTour";
    }

    @PostMapping(value = {"/toursManager/{id}/delete"})
    public String deleteTourById(
            Model model, @PathVariable Long id) {
        try {
            tourService.deleteTourById(id);
            return "redirect:/toursManager";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage",errorMessage);
            return "viewTour";
        }
    }


}

