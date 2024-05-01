package com.aquarium.aquarium_backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.UserEffectorService;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;

@RestController
@RequestMapping(path = "api/v1/userEffector")
public class UserEffectorController {
    private final UserEffectorService userEffectorService;

    public UserEffectorController(UserEffectorService userEffectorService) {
        this.userEffectorService = userEffectorService;
    }

    @GetMapping
    public List<UserEffectors> getAllUsers() {
        return userEffectorService.getAllUsers();
    }
}
