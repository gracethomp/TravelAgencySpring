package com.kpi.travelagency.entity;

import com.kpi.travelagency.constants.HotelType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private final UUID id_hotel;
    private final String name;
    private final Double pricePerNight;
    private final HotelType type;
    private final City id_city;
    private final Country id_country;
    private final Integer rating;

    public Hotel(UUID id_hotel, String name, Double pricePerNight, HotelType type, City id_city, Country id_country, Integer rating) {
        this.id_hotel = id_hotel;
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.type = type;
        this.id_city = id_city;
        this.id_country = id_country;
        this.rating = rating;
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

    public City getId_city() {
        return id_city;
    }

    public Country getId_country() {
        return id_country;
    }

    public Integer getRating() {
        return rating;
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
