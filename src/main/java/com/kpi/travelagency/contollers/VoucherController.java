package com.kpi.travelagency.contollers;

import com.kpi.travelagency.constants.Status;
import com.kpi.travelagency.entity.*;
import com.kpi.travelagency.service.TourServiceImpl;
import com.kpi.travelagency.service.UserService;
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
    private TourServiceImpl tourService;
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private UserService userService;
    @GetMapping("/vouchers")
    public String vouchers(Model model) {
        List<Voucher> vouchers = voucherService.getVouchers();
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("isManager", true);
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/priceAsc")
    public String orderVouchersByPriceAsc(Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedAsc("totalPrice");
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("isManager", true);
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/priceDesc")
    public String orderVouchersByPriceDesc(Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedDesc("totalPrice");
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("isManager", true);
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/{id}")
    public String showByUser(@PathVariable String id, Model model){
        UserNode userNode = new UserNode();
        userNode.setId(id);
        List<Voucher> vouchers = voucherService.getVouchersByUserID(userNode);
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
        User user = userService.findUserByID(voucherService.getIdUser(voucher));
        model.addAttribute("user", user);
        model.addAttribute("tour", tour);
        model.addAttribute("totalPriceVoucher", tour.getPrice()
                + tour.getId_hotel().getPricePerNight());
        model.addAttribute("uniqueOrderID", id);
        model.addAttribute("add", true);
        if(voucher.getStatus().equals(Status.ACCEPTED) || voucher.getStatus().equals(Status.CANCELLED))
            model.addAttribute("add", false);
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
    @GetMapping("/vouchers/{id}/data")
    public String showDataToUser(@PathVariable Integer id, Model model){
        Voucher voucher = voucherService.getVoucherByID(id);
        Integer tourID = voucherService.getTourByVaucher(voucher);
        Tour tour = tourService.findById(Long.valueOf(tourID));
        User user = userService.findUserByID(voucherService.getIdUser(voucher));
        model.addAttribute("isUser", true);
        model.addAttribute("user", user);
        model.addAttribute("tour", tour);
        model.addAttribute("totalPriceVoucher", tour.getPrice()
                + tour.getId_hotel().getPricePerNight());
        model.addAttribute("uniqueOrderID", id);
        model.addAttribute("add", false);
        return "dataVoucher";
    }
    @GetMapping("/vouchers/priceAsc/{id}")
    public String orderVouchersByPriceAsc(@PathVariable String id, Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedAsc("totalPrice");
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("idCur", id);
        model.addAttribute("isManager", false);
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
    @GetMapping("/vouchers/priceDesc/{id}")
    public String orderVouchersByPriceDesc(@PathVariable String id, Model model) {
        List<Voucher> vouchers = voucherService.getVouchersSortedDesc("totalPrice");
        for(Voucher v: vouchers) {
            v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        model.addAttribute("idCur", id);
        model.addAttribute("isManager", false);
        model.addAttribute("vouchers", vouchers);
        return "vouchers";
    }
}
