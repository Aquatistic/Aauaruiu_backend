package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {}
