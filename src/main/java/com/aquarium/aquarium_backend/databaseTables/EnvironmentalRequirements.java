package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class EnvironmentalRequirements {
  private @Id @GeneratedValue int environmentalRequirementsId;

  private String name;
  private String unit;
  private float value;
  private List<String> fishNames;

  public EnvironmentalRequirements() {
  }

  public EnvironmentalRequirements(String name, String unit, float value, List<String> fishNames) {
    this.name = name;
    this.unit = unit;
    this.value = value;
    this.fishNames = fishNames;
  }

  public List<String> getFishNames() {
    return fishNames;
  }

  public void setFishNames(List<String> fishNames) {
    this.fishNames = fishNames;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }

  public int getEnvironmentalRequirementsId() {
    return environmentalRequirementsId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    EnvironmentalRequirements that = (EnvironmentalRequirements) o;
    return getEnvironmentalRequirementsId() == that.getEnvironmentalRequirementsId()
        && Float.compare(getValue(), that.getValue()) == 0
        // && Objects.equals(getFishType(), that.getFishType())
        && Objects.equals(getName(), that.getName())
        && Objects.equals(getUnit(), that.getUnit());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getEnvironmentalRequirementsId(), getName(), getUnit(), getValue());
  }
}
