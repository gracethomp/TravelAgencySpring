package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Manager;
import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.repo.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    private boolean existsById(String id){
        return managerRepository.existsById(id);
    }

    public List<Manager> findAll(){
        List<Manager> managers = new ArrayList<>(managerRepository.findAll());
        return managers;
    }

    public Manager findManagerByID(String id) { return managerRepository.findById(id).get(); }
    public Boolean findByEmail(String email){
        return managerRepository.findByEmail(email);
    }

    public Manager findManagerByEmail(String email){
        return managerRepository.findManagerByEmail(email);
    }

    public Manager logInManager(String email) throws Exception{
        if(!findByEmail(email)) {
            throw new Exception("Cannot find user with email: " + email + ". Try again!");
        }
        else {
            return managerRepository.findManagerByEmail(email);
        }
    }

}
