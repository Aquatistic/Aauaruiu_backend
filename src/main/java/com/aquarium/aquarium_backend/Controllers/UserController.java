package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.UserService;
import com.aquarium.aquarium_backend.databaseTables.User;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> usersList = userService.getAllUsers();
    return new ResponseEntity<>(usersList, HttpStatus.OK);
  }
}
