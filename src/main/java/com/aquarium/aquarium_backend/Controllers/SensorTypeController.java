package com.aquarium.aquarium_backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.SensorTypeService;
import com.aquarium.aquarium_backend.databaseTables.SensorType;

@RestController
@RequestMapping(path = "api/v1/sensorType")
public class SensorTypeController {

    private final SensorTypeService sensorTypeService;

    public SensorTypeController(SensorTypeService sensorTypeService) {
        this.sensorTypeService = sensorTypeService;
    }

    @GetMapping
    public List<SensorType> getAllSensorTypes() {
        return sensorTypeService.getAllSensorTypes();
    }

    @GetMapping(path = "{id}")
    public SensorType getSensorTypeById(@PathVariable Integer id) {
        return sensorTypeService.getSensorTypeById(id);
    }
}
