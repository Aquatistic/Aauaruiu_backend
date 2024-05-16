package com.aquarium.aquarium_backend.Services;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.FishRepository;

@Service
public class FishService {
    private final FishRepository fishRepository;

    public FishService(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }
}
