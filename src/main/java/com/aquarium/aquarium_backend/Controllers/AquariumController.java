package com.aquarium.aquarium_backend.Controllers;

<<<<<<< HEAD
import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/aquariums")
public class AquariumController {
    private final AquariumService aquariumService;

    @Autowired
=======
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;

@RestController
@RequestMapping(path = "api/v1/aquarium")
public class AquariumController {
    private final AquariumService aquariumService;

>>>>>>> 73ea874 (add simple api for aquarium)
    public AquariumController(AquariumService aquariumService) {
        this.aquariumService = aquariumService;
    }

<<<<<<< HEAD
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Aquarium>> getAquariumByUserId(@PathVariable Long userId) {
        List<Aquarium> aquariumList = aquariumService.getAllUsersAquariums(userId);
        return new ResponseEntity<>(aquariumList, HttpStatus.OK);
=======
    @GetMapping
    public List<Aquarium> getAllAquariums() {
        return aquariumService.getAllAquariums();
>>>>>>> 73ea874 (add simple api for aquarium)
    }
}
