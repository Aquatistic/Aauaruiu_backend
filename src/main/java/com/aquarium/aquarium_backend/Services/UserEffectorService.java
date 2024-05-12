package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.EffectorTypeRepository;
import com.aquarium.aquarium_backend.Repositories.UserEffectorRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserEffectorService {
  private final UserEffectorRepository userEffectorRepository;
  private final AquariumRepository aquariumRepository;
  private final EffectorTypeRepository effectorTypeRepository;

  public UserEffectorService(
      UserEffectorRepository userEffectorRepository,
      AquariumRepository aquariumRepository,
      EffectorTypeRepository effectorTypeRepository) {
    this.userEffectorRepository = userEffectorRepository;
    this.aquariumRepository = aquariumRepository;
    this.effectorTypeRepository = effectorTypeRepository;
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
    Aquarium aquarium =
        aquariumRepository
            .findById(aquariumId)
            .orElseThrow(() -> new Exception("Aquarium does not exist"));
    EffectorType effectorType =
        effectorTypeRepository
            .findById(effectorTypeId)
            .orElseThrow(() -> new Exception("Effector Type does not exist"));

    UserEffectors userEffectors =
        new UserEffectors(effectorType, aquarium, effectorValue, effectorControlType);
    return userEffectorRepository.save(userEffectors);
  }
}
