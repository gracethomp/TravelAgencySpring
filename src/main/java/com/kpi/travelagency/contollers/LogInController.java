package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.repo.UserRepository;
import com.kpi.travelagency.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LogInController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/logIn")
    public String logIn(Model model){
        User user = new User();
        model.addAttribute("add",true);
        model.addAttribute("email", user.getEmail());
        return "/logIn";
    }

    @PostMapping("/logIn")
    public String logIn(Model model,
                        @RequestParam String email) throws Exception {
        try {
            User user1 = userService.logIn(email);
            return "redirect:/userProfile/" + user1.getId();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            return "/home";
        }
    }

}
