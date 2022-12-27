package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Tour;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class FormVoucherController {
    @GetMapping("/formVoucher")
    public String formVoucher(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "formVoucher";
    }
}
