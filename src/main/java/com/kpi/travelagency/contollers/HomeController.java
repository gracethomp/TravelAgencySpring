package com.kpi.travelagency.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {

        model.put("name", name);
        return "home";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "hello, letsCode!");
        return "main";
    }
}