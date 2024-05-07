package com.aquarium.aquarium_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;

import java.util.List;
@Repository
public interface AquariumRepository extends JpaRepository<Aquarium, Long> {
    @Query("SELECT a from Aquarium a WHERE a.user.userId = :userId")
    List<Aquarium> findAquariumsByUserId(Long userId);
}
