package com.aquarium.aquarium_backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.UserSensorService;
import com.aquarium.aquarium_backend.databaseTables.UserSensors;

@RestController
@RequestMapping(path = "api/v1/userSensor")
public class UserSensorControllers {
    private final UserSensorService userSensorService;

    public UserSensorControllers(UserSensorService userSensorService) {
        this.userSensorService = userSensorService;
    }

    @GetMapping
    public List<UserSensors> getAllUsers() {
        return userSensorService.getAllUsers();
    }
}
