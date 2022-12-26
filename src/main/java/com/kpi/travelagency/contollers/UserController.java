package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.repo.UserRepository;
import com.kpi.travelagency.service.TourService;
import com.kpi.travelagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.findAll();
        System.out.println(Arrays.toString(users.toArray()));
        model.addAttribute("users", users);
        return "users";

    }
}