package com.daixin.schedule.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkStation {
    @GeneratedValue
    private int id;
    private String name;
    private String shortHand;
    @ManyToMany(mappedBy = "workstation")
    private final List<Employee> employeeList = new ArrayList<>();

    // Constructor
    public WorkStation () {}

    public WorkStation(String name, String shortHand) {
        this.name = name;
        this.shortHand = shortHand;
    }

    // Hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkStation that = (WorkStation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortHand() {
        return shortHand;
    }

    public void setShortHand(String shortHand) {
        this.shortHand = shortHand;
    }
}
