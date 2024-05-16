package com.aquarium.aquarium_backend.Services;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.FishTypeRepository;

@Service
public class FishTypeService {
    private final FishTypeRepository fishTypeRepository;

    public FishTypeService(FishTypeRepository fishTypeRepository) {
        this.fishTypeRepository = fishTypeRepository;
    }
}
