package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.repo.TourRepository;
import com.kpi.travelagency.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        List<User> users = new ArrayList<>(userRepository.findAll());
        return users;
    }

}
