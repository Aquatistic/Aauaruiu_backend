package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.UserSensorService;
import com.aquarium.aquarium_backend.databaseTables.UserSensors;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/v1/userSensor")
public class UserSensorControllers {
    private final UserSensorService userSensorService;

    public UserSensorControllers(UserSensorService userSensorService) {
        this.userSensorService = userSensorService;
    }

    @GetMapping
    public ResponseEntity<List<UserSensors>> getAllUserSensors() {
        List<UserSensors> userSensors = userSensorService.getAllUsers();
        return new ResponseEntity<>(userSensors, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addUserSensor(Long aquariumId, int sensorTypeId) {
        if (!userSensorService.addUserSensor(aquariumId, sensorTypeId)) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}
