package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class EnvironmentalRequirements {
  private @Id @GeneratedValue int environmentalRequirementsId;

  @OneToMany
  @JoinColumn(name = "fishTypeId")
  private List<FishType> fishType;

  private String name;
  private String unit;
  private float value;

  public EnvironmentalRequirements() {}

  public EnvironmentalRequirements(List<FishType> fishType, String name, String unit, float value) {
    this.fishType = fishType;
    this.name = name;
    this.unit = unit;
    this.value = value;
  }

  public List<FishType> getFishType() {
    return fishType;
  }

  public void setFishType(List<FishType> fishType) {
    this.fishType = fishType;
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
    if (this == o) return true;
    if (!(o instanceof EnvironmentalRequirements that)) return false;
    return getEnvironmentalRequirementsId() == that.getEnvironmentalRequirementsId()
        && Float.compare(getValue(), that.getValue()) == 0
        && Objects.equals(getFishType(), that.getFishType())
        && Objects.equals(getName(), that.getName())
        && Objects.equals(getUnit(), that.getUnit());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getEnvironmentalRequirementsId(), getFishType(), getName(), getUnit(), getValue());
  }
}
