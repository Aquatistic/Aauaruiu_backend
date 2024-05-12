package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class UserSensors {
  public UserSensors() {}

  private @Id @GeneratedValue Long userSensorId;

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
    if (this == comparedObject) return true;
    if (comparedObject == null || comparedObject.getClass() != UserSensors.class) return false;
    var comparedUserSensors = (UserSensors) comparedObject;
    return userSensorId == comparedUserSensors.userSensorId
        && Objects.equals(aquarium, comparedUserSensors.aquarium)
        && Objects.equals(sensorType, comparedUserSensors.sensorType);
  }

  public UserSensors(Aquarium aquarium, SensorType sensorType) {
    this.aquarium = aquarium;
    this.sensorType = sensorType;
  }

  public Long getUserSensorId() {
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
