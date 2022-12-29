package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.service.TourServiceImpl;
import com.kpi.travelagency.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class StatisticController {
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private TourServiceImpl tourService;
    @GetMapping("/statistics")
    public String greeting(Model model) {
        List<Voucher> vouchers = voucherService.getVouchers();
        model.addAttribute("vouchers", vouchers);
        return "statistic";
    }
}
