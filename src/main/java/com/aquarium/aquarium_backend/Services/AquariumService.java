package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AquariumService {

    private final AquariumRepository aquariumRepository;

    @Autowired
    public AquariumService(AquariumRepository aquariumRepository) {
        this.aquariumRepository = aquariumRepository;
    }

    public List<Aquarium> getAllUsersAquariums(Long userId) {
        return aquariumRepository.findAquariumsByUserId(userId);
    }
    
    public List<Aquarium> getAllAquariums() {
        return aquariumRepository.findAll();
    }
}
