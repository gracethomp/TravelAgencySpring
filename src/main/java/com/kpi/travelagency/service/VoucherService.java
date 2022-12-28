package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.UserNode;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.repo.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    public List<Voucher> getVouchers(){
        return voucherRepository.findAll(Sort.by("id").ascending());
    }
    public List<Voucher> getVouchersSortedDesc(String property) {
        return voucherRepository.findAll(Sort.by(property).descending());
    }
    public List<Voucher> getVouchersSortedAsc(String property) {
        return voucherRepository.findAll(Sort.by(property).ascending());
    }
    public Voucher save(Voucher voucher){
        return voucherRepository.save(voucher);
    }
    public Integer setRightID(){
        return voucherRepository.setId();
    }
    public void makeRelationshipUserVoucher(Voucher voucher, UserNode userNode) {
        voucherRepository.makeOrder(voucher, userNode);
    }
}
