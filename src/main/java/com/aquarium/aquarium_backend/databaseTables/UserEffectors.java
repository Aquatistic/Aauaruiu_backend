package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class UserEffectors {
  public UserEffectors() {}

  private @Id @GeneratedValue Long userEffectorTypeId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "effectorTypeId")
  private EffectorType effectorType;

  @ManyToOne
  @JoinColumn(name = "aquariumId")
  private Aquarium aquarium;

  private float effectorValue;
  private String effectorControlType;

  public UserEffectors(
      EffectorType effectorType,
      Aquarium aquarium,
      float effectorValue,
      String effectorControlType) {
    this.effectorType = effectorType;
    this.aquarium = aquarium;
    this.effectorValue = effectorValue;
    this.effectorControlType = effectorControlType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        userEffectorTypeId, effectorType, aquarium, effectorValue, effectorControlType);
  }

  @Override
  public boolean equals(Object comparedObject) {
    if (this == comparedObject) return true;
    if (comparedObject == null || comparedObject.getClass() != UserEffectors.class) return false;
    var comparedUserEffectors = (UserEffectors) comparedObject;
    return userEffectorTypeId == comparedUserEffectors.userEffectorTypeId
        && effectorType.equals(comparedUserEffectors.effectorType)
        && aquarium.equals(comparedUserEffectors.aquarium)
        && effectorValue == comparedUserEffectors.effectorValue
        && effectorControlType.equals(comparedUserEffectors.effectorControlType);
  }

  public Long getUserEffectorTypeId() {
    return this.userEffectorTypeId;
  }

  public EffectorType getEffectorType() {
    return this.effectorType;
  }

  public void setEffectorType(EffectorType effectorType) {
    this.effectorType = effectorType;
  }

  public Aquarium getAquarium() {
    return this.aquarium;
  }

  public void setAquarium(Aquarium aquarium) {
    this.aquarium = aquarium;
  }

  public float getEffectorValue() {
    return this.effectorValue;
  }

  public void setEffectorValue(float effectorValue) {
    this.effectorValue = effectorValue;
  }

  public String getEffectorControlType() {
    return this.effectorControlType;
  }

  public void setEffectorControlType(String effectorControlType) {
    this.effectorControlType = effectorControlType;
  }
}
