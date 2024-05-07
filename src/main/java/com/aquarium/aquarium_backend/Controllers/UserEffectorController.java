package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.UserEffectorService;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/userEffector")
public class UserEffectorController {
    private final UserEffectorService userEffectorService;

    public UserEffectorController(UserEffectorService userEffectorService) {
        this.userEffectorService = userEffectorService;
    }
    @GetMapping
    public ResponseEntity<List<UserEffectors>> getAllUsers() {
        List<UserEffectors> userEffectors = userEffectorService.getAllUsers();
        return new ResponseEntity<>(userEffectors, HttpStatus.OK);
    }
}
