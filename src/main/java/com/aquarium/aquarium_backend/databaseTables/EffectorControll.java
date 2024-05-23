package com.aquarium.aquarium_backend.databaseTables;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
public class EffectorControll {
    private @Id @GeneratedValue Long effectorControllId;

    @ManyToOne
    @JoinColumn(name = "userEffectorTypeId")
    private UserEffectors userEffector;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime controllActivationMoment;

    private float effectorValue;

    public EffectorControll() {
    }

    public EffectorControll(UserEffectors userEffector, LocalDateTime controllActivationMoment, float effectorValue) {
        this.userEffector = userEffector;
        this.controllActivationMoment = controllActivationMoment;
        this.effectorValue = effectorValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.effectorControllId, this.userEffector, this.controllActivationMoment,
                this.effectorValue);
    }

    public boolean equals(Object comparedObject) {
        if (this == comparedObject)
            return true;
        if (comparedObject == null || comparedObject.getClass() != EffectorControll.class)
            return false;
        var comparedEffectorControll = (EffectorControll) comparedObject;
        return effectorControllId == comparedEffectorControll.effectorControllId
                && Objects.equals(userEffector, comparedEffectorControll.userEffector)
                && Objects.equals(controllActivationMoment, comparedEffectorControll.controllActivationMoment)
                && effectorValue == comparedEffectorControll.effectorValue;
    }

    public Long getEffectorControllId() {
        return this.effectorControllId;
    }

    public UserEffectors getUserEffector() {
        return this.userEffector;
    }

    public LocalDateTime getControllActivationMoment() {
        return this.controllActivationMoment;
    }

    public float getEffectorValue() {
        return this.effectorValue;
    }

    public void setUserEffector(UserEffectors userEffector) {
        this.userEffector = userEffector;
    }

    public void setControllActivationMoment(LocalDateTime controllActivationMoment) {
        this.controllActivationMoment = controllActivationMoment;
    }

    public void setEffectorValue(float effectorValue) {
        this.effectorValue = effectorValue;
    }
}
