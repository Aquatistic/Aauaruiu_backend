package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.MeasurementRepository;
import com.aquarium.aquarium_backend.Repositories.UserSensorRepository;
import com.aquarium.aquarium_backend.databaseTables.Measurement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

  private final MeasurementRepository measurementRepository;
  private final UserSensorRepository userSensorRepository;

  @Autowired
  public MeasurementService(
      MeasurementRepository measurementRepository, UserSensorRepository userSensorRepository) {
    this.measurementRepository = measurementRepository;
    this.userSensorRepository = userSensorRepository;
  }

  public List<Measurement> getAllMeasurements() {
    return measurementRepository.findAll();
  }

  public Boolean addMeasurements(List<Pair<Measurement, Long>> measurements) {
    for (var measurement : measurements) {
      try {
        var userSensor = userSensorRepository.findById(measurement.getSecond()).get();
        measurement.getFirst().setUserSensor(userSensor);
        measurementRepository.save(measurement.getFirst());
      } catch (Exception e) {
        return false;
      }
    }
    return true;
  }
}
