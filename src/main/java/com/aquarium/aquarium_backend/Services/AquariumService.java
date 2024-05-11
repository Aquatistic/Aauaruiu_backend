package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.UserRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AquariumService {

  private final AquariumRepository aquariumRepository;
  private final UserRepository userRepository;

  @Autowired
  public AquariumService(AquariumRepository aquariumRepository, UserRepository userRepository) {

    this.aquariumRepository = aquariumRepository;
    this.userRepository = userRepository;
  }

  public List<Aquarium> getAllUsersAquariums(Long userId) throws Exception {
    User user =
        userRepository.findById(userId).orElseThrow(() -> new Exception("User does not exist"));
    return aquariumRepository.findAquariumsByUserId(userId);
  }

  public List<Aquarium> getAllAquariums() {
    return aquariumRepository.findAll();
  }
}
