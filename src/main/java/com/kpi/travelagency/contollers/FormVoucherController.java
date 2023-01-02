package com.kpi.travelagency.contollers;

import com.kpi.travelagency.constants.Status;
import com.kpi.travelagency.entity.*;
import com.kpi.travelagency.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/formVoucher/{id}")
    public String formVoucher(@PathVariable Integer id, Model model) {
        Tour tour = tourService.findById(Long.valueOf(id));
        model.addAttribute("tour", tour);
        model.addAttribute("totalPriceVoucher", tour.getPrice() + tour.getId_hotel().getPricePerNight());
        model.addAttribute("isCreating", true);
        return "formVoucher";
    }
    @PostMapping("/formVoucher")
    public String addVoucher(@RequestParam Integer id, @RequestParam Double totalPrice, @RequestParam String email, Model model) {
        Voucher voucher = new Voucher();
        voucher.setTotalPrice(totalPrice);
        voucher.setStatus(Status.IN_PROGRESS);
        voucher.setId(-1);
        voucherService.save(voucher);

        try {
            User user1 = userService.logIn(email);
            voucher.setId(voucherService.setRightID());
            UserNode userNode = new UserNode();
            userNode.setId(user1.getId());
            userNodeService.save(userNode);

            voucherService.makeRelationshipUserVoucher(voucher, userNode);

            TourNode tourNode = new TourNode();
            tourNode.setId(id);
            tourNodeService.save(tourNode);
            voucherService.makeRelationshipTourVoucher(voucher, tourNode);
            return "home";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add",true);
            return "logIn";
        }

    }
}
