package com.aquarium.aquarium_backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.FishService;
import com.aquarium.aquarium_backend.databaseTables.Fish;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(path = "api/v1/fish")
public class FishController {
    private final FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping
    public ResponseEntity<List<Fish>> getAllFish() {
        return new ResponseEntity<>(fishService.getAllFish(), HttpStatus.OK);
    }

    @GetMapping("aquarium/{aquariumId}")
    public ResponseEntity<List<Fish>> getFishInAquarium(@PathVariable Long aquariumId) {
        try {
            return new ResponseEntity<>(fishService.getFishInAquarium(aquariumId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addFish(Long aquariumId, int fishTypeId, int count) {
        try {
            fishService.addFish(aquariumId, fishTypeId, count);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
