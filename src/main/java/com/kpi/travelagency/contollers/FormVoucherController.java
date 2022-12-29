package com.kpi.travelagency.contollers;

import com.kpi.travelagency.constants.Status;
import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.entity.TourNode;
import com.kpi.travelagency.entity.UserNode;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.service.TourNodeService;
import com.kpi.travelagency.service.TourServiceImpl;
import com.kpi.travelagency.service.UserNodeService;
import com.kpi.travelagency.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormVoucherController {
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private UserNodeService userNodeService;
    @Autowired
    private TourNodeService tourNodeService;
    @Autowired
    private TourServiceImpl tourService;
    @GetMapping("/formVoucher/{id}")
    public String formVoucher(@PathVariable Integer id, Model model) {
        Tour tour = tourService.findById(Long.valueOf(id));
        model.addAttribute("tour", tour);
        model.addAttribute("totalPriceVoucher", tour.getPrice() + tour.getId_hotel().getPricePerNight());
        return "formVoucher";
    }
    @PostMapping("/formVoucher")
    public String addVoucher(@RequestParam Integer id, @RequestParam Double totalPrice, @RequestParam Integer user, Model model) {
        Voucher voucher = new Voucher();
        voucher.setTotalPrice(totalPrice);
        voucher.setStatus(Status.IN_PROGRESS);
        voucher.setId(-1);
        voucherService.save(voucher);
        voucher.setId(voucherService.setRightID());
        UserNode userNode = new UserNode();
        userNode.setId(user);
        userNodeService.save(userNode);
        voucherService.makeRelationshipUserVoucher(voucher, userNode);
        TourNode tourNode = new TourNode();
        tourNode.setId(id);
        tourNodeService.save(tourNode);
        voucherService.makeRelationshipTourVoucher(voucher, tourNode);
        return "home";
    }
}
