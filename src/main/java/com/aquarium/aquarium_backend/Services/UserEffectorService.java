package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.UserEffectorRepository;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEffectorService {
    private final UserEffectorRepository userEffectorRepository;

    public UserEffectorService(UserEffectorRepository userEffectorRepository) {
        this.userEffectorRepository = userEffectorRepository;
    }

    public List<UserEffectors> getAllUsers() {
        return userEffectorRepository.findAll();
    }

    public List<UserEffectors> getUserEffectorsByAquariumId(Long aquariumId) {
        return userEffectorRepository.findUserEffectorsByAquariumId(aquariumId);
    }
}
