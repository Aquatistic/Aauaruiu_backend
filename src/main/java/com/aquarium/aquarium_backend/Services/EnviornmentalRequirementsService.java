package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.EnvironmentalRequirementsRepository;
import com.aquarium.aquarium_backend.databaseTables.EnvironmentalRequirements;

@Service
public class EnviornmentalRequirementsService {
    private final EnvironmentalRequirementsRepository environmentalRequirementsRepository;

    public EnviornmentalRequirementsService(EnvironmentalRequirementsRepository environmentalRequirementsRepository) {
        this.environmentalRequirementsRepository = environmentalRequirementsRepository;
    }

    public List<EnvironmentalRequirements> getAllRequirements() {
        return environmentalRequirementsRepository.findAll();
    }
}
