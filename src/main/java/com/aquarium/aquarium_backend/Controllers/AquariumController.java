package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping(path = "api/v1/aquarium")
public class AquariumController {
  private final AquariumService aquariumService;

  public AquariumController(AquariumService aquariumService) {
    this.aquariumService = aquariumService;
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<?> getAquariumByUserId(@PathVariable Long userId) {
    try {
      List<Aquarium> aquariumList = aquariumService.getAllUsersAquariums(userId);
      return new ResponseEntity<>(aquariumList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  public ResponseEntity<List<Aquarium>> getAllAquariums() {
    List<Aquarium> aquariumList = aquariumService.getAllAquariums();
    return new ResponseEntity<>(aquariumList, HttpStatus.OK);
  }

  @PostMapping("add")
  public ResponseEntity<?> addAquarium(@RequestBody Map<String, Object> payload) {
    try {
      String aquariumName = payload.get("aquariumName").toString();
      float aquariumCapacity = Float.valueOf(payload.get("aquariumCapacity").toString());
      Long userId = Long.valueOf(payload.get("userId").toString());
      Aquarium aquarium = aquariumService.addAquarium(aquariumName, aquariumCapacity, userId);
      return new ResponseEntity<>(aquarium, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(path = "/connect/{aquariumId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public ResponseEntity<SseEmitter> connectAquarium(@PathVariable Long aquariumId) {
    SseEmitter emitter = aquariumService.connectAquarium(aquariumId);
    if (emitter == null) {
      return new ResponseEntity<>(null,
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(emitter, HttpStatus.OK);
  }
}
