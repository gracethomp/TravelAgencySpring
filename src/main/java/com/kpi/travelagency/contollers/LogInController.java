package com.kpi.travelagency.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LogInController {
    @GetMapping("/logIn")
    public String logIn(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {

        model.put("name", name);
        return "logIn";
    }
}
