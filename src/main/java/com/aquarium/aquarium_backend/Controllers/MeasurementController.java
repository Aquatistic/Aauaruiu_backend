package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.MeasurementService;
import com.aquarium.aquarium_backend.databaseTables.Measurement;
import java.util.List;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("userSensor/{userSensorId}")
  public ResponseEntity<List<Measurement>> getmeasurementByUserSensorId(@PathVariable Long userSensorId) {
    return new ResponseEntity<>(
        measurementService.getMeasurementsByUserSensorId(userSensorId), HttpStatus.OK);
  }

  @PostMapping("add")
  public ResponseEntity<Boolean> addMeasurement(
      @RequestBody List<Pair<Measurement, Long>> measurements) {
    if (!measurementService.addMeasurements(measurements)) {
      return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(true, HttpStatus.CREATED);
  }
}
