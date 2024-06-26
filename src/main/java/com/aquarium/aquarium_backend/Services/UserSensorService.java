package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.SensorTypeRepository;
import com.aquarium.aquarium_backend.Repositories.UserSensorRepository;
import com.aquarium.aquarium_backend.databaseTables.UserSensors;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserSensorService {
  private final UserSensorRepository userSensorRepository;
  private final AquariumRepository aquariumRepository;
  private final SensorTypeRepository sensorTypeRepository;

  public UserSensorService(
      UserSensorRepository userSensorRepository,
      AquariumRepository aquariumRepository,
      SensorTypeRepository sensorTypeRepository) {
    this.userSensorRepository = userSensorRepository;
    this.aquariumRepository = aquariumRepository;
    this.sensorTypeRepository = sensorTypeRepository;
  }

  public List<UserSensors> getAllUsers() {
    return userSensorRepository.findAll();
  }

  public List<UserSensors> getUserSensorsByAquariumId(Long aquariumId) {
    aquariumRepository.findById(aquariumId).orElseThrow();
    return userSensorRepository.findUserSensorsByAquariumId(aquariumId);
  }

  public boolean addUserSensor(Long aquariumId, int sensorTypeId) {
    try {
      var userSensor =
          new UserSensors(
              aquariumRepository.findById(aquariumId).get(),
              sensorTypeRepository.findById(sensorTypeId).get());
      userSensorRepository.save(userSensor);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
