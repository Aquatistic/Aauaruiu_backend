package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.UserSensorService;
import com.aquarium.aquarium_backend.databaseTables.UserSensors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
