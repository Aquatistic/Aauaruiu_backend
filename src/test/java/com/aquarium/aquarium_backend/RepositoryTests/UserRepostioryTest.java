package com.aquarium.aquarium_backend.RepositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import com.aquarium.aquarium_backend.Repositories.UserRepository;
import com.aquarium.aquarium_backend.databaseTables.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepostioryTest {

  @Autowired UserRepository userRepository;

  @BeforeEach
  void init() {
    userRepository.deleteAll();
  }

  @Test
  void ReturnUserById() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    userRepository.save(user);
    User user2 = userRepository.findById(user.getUserId()).get();
    assertThat(user).isEqualTo(user2);
  }
}
