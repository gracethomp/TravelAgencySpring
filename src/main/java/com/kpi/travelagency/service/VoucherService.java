package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.repo.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    public List<Voucher> getVouchers(){
        return voucherRepository.findAll();
    }
    @Query()
    public List<Voucher> getVouchers(String property) {
        return voucherRepository.findAll(Sort.by(property));
    }
}
