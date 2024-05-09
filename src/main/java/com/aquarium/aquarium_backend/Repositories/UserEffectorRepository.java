package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEffectorRepository extends JpaRepository<UserEffectors, Long> {
    @Query("Select uf from UserEffectors uf where uf.aquarium.aquariumId= :aquariumId")
    List<UserEffectors> findUserEffectorsByAquariumId(Long aquariumId);

}
