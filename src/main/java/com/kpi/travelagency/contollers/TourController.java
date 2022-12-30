package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.*;
import com.kpi.travelagency.service.FilterTourService;
import com.kpi.travelagency.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TourController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TourService tourService;
    @Autowired
    FilterTourService filterTourService;

    @GetMapping("/tours")
    public String tours(Model model) {
        FilterTourData data = new FilterTourData();
        model.addAttribute("filterData",data);
        List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "tours";
    }

    @GetMapping("/tours/filtered/{id}")
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
            return "tours";
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "tours";
        }
    }


    @PostMapping("/tours")
    public String saveFilterData(Model model,
                                 @ModelAttribute("filterData") FilterTourData data) throws Exception {
        try {
            FilterTourData newData = filterTourService.saveData(data);
            List<Tour> tours = tourService.findAll();
            model.addAttribute("tours", tours);
            return "tours";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage",errorMessage);
            return "tours";
        }
    }
}
