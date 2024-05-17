package com.aquarium.aquarium_backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aquarium.aquarium_backend.databaseTables.Fish;

@Repository
public interface FishRepository extends JpaRepository<Fish, Integer> {
    @Query("Select fsh from Fish fsh where fsh.aquarium.aquariumId= :aquariumId")
    List<Fish> findFishByAquariumId(Long aquariumId);
}
