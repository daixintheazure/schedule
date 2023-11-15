package com.daixin.schedule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class WorkStation {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @NotNull
    @NotBlank(message = "ShortHand is required!")
    @Size(min = 1, max = 3, message = "ShortHand must be between 1 and 3 characters!")
    private String shortHand;
    @OneToMany(mappedBy = "workStation")
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
