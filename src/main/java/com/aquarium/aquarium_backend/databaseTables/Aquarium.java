package com.aquarium.aquarium_backend.databaseTables;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Aquarium {
    public Aquarium() {
    }
    private @Id @GeneratedValue int aquariumId;
    private String aquariumName;
    private float aquariumCapacity;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Aquarium(String aquariumName, float aquariumCapacity, User user) {
        this.aquariumName = aquariumName;
        this.aquariumCapacity = aquariumCapacity;
        this.user = user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aquariumId, aquariumName, aquariumCapacity, user);
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject)
            return true;
        if (comparedObject == null || comparedObject.getClass() != Aquarium.class)
            return false;
        var comparedAquarium = (Aquarium) comparedObject;
        return aquariumId == comparedAquarium.aquariumId
                && Objects.equals(aquariumName, comparedAquarium.aquariumName)
                && aquariumCapacity == comparedAquarium.aquariumCapacity
                && Objects.equals(user, comparedAquarium.user);
    }

    public int getAquariumId() {
        return this.aquariumId;
    }

    public String getAquariumName() {
        return this.aquariumName;
    }

    public void setAquariumName(String aquariumName) {
        this.aquariumName = aquariumName;
    }

    public float getAquariumCapacity() {
        return this.aquariumCapacity;
    }

    public void setAquariumCapacity(float aquariumCapacity) {
        this.aquariumCapacity = aquariumCapacity;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
