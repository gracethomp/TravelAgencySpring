package com.kpi.travelagency.entity;

import com.kpi.travelagency.constants.HotelType;
import jakarta.persistence.*;

@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double pricePerNight;
    private HotelType type;
    @OneToOne
    @JoinColumn(name = "id_city",nullable = false)
    private City id_city;
    @OneToOne
    @JoinColumn(name = "id_country",nullable = false)
    private Country id_country;
    private Integer rating;

    public Hotel(Integer id_hotel, String name, Double pricePerNight, HotelType type,
                 City id_city, Country id_country, Integer rating) {
        this.id = id_hotel;
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.type = type;
        this.id_city = id_city;
        this.id_country = id_country;
        this.rating = rating;
    }

    public Hotel() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public HotelType getType() {
        return type;
    }

    public City getId_city() {
        return id_city;
    }

    public Country getId_country() {
        return id_country;
    }

    public Integer getRating() {
        return rating;
    }

    public void setId_country(Country id_country) {
        this.id_country = id_country;
    }

    public void setId_city(City id_city) {
        this.id_city = id_city;
    }

    public void setId(Integer id_hotel) {
        this.id = id_hotel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setType(HotelType type) {
        this.type = type;
    }
}
