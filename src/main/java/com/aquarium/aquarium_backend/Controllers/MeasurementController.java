package com.aquarium.aquarium_backend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.MeasurementService;
import com.aquarium.aquarium_backend.databaseTables.Measurement;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }
}
