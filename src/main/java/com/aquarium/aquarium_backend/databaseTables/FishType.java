package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class FishType {
  public FishType() {}

  private @Id @GeneratedValue int fishTypeId;
  private String name;

  public FishType(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof FishType fishType)) return false;
    return getFishTypeId() == fishType.getFishTypeId()
        && Objects.equals(getName(), fishType.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFishTypeId(), getName());
  }

  public int getFishTypeId() {
    return fishTypeId;
  }

  public void setFishTypeId(int fishTypeId) {
    this.fishTypeId = fishTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
