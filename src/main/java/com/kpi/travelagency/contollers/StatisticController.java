package com.kpi.travelagency.contollers;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.entity.TourNode;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.service.TourServiceImpl;
import com.kpi.travelagency.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class StatisticController {
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private TourServiceImpl tourService;
    @GetMapping("/statistics")
    public String greeting(Model model) {
        List<TourNode> tourNodes = new ArrayList<>();
        List<Voucher> vouchers = voucherService.getVouchers();
        System.out.println(vouchers);
        for(Voucher v: vouchers) {
            TourNode tourNode = new TourNode();
            Integer tourID = voucherService.getTourByVaucher(v);
            tourNode.setId(tourID);
            tourNode.setName(tourService.findById(Long.valueOf(tourID)).getName());
            tourNode.setCount(voucherService.getVoucherCountByTour(tourID));
            if(!tourNodes.contains(tourNode))
                tourNodes.add(tourNode);
            //v.setTourName(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(v))).getName());
        }
        tourNodes.sort(Comparator.comparing(TourNode::getCount).reversed());
        model.addAttribute("tours", tourNodes.stream().limit(5).collect(Collectors.toList()));
        tourNodes.sort(Comparator.comparing(TourNode::getCount));
        model.addAttribute("tours1", tourNodes.stream().limit(5).collect(Collectors.toList()));
        return "statistic";
    }
}
