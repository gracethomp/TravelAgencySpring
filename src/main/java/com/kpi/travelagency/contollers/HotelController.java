package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.*;
import com.kpi.travelagency.service.CityService;
import com.kpi.travelagency.service.CountryService;
import com.kpi.travelagency.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HotelController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HotelService hotelService;
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;

    @GetMapping("/hotels")
    public String tours(Model model) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }
    @GetMapping(value = "/hotels/{id}")
    public String getHotelById(Model model, @PathVariable Long id){
        Hotel hotel = null;
        try {
            hotel = hotelService.findById(id);
            model.addAttribute("allowDelete", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("hotel",hotel);
        return "viewHotel";
    }

    @GetMapping("/hotels/createHotel")
    public String createHotel(Model model){
        Hotel hotel = new Hotel();
        model.addAttribute("add",true);
        model.addAttribute("hotel", hotel);
        List<Country> countries = countryService.findAll();
        List<City> cities = cityService.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("cities", cities);
        return "createHotel";
    }

    @PostMapping("/hotels/createHotel")
    public String addHotel(Model model,
                          @ModelAttribute("hotel") Hotel hotel) throws Exception {
        try {
            Hotel newHotel = hotelService.saveHotel(hotel);
            return "redirect:/hotels";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage",errorMessage);
            model.addAttribute("add",true);
            return "createHotel";
        }
    }

    @GetMapping(value = {"/hotels/{id}/editHotel"})
    public String showEditHotel(Model model, @PathVariable Long id) {
        Hotel hotel = null;
        try {
            hotel = hotelService.findById(id);
        } catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("add",false);
        model.addAttribute("hotel",hotel);

        //for listing and selecting countries / cities
        List<Country> countries = countryService.findAll();
        List<City> cities = cityService.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("cities", cities);
        return "createHotel";
    }

    @PostMapping(value = {"/hotels/{id}/editHotel"})
    public String updateHotel(Model model,
                             @PathVariable Long id,
                             @ModelAttribute("hotel") Hotel hotel){
        try{
            hotel.setId(id);
            hotelService.updateHotel(hotel);
            return "redirect:/hotels";
        } catch (Exception ex){
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add",false);
            return "createHotel";
        }
    }

    @GetMapping(value = {"/hotels/{id}/delete"})
    public String showDeleteHotel(
            Model model, @PathVariable Long id) {
        Hotel hotel = null;
        try{
            hotel = hotelService.findById(id);
        } catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("allowDelete",true);
        model.addAttribute("hotel",hotel);
        return "viewHotel";
    }

    @PostMapping(value = {"/hotels/{id}/delete"})
    public String deleteHotelById(
            Model model, @PathVariable Long id) {
        try {
            hotelService.deleteHotelById(id);
            return "redirect:/hotels";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage",errorMessage);
            return "viewHotel";
        }
    }
}
