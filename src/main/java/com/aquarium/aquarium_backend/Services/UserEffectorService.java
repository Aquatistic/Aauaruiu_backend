package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Helpers.ControllStruct;
import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.EffectorTypeRepository;
import com.aquarium.aquarium_backend.Repositories.UserEffectorRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class UserEffectorService {
  private final UserEffectorRepository userEffectorRepository;
  private final AquariumRepository aquariumRepository;
  private final EffectorTypeRepository effectorTypeRepository;
  private final HashMap<Aquarium, SseEmitter> emitters;

  public UserEffectorService(
      UserEffectorRepository userEffectorRepository,
      AquariumRepository aquariumRepository,
      EffectorTypeRepository effectorTypeRepository) {
    this.userEffectorRepository = userEffectorRepository;
    this.aquariumRepository = aquariumRepository;
    this.effectorTypeRepository = effectorTypeRepository;
    this.emitters = new HashMap<>();
  }

  public List<UserEffectors> getAllUsers() {
    return userEffectorRepository.findAll();
  }

  public List<UserEffectors> getUserEffectorsByAquariumId(Long aquariumId) {
    return userEffectorRepository.findUserEffectorsByAquariumId(aquariumId);
  }

  public UserEffectors postEffector(
      Long aquariumId, int effectorTypeId, float effectorValue, String effectorControlType)
      throws Exception {
    Aquarium aquarium = aquariumRepository
        .findById(aquariumId)
        .orElseThrow(() -> new Exception("Aquarium does not exist"));
    EffectorType effectorType = effectorTypeRepository
        .findById(effectorTypeId)
        .orElseThrow(() -> new Exception("Effector Type does not exist"));

    UserEffectors userEffectors = new UserEffectors(effectorType, aquarium, effectorValue, effectorControlType);
    return userEffectorRepository.save(userEffectors);
  }

  public SseEmitter connectAquarium(Long aquariumId) throws Exception {
    Aquarium aquarium = aquariumRepository
        .findById(aquariumId)
        .orElseThrow(() -> new Exception("Aquarium does not exist"));
    SseEmitter emitter = new SseEmitter(-1L);
    emitters.put(aquarium, emitter);
    return emitter;
  }

  public void updateEffectorValue(ControllStruct controllStruct) throws Exception {
    userEffectorRepository
        .findById(controllStruct.getEffectorId())
        .orElseThrow(() -> new Exception("Effector doesn't exist"));
    var aquarium = aquariumRepository
        .findById(controllStruct.getAquariumId())
        .orElseThrow(() -> new Exception("Aquarium doesn't exist"));
    SseEmitter emitter = emitters.get(aquarium);
    emitter.send(controllStruct);
    userEffectorRepository.updateUserEffectorValue(controllStruct.getEffectorId(), controllStruct.getValue());
  }
}
