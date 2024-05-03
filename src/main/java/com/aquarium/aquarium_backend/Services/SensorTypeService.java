package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.SensorTypeRepository;
import com.aquarium.aquarium_backend.databaseTables.SensorType;

@Service
public class SensorTypeService {
    private final SensorTypeRepository sensorTypeRepository;

    @Autowired
    public SensorTypeService(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    public List<SensorType> getAllSensorTypes() {
        return sensorTypeRepository.findAll();
    }

    public SensorType getSensorTypeById(int id) {
        return sensorTypeRepository.findById(id).orElse(new SensorType());
    }
}
