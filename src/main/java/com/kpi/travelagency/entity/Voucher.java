package com.kpi.travelagency.entity;

import com.kpi.travelagency.constants.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Voucher")
public class Voucher {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Property(name = "totalPrice")
    private Double totalPrice;
    private String tourName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
