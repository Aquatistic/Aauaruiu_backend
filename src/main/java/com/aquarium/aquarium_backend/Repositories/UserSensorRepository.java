package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.UserSensors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSensorRepository extends JpaRepository<UserSensors, Long> {
  @Query("Select us from UserSensors us where us.aquarium.aquariumId= :aquariumId")
  List<UserSensors> findUserSensorsByAquariumId(Long aquariumId);
}
