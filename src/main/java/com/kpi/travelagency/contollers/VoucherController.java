package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VoucherController {
    @Autowired
    VoucherService voucherService;
    @GetMapping("/vouchers")
    public String vouchers(Model model) {
        List<Voucher> vouchers = voucherService.getVouchers();
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/priceAsc")
    public String orderVouchersByPriceAsc(Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedAsc("totalPrice");
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/priceDesc")
    public String orderVouchersByPriceDesc(Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedDesc("totalPrice");
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }

}
