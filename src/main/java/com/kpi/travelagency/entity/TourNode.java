package com.kpi.travelagency.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Objects;


@Node("Tour")
public class TourNode {
    @Id
    private Integer id;
    private Integer count;
    private String name;

    public Integer getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TourNode{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourNode tourNode = (TourNode) o;
        return Objects.equals(id, tourNode.id) && Objects.equals(count, tourNode.count) && Objects.equals(name, tourNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count, name);
    }
}
