package com.aquarium.aquarium_backend.databaseTables;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SensorType {
    private @Id @GeneratedValue int sensorTypeId;
    private String sensorTypeName;

    public SensorType(String sensorTypeName) {
        this.sensorTypeName = sensorTypeName;
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject)
            return true;
        if (comparedObject == null || comparedObject.getClass() != SensorType.class)
            return false;
        var comparedSensorType = (SensorType) comparedObject;
        return sensorTypeId == comparedSensorType.sensorTypeId
                && Objects.equals(sensorTypeName, comparedSensorType.sensorTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorTypeId, sensorTypeName);
    }

    public int getSensorTypeId() {
        return this.sensorTypeId;
    }

    public String getSensorTypeName() {
        return this.sensorTypeName;
    }

    public void setSensorTypeName(String sensorTypeName) {
        this.sensorTypeName = sensorTypeName;
    }
}
