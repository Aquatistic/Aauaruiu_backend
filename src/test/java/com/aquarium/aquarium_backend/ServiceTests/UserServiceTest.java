package com.aquarium.aquarium_backend.ServiceTests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import com.aquarium.aquarium_backend.Repositories.UserRepository;
import com.aquarium.aquarium_backend.Services.UserService;
import com.aquarium.aquarium_backend.databaseTables.User;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTest {
  @Autowired UserService userService;

  @MockBean UserRepository userRepository;

  @BeforeEach
  void init() {
    userRepository.deleteAll();
  }

  @Test
  void ReturnAllUsersEmpty() {
    List<User> expectedUsers = List.of();
    when(userRepository.findAll()).thenReturn(expectedUsers);
    assertThat(userService.getAllUsers()).isEqualTo(expectedUsers);
  }

  @Test
  void ReturnAllUsersNotEmpty() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    List<User> expectedUsers = List.of(user);
    when(userRepository.findAll()).thenReturn(expectedUsers);
    assertThat(userService.getAllUsers().size()).isEqualTo(1);
  }

  @Test
  void ReturnAllUsers() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    User user2 = new User("Sacul", "sacul@gmail.com", "4321");
    List<User> expectedUsers = Arrays.asList(user, user2);
    when(userRepository.findAll()).thenReturn(expectedUsers);
    assertThat(userService.getAllUsers()).isEqualTo(expectedUsers);
  }
}
