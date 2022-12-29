package com.kpi.travelagency.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kpi.travelagency.constants.TransportType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="filter_data")
public class FilterTourData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String country;
    private String city;
    private Double minPrice;
    private Double maxPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    private String transportType;
    private Integer hotelRating;

    public FilterTourData() {
        country = null;
        city = null;
        minPrice = null;
        maxPrice = null;
        startDate = null;
        endDate = null;
        transportType = null;
        hotelRating = null;
    }

    public FilterTourData(Long id, String country, String city, Double minPrice, Double maxPrice, LocalDate startDate, LocalDate endDate, String transportType, Integer hotelRating) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transportType = transportType;
        this.hotelRating = hotelRating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(Integer hotelRating) {
        this.hotelRating = hotelRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
