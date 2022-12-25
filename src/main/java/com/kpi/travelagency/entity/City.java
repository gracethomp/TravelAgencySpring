package com.kpi.travelagency.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_city;
    private String name;
    private Country country;

    public City(Integer id_city, String name, Country country) {
        this.id_city = id_city;
        this.name = name;
        this.country = country;
    }

    public City() {

    }

    public Integer getId_city() {
        return id_city;
    }

    public String getName() {
        return name;
    }
    @Id
    @OneToOne
    @JoinColumn(name = "id_country",nullable = false)
    public Country getCountry() {
        return country;
    }

    public void setId_city(Integer id_city) {
        this.id_city = id_city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id_city=" + id_city +
                ", name='" + name + '\'' +
                '}';
    }
}
