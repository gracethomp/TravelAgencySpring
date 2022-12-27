package com.kpi.travelagency.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Tour")
public class TourNode {
    @Id
    private Integer id;
    @Property(name = "tourID")
    private String tourID;
}
