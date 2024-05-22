package com.aquarium.aquarium_backend.databaseTables;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
public class EffectorControll {
    private @Id @GeneratedValue Long effectorControllId;

    @ManyToOne
    @JoinColumn(name = "userEffectorId")
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
}
