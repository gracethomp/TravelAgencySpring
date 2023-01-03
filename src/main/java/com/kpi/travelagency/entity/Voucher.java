package com.kpi.travelagency.entity;

import com.kpi.travelagency.constants.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Objects;

@Node("Voucher")
public class Voucher implements Comparable<Voucher>{
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Property(name = "totalPrice")
    private Double totalPrice;
    private String tourName;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int compareTo(Voucher o)
    {
        double diff = this.totalPrice - o.getTotalPrice();
        if(diff < 1 && diff > 0)
            return 1;
        else if(diff < 0 && diff > -1){
            return -1;
        }
        return (int) (this.totalPrice - o.getTotalPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return Objects.equals(id, voucher.id) && status == voucher.status && Objects.equals(totalPrice, voucher.totalPrice) && Objects.equals(tourName, voucher.tourName) && Objects.equals(email, voucher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, totalPrice, tourName, email);
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
