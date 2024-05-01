package com.aquarium.aquarium_backend.Configurations;

import java.io.File;
import java.io.FileReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aquarium.aquarium_backend.Repositories.SensorTypeRepository;
import com.aquarium.aquarium_backend.databaseTables.SensorType;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;

import org.json.JSONObject;

@Configuration
public class SensorTypeConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(SensorTypeRepository repository) {
        JSONParser jsonParser = new JSONParser(1);
        try {
            JSONArray sensorTypes = (JSONArray) jsonParser.parse(new FileReader(
                    "/resources/SensorTypes.json"));
            return args -> {
                sensorTypes.forEach((sensorType) -> {
                    try {
                        JSONObject sensorTypeJson = new JSONObject(sensorType.toString());
                        String name = sensorTypeJson.getString("name");
                        String unit = sensorTypeJson.getString("unit");
                        SensorType newSensorType = new SensorType(name, unit);
                        repository.save(newSensorType);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            };
        } catch (Exception e) {
            throw new RuntimeException("Failed to read sensorTypes.json");
        }
    }
}
