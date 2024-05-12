package com.aquarium.aquarium_backend.Configurations;

import com.aquarium.aquarium_backend.Repositories.EffectorTypeRepository;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import java.io.FileReader;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EffectorTypeConfiguration {
  @Bean
  CommandLineRunner effectorCommandLineRunner(EffectorTypeRepository repository) {
    JSONParser jsonParser = new JSONParser(1);
    try {
      JSONArray effectorTypes =
          (JSONArray)
              jsonParser.parse(
                  new FileReader(
                      "src/main/java/com/aquarium/aquarium_backend/databaseTables/DictTableValues/EffectorTypes.json"));
      return args -> {
        effectorTypes.forEach(
            (effectorType) -> {
              try {
                JSONObject effectorTypeJson = new JSONObject(effectorType.toString());
                String name = effectorTypeJson.getString("name");
                String unit = effectorTypeJson.getString("unit");
                EffectorType newSensorType = new EffectorType(name, unit);
                repository.save(newSensorType);
              } catch (Exception e) {
                e.printStackTrace();
              }
            });
      };
    } catch (Exception e) {
      throw new RuntimeException("Failed to read effectorTypes.json");
    }
  }
}
