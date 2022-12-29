package com.kpi.travelagency.contollers;

import com.kpi.travelagency.constants.Status;
import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.entity.TourNode;
import com.kpi.travelagency.entity.UserNode;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.service.TourServiceImpl;
import com.kpi.travelagency.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VoucherController {
    @Autowired
    TourServiceImpl tourService;
    @Autowired
    VoucherService voucherService;
    @GetMapping("/vouchers")
    public String vouchers(Model model) {
        List<Voucher> vouchers = voucherService.getVouchers();
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/priceAsc")
    public String orderVouchersByPriceAsc(Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedAsc("totalPrice");
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/priceDesc")
    public String orderVouchersByPriceDesc(Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedDesc("totalPrice");
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/{id}")
    public String showByUser(@PathVariable Integer id, Model model){
        UserNode userNode = new UserNode();
        userNode.setId(id);
        List<Voucher> vouchers = voucherService.getVouchers();
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("vouchers/tours/{id}")
    public String showByTour(@PathVariable Integer id, Model model) {
        TourNode tourNode = new TourNode();
        tourNode.setId(id);
        List<Voucher> vouchers = voucherService.getVouchersByTourID(tourNode);
        vouchers.forEach(e->e.setTourName(tourService.findById(Long.valueOf(id)).getName()));
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/status/{id}")
    public String showSingleVoucher(@PathVariable Integer id, Model model){
        Voucher voucher = voucherService.getVoucherByID(id);
        Integer tourID = voucherService.getTourByVaucher(voucher);
        Tour tour = tourService.findById(Long.valueOf(tourID));
        model.addAttribute("tour", tour);
        model.addAttribute("totalPriceVoucher", tour.getPrice() + tour.getId_hotel().getPricePerNight());
        model.addAttribute("uniqueOrderID", id);
        if(voucher.getStatus().equals(Status.ACCEPTED) || voucher.getStatus().equals(Status.CANCELLED))
            return "data";
        return "dataVoucher";
    }
    @PostMapping("/vouchers/status/{id}/accept")
    public String acceptSingleVoucher(@PathVariable Integer id, Model model){
        voucherService.setStatus(voucherService.getVoucherByID(id), Status.ACCEPTED);
        return "home";
    }
    @PostMapping("/vouchers/status/{id}/cancel")
    public String cancelSingleVoucher(@PathVariable Integer id, Model model){
        voucherService.setStatus(voucherService.getVoucherByID(id), Status.CANCELLED);
        return "home";
    }
}
