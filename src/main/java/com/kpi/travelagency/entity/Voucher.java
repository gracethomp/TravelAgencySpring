package com.kpi.travelagency.entity;

import com.kpi.travelagency.constants.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("Voucher")
public class Voucher {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Property(name = "totalPrice")
    private Double totalPrice;
    @Property(name = "userEmail")
    private String userID;
    @Relationship("IS")
    private List<UserNode> userNodes = new ArrayList<>();
    @Relationship(direction = Relationship.Direction.OUTGOING)
    private List<TourNode> tourNodes;

    public void addUser(UserNode userNode) {
        userNodes.add(userNode);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", status=" + status +
                ", totalPrice='" + totalPrice + '\'' +
                ", userEmail='" + userID + '\'' +
                ", tourNodes=" + tourNodes +
                '}';
    }
}
