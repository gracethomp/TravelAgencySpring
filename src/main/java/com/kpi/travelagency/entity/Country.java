package com.kpi.travelagency.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="countries")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Country(Long id_country, String name) {
        this.id = id_country;
        this.name = name;
    }

    public Country() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id_country=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
