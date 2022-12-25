package com.kpi.travelagency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id_city;
    private String name;

    public City(UUID id_city, String name) {
        this.id_city = id_city;
        this.name = name;
    }

    public UUID getId_city() {
        return id_city;
    }

    public String getName() {
        return name;
    }

    public void setId_city(UUID id_city) {
        this.id_city = id_city;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id_city=" + id_city +
                ", name='" + name + '\'' +
                '}';
    }
}
