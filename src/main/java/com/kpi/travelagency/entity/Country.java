package com.kpi.travelagency.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_country;
    @Column(name = "name", nullable = false)
    private String name;

    public Country(Integer id_country, String name) {
        this.id_country = id_country;
        this.name = name;
    }

    public Country() {

    }

    public Integer getId_country() {
        return id_country;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id_country=" + id_country +
                ", name='" + name + '\'' +
                '}';
    }
}
