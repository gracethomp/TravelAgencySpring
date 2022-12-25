package com.kpi.travelagency.entity;

import com.kpi.travelagency.constants.HotelType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id_hotel;
    private String name;
    private Double pricePerNight;
    private HotelType type;
    private City id_city;
    private Country id_country;
    private Integer rating;

    public Hotel(UUID id_hotel, String name, Double pricePerNight, HotelType type, City id_city, Country id_country, Integer rating) {
        this.id_hotel = id_hotel;
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.type = type;
        this.id_city = id_city;
        this.id_country = id_country;
        this.rating = rating;
    }

    public Hotel() {

    }

    public UUID getId_hotel() {
        return id_hotel;
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

    @OneToOne
    @JoinColumn(name = "id_city",nullable = false)
    public City getId_city() {
        return id_city;
    }

    @OneToOne
    @JoinColumn(name = "id_country",nullable = false)
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

    @Override
    public String toString() {
        return "Hotel{" +
                "id_hotel=" + id_hotel +
                ", name='" + name + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", type=" + type +
                ", id_city=" + id_city +
                ", id_country=" + id_country +
                ", rating=" + rating +
                '}';
    }
}
