package com.aquarium.aquarium_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquarium.aquarium_backend.databaseTables.EffectorControll;

@Repository
public interface EffectorControllRepository extends JpaRepository<EffectorControll, Long> {
}
