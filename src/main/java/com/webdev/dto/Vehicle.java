package com.webdev.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @ManyToMany(mappedBy = "vehicles")
    private Collection<UserDetails> users = new ArrayList<UserDetails>();

    public Collection<UserDetails> getUsers() {
        return this.users;
    }

    public void setUsers(Collection<UserDetails> users) {
        this.users = users;
    }

    public int getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return this.vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

}
