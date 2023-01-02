package com.kpi.travelagency.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private String email;

    public Manager(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Manager(){

    }

    
}
