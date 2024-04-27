package com.aquarium.aquarium_backend.Repositories;

import com.aquarium.aquarium_backend.databaseTables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
