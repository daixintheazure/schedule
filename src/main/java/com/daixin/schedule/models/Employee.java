package com.daixin.schedule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters!")
    private String name;
    //@NotBlank(message = "Hours are required!")
    @NotNull
    private int hours;
    private boolean isActive;
    private boolean isTraining;





    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_station_id")
    private List<WorkStation> workStation = new ArrayList<>();

    //Constructors

    public Employee() {}

    public Employee(String name, int hours, boolean isActive, boolean isTraining) {
        this.name = name;
        this.hours = hours;
        this.isActive = isActive;
        this.isTraining = isTraining;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isTraining() {
        return isTraining;
    }

    public void setTraining(boolean training) {
        isTraining = training;
    }

    public List<WorkStation> getWorkStation() {
        return workStation;
    }

    public void setWorkStation(List<WorkStation> workStation) {
        this.workStation = workStation;
    }


}
