package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;

@Service
public class AquariumService {
    private final AquariumRepository aquariumRepository;

    public AquariumService(AquariumRepository aquariumRepository) {
        this.aquariumRepository = aquariumRepository;
    }

    public List<Aquarium> getAllAquariums() {
        return aquariumRepository.findAll();
    }
}
