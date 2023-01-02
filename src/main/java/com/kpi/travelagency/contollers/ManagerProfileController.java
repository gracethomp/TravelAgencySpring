package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Manager;
import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.repo.ManagerRepository;
import com.kpi.travelagency.repo.UserRepository;
import com.kpi.travelagency.service.ManagerService;
import com.kpi.travelagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ManagerProfileController {
    @Autowired
    ManagerService managerService;

    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("managerProfile/{id}")
    public String showProfile(@PathVariable String id, Model model){
        Manager manager = managerService.findManagerByID(id);
        model.addAttribute("manager", manager);
        model.addAttribute("add", true);
        return "managerProfile";
    }
}
