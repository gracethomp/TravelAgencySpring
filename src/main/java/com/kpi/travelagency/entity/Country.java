package com.kpi.travelagency.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="countries")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    public Country(Integer id_country, String name) {
        this.id = id_country;
        this.name = name;
    }

    public Country() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id_country=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
