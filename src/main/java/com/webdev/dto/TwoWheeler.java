package com.webdev.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

    private String steeringHandle;

    public String getSteeringHandle() {
        return this.steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }

}
