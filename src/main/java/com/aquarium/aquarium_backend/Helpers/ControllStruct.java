package com.aquarium.aquarium_backend.Helpers;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ControllStruct {
  private Long AquariumId;
  private Long EffectorId;
  private float value;
  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime controllActivationMoment;
}
