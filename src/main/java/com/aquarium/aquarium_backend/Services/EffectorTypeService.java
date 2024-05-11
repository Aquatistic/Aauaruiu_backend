package com.aquarium.aquarium_backend.Services;

import com.aquarium.aquarium_backend.Repositories.EffectorTypeRepository;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EffectorTypeService {
  private final EffectorTypeRepository effectorTypeRepository;

  public EffectorTypeService(EffectorTypeRepository effectorTypeRepository) {
    this.effectorTypeRepository = effectorTypeRepository;
  }

  public List<EffectorType> getAllEffectorTypes() {
    return effectorTypeRepository.findAll();
  }
}
