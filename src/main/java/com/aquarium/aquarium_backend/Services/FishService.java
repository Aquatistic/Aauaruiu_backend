package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.FishRepository;
import com.aquarium.aquarium_backend.Repositories.FishTypeRepository;
import com.aquarium.aquarium_backend.databaseTables.Fish;

@Service
public class FishService {
    private final FishRepository fishRepository;
    private final AquariumRepository aquariumRepository;
    private final FishTypeRepository fishTypeRepository;

    public FishService(FishRepository fishRepository, AquariumRepository aquariumRepository,
            FishTypeRepository fishTypeRepository) {
        this.fishRepository = fishRepository;
        this.aquariumRepository = aquariumRepository;
        this.fishTypeRepository = fishTypeRepository;
    }

    public List<Fish> getAllFish() {
        return fishRepository.findAll();
    }

    public List<Fish> getFishInAquarium(Long aquariumId) throws Exception {
        aquariumRepository.findById(aquariumId).orElseThrow(() -> new Exception("Aquarium not found"));
        return fishRepository.findFishByAquariumId(aquariumId);
    }

    public void addFish(Long aquariumId, int fishTypeId, int count) throws Exception {
        try {
            fishRepository.save(new Fish(fishTypeRepository.findById(fishTypeId).get(),
                    aquariumRepository.findById(aquariumId).get(), count));
        } catch (Exception e) {
            throw new Exception("Failed to add new fish");
        }
    }
}
