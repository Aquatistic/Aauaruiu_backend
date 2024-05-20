package com.aquarium.aquarium_backend.Configurations;

import java.io.FileReader;

import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aquarium.aquarium_backend.Repositories.FishTypeRepository;
import com.aquarium.aquarium_backend.databaseTables.FishType;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;

@Configuration
public class FishTypeConfiguration {
  @Bean
  CommandLineRunner fishCommandLineRunner(FishTypeRepository repository) {
    JSONParser jsonParser = new JSONParser(1);
    try {
      JSONArray effectorTypes =
          (JSONArray)
              jsonParser.parse(
                  new FileReader(
                      "src/main/java/com/aquarium/aquarium_backend/databaseTables/DictTableValues/FishTypes.json"));
      return args -> {
        effectorTypes.forEach(
            (effectorType) -> {
              try {
                JSONObject effectorTypeJson = new JSONObject(effectorType.toString());
                String name = effectorTypeJson.getString("name");
                FishType newSensorType = new FishType(name);
                repository.save(newSensorType);
              } catch (Exception e) {
                e.printStackTrace();
              }
            });
      };
    } catch (Exception e) {
      throw new RuntimeException("Failed to read fishType.json " + e.getMessage());
    }
  }
}
