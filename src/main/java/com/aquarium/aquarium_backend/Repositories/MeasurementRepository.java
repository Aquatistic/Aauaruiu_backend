package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.Measurement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

  @Query("Select mes from Measurement mes where mes.userSensor.userSensorId= :userSensorId")
  List<Measurement> findMeasurementsByUserSensorId(Long userSensorId);
}
