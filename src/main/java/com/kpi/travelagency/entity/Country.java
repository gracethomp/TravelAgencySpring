package com.kpi.travelagency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private final UUID id_country;
    private final String name;

    public Country(UUID id_country, String name) {
        this.id_country = id_country;
        this.name = name;
    }

    public UUID getId_country() {
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
