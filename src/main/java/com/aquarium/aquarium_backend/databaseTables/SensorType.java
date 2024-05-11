package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class SensorType {
  public SensorType() {}

  private @Id @GeneratedValue int sensorTypeId;
  private String sensorTypeName;
  private String outputUnit;

  public SensorType(String sensorTypeName, String outputUnit) {
    this.sensorTypeName = sensorTypeName;
    this.outputUnit = outputUnit;
  }

  @Override
  public boolean equals(Object comparedObject) {
    if (this == comparedObject) return true;
    if (comparedObject == null || comparedObject.getClass() != SensorType.class) return false;
    var comparedSensorType = (SensorType) comparedObject;
    return sensorTypeId == comparedSensorType.sensorTypeId
        && Objects.equals(sensorTypeName, comparedSensorType.sensorTypeName)
        && Objects.equals(outputUnit, comparedSensorType.outputUnit);
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

  public String getOutputUnit() {
    return this.outputUnit;
  }

  public void setOutputUnit(String outputUnit) {
    this.outputUnit = outputUnit;
  }
}
