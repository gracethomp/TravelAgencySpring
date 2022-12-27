package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class VoucherController {
    @Autowired
    VoucherService voucherService;
    @GetMapping("/vouchers")
    public String tours(Model model) {
        List<Voucher> vouchers = voucherService.getVouchers("totalPrice");
        model.addAttribute("vouchers", vouchers);

        return "vouchers";
    }
}
