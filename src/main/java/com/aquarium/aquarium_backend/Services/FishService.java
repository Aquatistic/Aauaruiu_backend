package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.FishRepository;
import com.aquarium.aquarium_backend.databaseTables.Fish;

@Service
public class FishService {
    private final FishRepository fishRepository;

    public FishService(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    public List<Fish> getAllFish() {
        return fishRepository.findAll();
    }
}
