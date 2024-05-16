package com.aquarium.aquarium_backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.FishService;
import com.aquarium.aquarium_backend.databaseTables.Fish;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "api/v1/fish")
public class FishController {
    private final FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping
    public List<Fish> getAllFish() {
        return fishService.getAllFish();
    }

}
