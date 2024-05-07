package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.MeasurementService;
import com.aquarium.aquarium_backend.databaseTables.Measurement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        List<Measurement> allMeasurements = measurementService.getAllMeasurements();
        return new ResponseEntity<>(allMeasurements, HttpStatus.OK);
    }
}
