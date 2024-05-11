package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.SensorTypeService;
import com.aquarium.aquarium_backend.databaseTables.SensorType;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/sensorType")
public class SensorTypeController {

  private final SensorTypeService sensorTypeService;

  public SensorTypeController(SensorTypeService sensorTypeService) {
    this.sensorTypeService = sensorTypeService;
  }

  @GetMapping
  public ResponseEntity<List<SensorType>> getAllSensorTypes() {
    List<SensorType> allSensorTypes = sensorTypeService.getAllSensorTypes();
    return new ResponseEntity<>(allSensorTypes, HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<SensorType> getSensorTypeById(@PathVariable Integer id) {
    SensorType sensorType = sensorTypeService.getSensorTypeById(id);
    return new ResponseEntity<>(sensorType, HttpStatus.OK);
  }
}
