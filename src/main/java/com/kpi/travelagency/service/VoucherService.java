package com.kpi.travelagency.service;

import com.kpi.travelagency.constants.Status;
import com.kpi.travelagency.entity.TourNode;
import com.kpi.travelagency.entity.UserNode;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.repo.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
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
    public void makeRelationshipTourVoucher(Voucher voucher, TourNode tourNode) {
        voucherRepository.connectVoucherTour(voucher, tourNode);
    }
    public List<Voucher> getVouchersByUserID(UserNode userNode) {
        return voucherRepository.vouchersByUserID(userNode);
    }
    public List<Voucher> getVouchersByTourID(TourNode tourNode){
        return  voucherRepository.vouchersByTourID(tourNode);
    }
    public Integer getTourByVaucher(Voucher voucher) {
        return voucherRepository.getTourIdByVoucher(voucher).get(0);
    }
    public Voucher getVoucherByID(Integer id){
        return voucherRepository.findById(id).get();
    }
    public void setStatus(Voucher voucher, Status status) {
        voucherRepository.setStatus(status.name(), voucher);
    }
    public Integer getVoucherCountByTour(Integer id) {
        return voucherRepository.getVoucherCountByTour(id);
    }
    public List<TourNode> getToursByVoucher(Voucher voucher){
        return voucherRepository.getTourNodes(voucher);
    }
}
