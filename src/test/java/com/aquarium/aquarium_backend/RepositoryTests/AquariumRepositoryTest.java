package com.aquarium.aquarium_backend.RepositoryTests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.UserRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.User;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AquariumRepositoryTest {
  @Autowired AquariumRepository aquariumRepository;
  @Autowired UserRepository userRepository;

  @BeforeEach
  void init() {
    aquariumRepository.deleteAll();
  }

  @Test
  void findAquariumsByUserIdEmptyAquariumAndUsersList() {
    List<Aquarium> listAquariums = aquariumRepository.findAquariumsByUserId(1L);
    assertThat(listAquariums.size()).isEqualTo(0);
  }

  @Test
  void findAquariumsByUserIdEmptyAquariumList() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    userRepository.save(user);
    List<Aquarium> listAquariums = aquariumRepository.findAquariumsByUserId(1L);
    assertThat(listAquariums.size()).isEqualTo(0);
  }

  @Test
  void findAquariumsByUserIdEmptyUsers() {
    Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, null);
    aquariumRepository.save(aquarium);
    List<Aquarium> listAquariums = aquariumRepository.findAquariumsByUserId(1L);
    assertThat(listAquariums.size()).isEqualTo(0);
  }

  @Test
  void findAquariumsByUserIdSingleAquarium() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    userRepository.save(user);
    Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, user);
    aquariumRepository.save(aquarium);
    List<Aquarium> listAquariums = aquariumRepository.findAquariumsByUserId(user.getUserId());
    assertThat(listAquariums.size()).isEqualTo(1);
  }

  @Test
  void findAquariumsByUserIdMultipleAquarium() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    userRepository.save(user);
    Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, user);
    Aquarium aquarium2 = new Aquarium("My Aquarium2", 130.0f, user);
    aquariumRepository.saveAll(List.of(aquarium, aquarium2));
    List<Aquarium> listAquariums = aquariumRepository.findAquariumsByUserId(user.getUserId());
    assertThat(listAquariums).isEqualTo(List.of(aquarium, aquarium2));
  }
}
