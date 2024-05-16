package com.aquarium.aquarium_backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.EnviornmentalRequirementsService;
import com.aquarium.aquarium_backend.databaseTables.EnvironmentalRequirements;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "api/v1/evniornmentalRequirements")
public class EnviornmentalRequirementsController {
    private final EnviornmentalRequirementsService enviornmentalRequirementsService;

    public EnviornmentalRequirementsController(EnviornmentalRequirementsService enviornmentalRequirementsService) {
        this.enviornmentalRequirementsService = enviornmentalRequirementsService;
    }

    @GetMapping
    public List<EnvironmentalRequirements> getAllRequirements() {
        return enviornmentalRequirementsService.getAllRequirements();
    }
}
