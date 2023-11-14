package com.daixin.schedule.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    @GeneratedValue
    private int id;
    private String name;
    private int hours;

    @ManyToMany
    private final List<WorkStation> workStation = new ArrayList<>();

    //Constructors

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    //Hash mapping

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
