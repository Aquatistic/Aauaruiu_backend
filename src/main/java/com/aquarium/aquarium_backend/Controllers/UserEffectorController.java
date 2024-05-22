package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Helpers.ControllStruct;
import com.aquarium.aquarium_backend.Services.UserEffectorService;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping(path = "api/v1/userEffector")
public class UserEffectorController {
  private final UserEffectorService userEffectorService;

  public UserEffectorController(UserEffectorService userEffectorService) {
    this.userEffectorService = userEffectorService;
  }

  @GetMapping
  public ResponseEntity<List<UserEffectors>> getAllUsers() {
    List<UserEffectors> userEffectors = userEffectorService.getAllUsers();
    return new ResponseEntity<>(userEffectors, HttpStatus.OK);
  }

  @GetMapping("aquariums/{aquariumId}")
  public ResponseEntity<List<UserEffectors>> getEffectorsByAquariumId(
      @PathVariable Long aquariumId) {
    List<UserEffectors> userEffectors =
        userEffectorService.getUserEffectorsByAquariumId(aquariumId);
    return new ResponseEntity<>(userEffectors, HttpStatus.OK);
  }

  @PostMapping("add")
  public ResponseEntity<?> addUserEffector(@RequestBody Map<String, Object> payload) {
    try {
      Long aquariumId = Long.valueOf(payload.get("aquariumId").toString());
      int effectorTypeId = Integer.valueOf(payload.get("effectorTypeId").toString());
      float effectorValue = Float.valueOf(payload.get("effectorValue").toString());
      String effectorControlType = payload.get("effectorControlType").toString();
      UserEffectors createdUserEffector =
          userEffectorService.postEffector(
              aquariumId, effectorTypeId, effectorValue, effectorControlType);
      return new ResponseEntity<>(createdUserEffector, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(path = "/connect/{aquariumId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public ResponseEntity<SseEmitter> connectAquarium(@PathVariable Long aquariumId) {
    try {
      SseEmitter emitter = userEffectorService.connectAquarium(aquariumId);
      return new ResponseEntity<>(emitter, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/update")
  public ResponseEntity<?> updateEffectorValue(@RequestBody ControllStruct controllStruct) {
    try {
      userEffectorService.updateEffectorValue(controllStruct);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Unabel to send controlls to Aquarium", HttpStatus.BAD_REQUEST);
    }
  }
}
