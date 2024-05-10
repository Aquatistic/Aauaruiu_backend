package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.UserEffectorService;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("aquariums/{aquariumId}")
    public ResponseEntity<List<UserEffectors>> getEffectorsByAquariumId(@PathVariable Long aquariumId) {
        List<UserEffectors> userEffectors = userEffectorService.getUserEffectorsByAquariumId(aquariumId);
        return new ResponseEntity<>(userEffectors, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserEffectors> addUserEffector(@RequestBody UserEffectors userEffector) {
        UserEffectors createdUserEffector = userEffectorService.postEffector(userEffector);
        return new ResponseEntity<>(createdUserEffector, HttpStatus.CREATED);
    }
}
