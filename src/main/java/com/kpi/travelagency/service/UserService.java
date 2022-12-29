package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Tour;
import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.repo.TourRepository;
import com.kpi.travelagency.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private boolean existsById(String id){
        return userRepository.existsById(id);
    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>(userRepository.findAll());
        return users;
    }

    public User saveUser(User user) throws Exception{
        if (user.getId() != null && existsById(user.getId())) {
            throw new Exception("Tour with id: " + user.getId() + " already exists");
        }
        return userRepository.save(user);
    }

    public void updateProfile(User user) throws Exception {
        if (!existsById(user.getId())) {
            throw new Exception("Cannot find tour with id: " + user.getId());
        }
        userRepository.save(user);
    }

    public void deleteUserById(String id) throws Exception{
        if (!existsById(id)) {
            throw new Exception("Cannot find tour with id: " + id);
        }
        else {

           userRepository.deleteById(String.valueOf(id));
        }
    }
}
