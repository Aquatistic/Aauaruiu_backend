package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.UserRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.User;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class AquariumService {

  private final AquariumRepository aquariumRepository;
  private final UserRepository userRepository;
  private final HashMap<Aquarium, SseEmitter> emitters;

  @Autowired
  public AquariumService(AquariumRepository aquariumRepository, UserRepository userRepository) {

    this.aquariumRepository = aquariumRepository;
    this.userRepository = userRepository;
    emitters = new HashMap<>();
  }

  public List<Aquarium> getAllUsersAquariums(Long userId) throws Exception {
    userRepository.findById(userId).orElseThrow(() -> new Exception("User does not exist"));
    return aquariumRepository.findAquariumsByUserId(userId);
  }

  public List<Aquarium> getAllAquariums() {
    return aquariumRepository.findAll();
  }

  public SseEmitter connectAquarium(Long aquariumId) {
    Aquarium aquarium = aquariumRepository.findById(aquariumId).orElse(null);
    if (aquarium == null) {
      return null;
    }
    SseEmitter emitter = new SseEmitter();
    emitters.put(aquarium, emitter);
    return emitter;
  }

  public Aquarium addAquarium(String aquariumName, float aquariumCapacity, Long userId)
      throws Exception {
    User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User does not exist"));
    Aquarium createdAquarium = new Aquarium(aquariumName, aquariumCapacity, user);
    return aquariumRepository.save(createdAquarium);
  }
}
