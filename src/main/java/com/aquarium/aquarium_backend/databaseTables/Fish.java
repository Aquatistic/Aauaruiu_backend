package com.aquarium.aquarium_backend.databaseTables;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Fish {
  private @Id @GeneratedValue Long fishId;

  @ManyToOne
  @JoinColumn(name = "fishTypeId")
  private FishType fishType;

  @ManyToOne
  @JoinColumn(name = "aquariumId")
  private Aquarium aquarium;

  private int count;

  public Fish(FishType fishType, Aquarium aquarium, int count) {
    this.fishType = fishType;
    this.aquarium = aquarium;
    this.count = count;
  }

  public Fish() {}

  public FishType getFishType() {
    return fishType;
  }

  public void setFishType(FishType fishType) {
    this.fishType = fishType;
  }

  public Aquarium getAquarium() {
    return aquarium;
  }

  public void setAquarium(Aquarium aquarium) {
    this.aquarium = aquarium;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Long getFishId() {
    return fishId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    var fish = (Fish) o;
    return getCount() == fish.getCount()
        && Objects.equals(fishId, fish.fishId)
        && Objects.equals(getFishType(), fish.getFishType())
        && Objects.equals(getAquarium(), fish.getAquarium());
  }

  @Override
  public int hashCode() {
    return Objects.hash(fishId, getFishType(), getAquarium(), getCount());
  }
}
