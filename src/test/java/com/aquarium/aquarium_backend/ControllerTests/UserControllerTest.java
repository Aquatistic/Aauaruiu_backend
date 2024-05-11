package com.aquarium.aquarium_backend.ControllerTests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import com.aquarium.aquarium_backend.Controllers.UserController;
import com.aquarium.aquarium_backend.Services.UserService;
import com.aquarium.aquarium_backend.databaseTables.User;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class UserControllerTest {
  @Autowired UserController userController;

  @MockBean UserService userService;

  @Test
  void getAllUsersEmpty() {
    when(userService.getAllUsers()).thenReturn(List.of());
    assertThat(userController.getAllUsers())
        .isEqualTo(new ResponseEntity<>(List.of(), HttpStatus.OK));
  }

  @Test
  void getAllUsersNotEmpty() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    List<User> expectedUsers = List.of(user);
    when(userService.getAllUsers()).thenReturn(expectedUsers);
    assertThat(userController.getAllUsers())
        .isEqualTo(new ResponseEntity<>(expectedUsers, HttpStatus.OK));
  }

  @Test
  void getAllUsers() {
    User user = new User("Lucas", "lucas@gmail.com", "1234");
    User user2 = new User("Sacul", "sacul@gmail.com", "4321");
    List<User> expectedUsers = Arrays.asList(user, user2);
    when(userService.getAllUsers()).thenReturn(expectedUsers);
    assertThat(userController.getAllUsers())
        .isEqualTo(new ResponseEntity<>(expectedUsers, HttpStatus.OK));
  }
}
