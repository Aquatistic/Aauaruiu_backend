package com.aquarium.aquarium_backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aquarium.aquarium_backend.databaseTables.EffectorControll;

@Repository
public interface EffectorControllRepository extends JpaRepository<EffectorControll, Long> {
    @Query("Select cnt from EffectorControll cnt where cnt.userEffector.userEffectorId= :effectorId")
    List<EffectorControll> findControlsByUserEffectorId(Long effectorId);

    @Query("Select cnt from EffectorControll cnt where cnt.controllActivationMoment < CURRENT_DATE ORDER BY cnt.controllActivationMoment DESC FETCH NEXT 1 ROWS ONLY")
    EffectorControll findCurrentControlsByUserEffectorId(Long effectorId);
}
