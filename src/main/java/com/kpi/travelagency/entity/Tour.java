package com.kpi.travelagency.entity;


import com.kpi.travelagency.constants.TransportType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Integer duration;
    private City id_city;
    private Country country;
    private Hotel id_hotel;
    private TransportType transportType;

    public Tour(Integer id, String name, Double price, LocalDate startDate,
                LocalDate endDate, String description, Integer duration, City id_city,
                Country id_country, Hotel id_hotel, TransportType transportType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.duration = duration;
        this.id_city = id_city;
        this.country = id_country;
        this.id_hotel = id_hotel;
        this.transportType = transportType;
    }

    public Tour() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }
    @Id
    @OneToOne
    @JoinColumn(name = "id_city",nullable = false)
    public City getId_city() {
        return id_city;
    }
    @Id
    @OneToOne
    @JoinColumn(name = "id_country",nullable = false)
    public Country getCountry() {
        return country;
    }
    @OneToOne
    @JoinColumn(name = "id_hotel",nullable = false)
    @JoinColumns({@JoinColumn(name = "id_country",nullable = false),
            @JoinColumn(name = "id_city",nullable = false)
    } )
    public Hotel getId_hotel() {
        return id_hotel;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setId_city(City id_city) {
        this.id_city = id_city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country id_country) {
        this.country = id_country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_hotel(Hotel id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }
}
