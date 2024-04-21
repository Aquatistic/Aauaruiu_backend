package com.aquarium.aquarium_backend.databaseTables;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(userSensorId, aquarium, sensorType);
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject)
            return true;
        if (comparedObject == null || comparedObject.getClass() != UserSensors.class)
            return false;
        var comparedUserSensors = (UserSensors) comparedObject;
        return userSensorId == comparedUserSensors.userSensorId
                && Objects.equals(aquarium, comparedUserSensors.aquarium)
                && Objects.equals(sensorType, comparedUserSensors.sensorType);
    }

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
