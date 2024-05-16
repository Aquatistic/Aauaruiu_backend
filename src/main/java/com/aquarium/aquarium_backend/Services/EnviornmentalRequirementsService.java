package com.aquarium.aquarium_backend.Services;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.EnvironmentalRequirementsRepository;

@Service
public class EnviornmentalRequirementsService {
    private final EnvironmentalRequirementsRepository environmentalRequirementsRepository;

    public EnviornmentalRequirementsService(EnvironmentalRequirementsRepository environmentalRequirementsRepository) {
        this.environmentalRequirementsRepository = environmentalRequirementsRepository;
    }
}
