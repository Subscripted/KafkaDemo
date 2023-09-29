package com.example.kafkademo.messaging.model;


import com.example.kafkademo.repository.entity.VehicleType;

import java.time.LocalDateTime;

public class MeasurementEvent {
    private Long stationId;

    private VehicleType vehicleType;

    private LocalDateTime timestamp;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}


