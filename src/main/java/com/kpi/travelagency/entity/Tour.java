package com.kpi.travelagency.entity;


import com.kpi.travelagency.constants.TransportType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="tours")
public class Tour {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private final UUID id;
    private String name;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Integer duration;
    private City id_city;
    private Country id_country;
    private Hotel id_hotel;
    private TransportType transportType;

    public Tour(UUID id, String name, Double price, LocalDate startDate, LocalDate endDate, String description, Integer duration, City id_city, Country id_country, Hotel id_hotel, TransportType transportType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.duration = duration;
        this.id_city = id_city;
        this.id_country = id_country;
        this.id_hotel = id_hotel;
        this.transportType = transportType;
    }

    public UUID getId() {
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

    public City getId_city() {
        return id_city;
    }

    public Country getId_country() {
        return id_country;
    }

    public Hotel getId_hotel() {
        return id_hotel;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", id_city=" + id_city +
                ", id_country=" + id_country +
                ", id_hotel=" + id_hotel +
                ", transportType=" + transportType +
                '}';
    }
}