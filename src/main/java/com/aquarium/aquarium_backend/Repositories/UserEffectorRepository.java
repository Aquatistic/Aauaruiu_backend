package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserEffectorRepository extends JpaRepository<UserEffectors, Long> {
  @Query("Select uf from UserEffectors uf where uf.aquarium.aquariumId= :aquariumId")
  List<UserEffectors> findUserEffectorsByAquariumId(Long aquariumId);

  @Modifying
  @Transactional
  @Query(
      "Update UserEffectors uf set uf.effectorValue = :effectorValue where uf.userEffectorTypeId ="
          + " :userEffectorId")
  void updateUserEffectorValue(Long userEffectorId, float effectorValue);
}
