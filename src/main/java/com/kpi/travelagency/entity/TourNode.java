package com.kpi.travelagency.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Node("Tour")
public class TourNode {
    @Id
    private Integer id;
}
