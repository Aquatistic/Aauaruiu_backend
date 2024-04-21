package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserSensors {
    private @Id @GeneratedValue int userSensorId;

    @ManyToOne
    @JoinColumn(name = "aquariumId")
    private Aquarium aquarium;

    @ManyToOne
    @JoinColumn(name = "sensorTypeId")
    private SensorType sensorType;

    public UserSensors(Aquarium aquarium, SensorType sensorType) {
        this.aquarium = aquarium;
        this.sensorType = sensorType;
    }

    public int getUserSensorId() {
        return this.userSensorId;
    }

    public Aquarium getAquarium() {
        return this.aquarium;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public SensorType getSensorType() {
        return this.sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
}
