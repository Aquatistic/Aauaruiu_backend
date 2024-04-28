package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AquariumRepository extends JpaRepository<Aquarium, Long> {
    @Query("SELECT a from Aquarium a WHERE a.user.userId = :userId")
    List<Aquarium> findAquariumsByUserId(Long userId);


}
