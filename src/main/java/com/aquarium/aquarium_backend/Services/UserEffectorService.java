package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.UserEffectorRepository;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;

@Service
public class UserEffectorService {
    private final UserEffectorRepository userEffectorRepository;

    public UserEffectorService(UserEffectorRepository userEffectorRepository) {
        this.userEffectorRepository = userEffectorRepository;
    }

    public List<UserEffectors> getAllUsers() {
        return userEffectorRepository.findAll();
    }
}
