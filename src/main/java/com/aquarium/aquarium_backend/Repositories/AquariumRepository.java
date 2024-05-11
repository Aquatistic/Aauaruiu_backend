package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AquariumRepository extends JpaRepository<Aquarium, Long> {
  @Query("SELECT a from Aquarium a WHERE a.user.userId = :userId")
  List<Aquarium> findAquariumsByUserId(Long userId);
}
