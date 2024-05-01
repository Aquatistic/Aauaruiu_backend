package com.aquarium.aquarium_backend.Controllers;

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

    public AquariumController(AquariumService aquariumService) {
        this.aquariumService = aquariumService;
    }

    @GetMapping
    public List<Aquarium> getAllAquariums() {
        return aquariumService.getAllAquariums();
    }
}
