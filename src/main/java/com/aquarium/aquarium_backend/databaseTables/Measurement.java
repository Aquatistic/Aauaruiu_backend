package com.aquarium.aquarium_backend.databaseTables;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Measurement {
    public Measurement() {
    }
    private @Id @GeneratedValue int measurementId;
    @ManyToOne
    @JoinColumn(name = "userSensorId")
    private UserSensors userSensor;

    private boolean alarmStatus;
    private float measurementValue;
    private Date measurementTimestamp;

    public Measurement(UserSensors userSensor, boolean alarmStatus, float measurementValue, Date measurementTimestamp) {
        this.userSensor = userSensor;
        this.alarmStatus = alarmStatus;
        this.measurementValue = measurementValue;
        this.measurementTimestamp = measurementTimestamp;
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject)
            return true;
        if (comparedObject == null || comparedObject.getClass() != Measurement.class)
            return false;
        var comparedMeasurement = (Measurement) comparedObject;
        return measurementId == comparedMeasurement.measurementId
                && Objects.equals(userSensor, comparedMeasurement.userSensor)
                && alarmStatus == comparedMeasurement.alarmStatus
                && measurementValue == comparedMeasurement.measurementValue
                && Objects.equals(measurementTimestamp, comparedMeasurement.measurementTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementId, userSensor, alarmStatus, measurementValue, measurementTimestamp);
    }

    public int getMeasurementId() {
        return this.measurementId;
    }

    public UserSensors getUserSensor() {
        return this.userSensor;
    }

    public void setUserSensor(UserSensors userSensor) {
        this.userSensor = userSensor;
    }

    public boolean getAlarmStatus() {
        return this.alarmStatus;
    }

    public void setAlarmStatus(boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public float getMeasurementValue() {
        return this.measurementValue;
    }

    public void setMeasurementValue(float measurementValue) {
        this.measurementValue = measurementValue;
    }

    public Date getMeasurementTimestamp() {
        return this.measurementTimestamp;
    }

    public void setMeasurementTimestamp(Date measurementTimestamp) {
        this.measurementTimestamp = measurementTimestamp;
    }

}
