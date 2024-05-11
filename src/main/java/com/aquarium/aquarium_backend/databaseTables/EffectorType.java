package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class EffectorType {
  public EffectorType() {}

  private @Id @GeneratedValue int effectorTypeId;
  private String effectorTypeName;
  private String outputUnit;

  public EffectorType(String effectorTypeName, String outputUnit) {
    this.effectorTypeName = effectorTypeName;
    this.outputUnit = outputUnit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(effectorTypeId, effectorTypeName, outputUnit);
  }

  @Override
  public boolean equals(Object comparedObject) {
    if (this == comparedObject) return true;
    if (comparedObject == null || comparedObject.getClass() != EffectorType.class) return false;
    var comparedEffectorType = (EffectorType) comparedObject;
    return effectorTypeId == comparedEffectorType.effectorTypeId
        && Objects.equals(effectorTypeName, comparedEffectorType.effectorTypeName)
        && Objects.equals(outputUnit, comparedEffectorType.outputUnit);
  }

  public int getEffectorTypeId() {
    return this.effectorTypeId;
  }

  public String getEffectorTypeName() {
    return this.effectorTypeName;
  }

  public void setEffectorTypeName(String effectorTypeName) {
    this.effectorTypeName = effectorTypeName;
  }

  public String getOutputUnit() {
    return this.outputUnit;
  }

  public void setOutputUnit(String outputUnit) {
    this.outputUnit = outputUnit;
  }
}
