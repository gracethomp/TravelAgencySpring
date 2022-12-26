package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.City;
import com.kpi.travelagency.entity.Country;
import com.kpi.travelagency.entity.Hotel;
import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TourController {
    @Autowired
    TourService tourService;

    @GetMapping("/tours")
    public String tours(Model model) {
        List<Tour> tours = tourService.findAll();
        System.out.println(Arrays.toString(tours.toArray()));
        model.addAttribute("tours", tours);
        return "tours";
    }
}
