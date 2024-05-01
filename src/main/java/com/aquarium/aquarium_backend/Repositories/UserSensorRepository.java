package com.aquarium.aquarium_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.aquarium_backend.databaseTables.UserSensors;

public interface UserSensorRepository extends JpaRepository<UserSensors, Long> {

}
