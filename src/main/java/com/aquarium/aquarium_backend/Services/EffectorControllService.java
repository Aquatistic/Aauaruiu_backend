package com.aquarium.aquarium_backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aquarium.aquarium_backend.Repositories.EffectorControllRepository;
import com.aquarium.aquarium_backend.databaseTables.EffectorControll;

@Service
public class EffectorControllService {

    private final EffectorControllRepository effectorControllRepository;

    public EffectorControllService(EffectorControllRepository effectorControllRepository) {
        this.effectorControllRepository = effectorControllRepository;
    }

    public List<EffectorControll> getAllEffectorControll() {
        return effectorControllRepository.findAll();
    }

    public List<EffectorControll> getEffectorControlsByEffectorId(Long effectorId) {
        return effectorControllRepository.findControlsByUserEffectorId(effectorId);
    }

}
