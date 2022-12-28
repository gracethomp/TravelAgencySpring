package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.UserNode;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.repo.UserNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNodeService{
    @Autowired
    private UserNodeRepository userNodeRepository;

    public UserNode save(UserNode userNode){
        return userNodeRepository.save(userNode);
    }
}
