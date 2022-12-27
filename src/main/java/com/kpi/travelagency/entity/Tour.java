package com.kpi.travelagency.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.kpi.travelagency.constants.TransportType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name="tours")
@IdClass(City.class)
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private Double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;
    private String description;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "id_city")
    @JoinColumns(@JoinColumn(name = "id_country"))
    private City id_city;
    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
    @OneToOne
    @JoinColumn(name = "id_hotel")
    private Hotel id_hotel;
    @Column(name = "transport_type")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    public Tour(Long id, String name, Double price, LocalDate startDate,
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

    public Long getId() {
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

    public Country getCountry() {
        return country;
    }

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

    public void setId(Long id) {
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
                ", country=" + country +
                ", id_hotel=" + id_hotel +
                ", transportType=" + transportType +
                '}';
    }
}
