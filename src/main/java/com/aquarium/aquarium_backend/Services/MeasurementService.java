package com.aquarium.aquarium_backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.MeasurementRepositiory;
import com.aquarium.aquarium_backend.databaseTables.Measurement;

import java.util.List;

@Service
public class MeasurementService {

    private final MeasurementRepositiory measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepositiory measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }
}
