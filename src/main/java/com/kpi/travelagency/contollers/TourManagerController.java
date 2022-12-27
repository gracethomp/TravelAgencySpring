package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Country;
import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.service.CountryService;
import com.kpi.travelagency.service.TourService;
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


    @GetMapping("/toursManager")
    public String tours(Model model) {
        List<Tour> tours = tourService.findAll();
        System.out.println(Arrays.toString(tours.toArray()));
        model.addAttribute("tours", tours);
        return "toursManager";
    }
    @GetMapping(value = "/toursManager/{id}")
    public String getUserById(Model model, @PathVariable Long id){
        Tour tour = null;
        try {
            tour = tourService.findById(id);
            model.addAttribute("allowDelete", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("tour",tour);
        return "tour";
    }
    @GetMapping("/toursManager/createTour")
    public String createTour(Model model){
        Tour tour = new Tour();
        model.addAttribute("add",true);
        model.addAttribute("tour",tour);
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
        return "tour";
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
            return "tour";
        }
    }


}
