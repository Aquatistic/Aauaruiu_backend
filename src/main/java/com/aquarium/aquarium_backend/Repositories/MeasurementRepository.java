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

  @Query("Select mes from Measurement mes where mes.userSensor.userSensorId= :userSensorId order by mes.measurementTimestamp desc FETCH NEXT :count ROWS ONLY")
  public List<Measurement> findLastMeasurements(Long userSensorId, Integer count);

  @Query("Select mes from Measurement mes where mes.userSensor.userSensorId= :userSensorId and EXTRACT(day from mes.measurementTimestamp) > EXTRACT(day from LOCALTIMESTAMP) - :days order by mes.measurementTimestamp desc")
  public List<Measurement> findLastDaysMeasurements(Long userSensorId, Integer days);
}
