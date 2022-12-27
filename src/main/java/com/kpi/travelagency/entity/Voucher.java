package com.kpi.travelagency.entity;

import com.kpi.travelagency.constants.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Voucher")
public class Voucher {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Property(name = "totalPrice")
    private String totalPrice;
    @Property(name = "userEmail")
    private String userEmail;
    @Relationship(direction = Relationship.Direction.OUTGOING)
    private List<TourNode> tourNodes;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", status=" + status +
                ", totalPrice='" + totalPrice + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", tourNodes=" + tourNodes +
                '}';
    }
}
