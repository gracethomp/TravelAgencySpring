package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.*;
import com.kpi.travelagency.repo.UserRepository;
import com.kpi.travelagency.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SignUpController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signUp")
    public String signUp(Model model){
        User user = new User();
        model.addAttribute("add",true);
        model.addAttribute("user", user);
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(Model model,
                          @ModelAttribute("user") User user) throws Exception {
        try {
            User newUser = userService.saveUser(user);
            return "redirect:/users";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add",true);
            return "signUp";
        }
    }

    @GetMapping(value = {"/users/{id}/editProfile"})
    public String showUpdateProfile(Model model, @PathVariable String id) {
        User user = null;
        try {
            user = userService.findUserByID(id);
        } catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("add",false);
        model.addAttribute("user", user);
        return "signUp";
    }

    @PostMapping(value = {"/users/{id}/editProfile"})
    public String updateProfile(Model model,
                                @PathVariable String id,
                                @ModelAttribute("user") User user){
        try{
            user.setId(id);
            userService.updateProfile(user);
            return "redirect:/users";
        } catch (Exception ex){
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add",false);
            return "user";
        }
    }

    @RequestMapping(value = {"/users/{id}/delete"}, method = { RequestMethod.GET, RequestMethod.POST })
    public String deleteTourById(
            Model model, @PathVariable String id) {
        try {
            userService.deleteUserById(id);
            return "redirect:/users";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage",errorMessage);
            return "user";
        }
    }
}