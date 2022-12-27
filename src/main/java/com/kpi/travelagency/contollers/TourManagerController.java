package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class TourManagerController {
    @Autowired
    TourService tourService;

    @GetMapping("/toursManager")
    public String tours(Model model) {
        List<Tour> tours = tourService.findAll();
        System.out.println(Arrays.toString(tours.toArray()));
        model.addAttribute("tours", tours);
        return "toursManager";
    }

    @GetMapping("/toursManager/createTour")
    public String createTour(Model model){
        model.addAttribute("tour",new Tour());
        return "createTour";
    }

    @RequestMapping
    public String saveTour(@ModelAttribute("tour") Tour tour){
        tourService.saveTour(tour);
        return "redirect:/";
    }

    @RequestMapping("toursManager/editTour/{id}")
    public ModelAndView showEditTourPage(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("new");
        Optional<Tour> tour = tourService.getTourById(id);
        mav.addObject("tour",tour);
        return mav;
    }

    @RequestMapping("toursManager/deleteTour/{id}")
    public String deleteTour(@PathVariable(name="id") Long id){
        tourService.deleteTourById(id);
        return "redirect:/";
    }
}
