package com.kpi.travelagency.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void getCurrentUserInfo();
    void getUserByID(Long id);
    void getUserByEmail(String email);
    void registerUser(String user);
}
