package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.UserSensorRepository;
import com.aquarium.aquarium_backend.databaseTables.UserSensors;

@Service
public class UserSensorService {
    private final UserSensorRepository userSensorRepository;

    public UserSensorService(UserSensorRepository userSensorRepository) {
        this.userSensorRepository = userSensorRepository;
    }

    public List<UserSensors> getAllUsers() {
        return userSensorRepository.findAll();
    }

    public boolean addUser(UserSensors userSensor) {
        try {
            userSensorRepository.save(userSensor);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
