package com.aquarium.aquarium_backend.Configurations;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aquarium.aquarium_backend.Repositories.EnvironmentalRequirementsRepository;
import com.aquarium.aquarium_backend.databaseTables.EnvironmentalRequirements;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;

@Configuration
public class EnvironmentalRequirementsConfiguration {
  @Bean
  CommandLineRunner environmentalRequirementsCommandLineRunner(
      EnvironmentalRequirementsRepository repository) {
    JSONParser jsonParser = new JSONParser(1);
    try {
      JSONArray environmentalRequirements =
          (JSONArray)
              jsonParser.parse(
                  new FileReader(
                      "src/main/java/com/aquarium/aquarium_backend/databaseTables/DictTableValues/EnvironmentalRequirements.json"));
      return args -> {
        environmentalRequirements.forEach(
            (environmentalRequirement) -> {
              try {
                JSONObject environmentalRequirementJson =
                    new JSONObject(environmentalRequirement.toString());
                String name = environmentalRequirementJson.getString("name");
                String unit = environmentalRequirementJson.getString("unit");
                Double value = environmentalRequirementJson.getDouble("value");
                ArrayList<String> fishNames = new ArrayList<String>();
                var fishNamesJson = environmentalRequirementJson.getJSONArray("fish");
                for (int i = 0; i < fishNamesJson.length(); i++) {
                  fishNames.add(fishNamesJson.getString(i));
                }
                EnvironmentalRequirements newEnvironmentalRequirements =
                    new EnvironmentalRequirements(name, unit, value.floatValue(), fishNames);
                repository.save(newEnvironmentalRequirements);
              } catch (Exception e) {
                e.printStackTrace();
              }
            });
      };
    } catch (Exception e) {
      throw new RuntimeException("Failed to read environmentalRequirements.json");
    }
  }
}
