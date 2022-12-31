package com.kpi.travelagency.contollers;

import com.kpi.travelagency.constants.Status;
import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.repo.UserRepository;
import com.kpi.travelagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserProfileController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("userProfile/{id}")
    public String showProfile(@PathVariable String id, Model model){
        User user = userService.findUserByID(id);
        model.addAttribute("user", user);
        model.addAttribute("add", true);
        return "userProfile";
    }
}
