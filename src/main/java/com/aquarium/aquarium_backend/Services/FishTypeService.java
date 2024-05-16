package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.FishTypeRepository;
import com.aquarium.aquarium_backend.databaseTables.FishType;

@Service
public class FishTypeService {
    private final FishTypeRepository fishTypeRepository;

    public FishTypeService(FishTypeRepository fishTypeRepository) {
        this.fishTypeRepository = fishTypeRepository;
    }

    public List<FishType> getAllFishTypes() {
        return fishTypeRepository.findAll();
    }
}
