package com.aquarium.aquarium_backend.ControllerTests;

import com.aquarium.aquarium_backend.Controllers.UserController;
import com.aquarium.aquarium_backend.Services.UserService;
import com.aquarium.aquarium_backend.databaseTables.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserController userController;

    @MockBean
    UserService userService;

    @Test
    void getAllUsersEmpty() {
        when(userService.getAllUsers()).thenReturn(List.of());
        assertThat(userController.getAllUsers().size()).isEqualTo(0);

    }

    @Test
    void getAllUsersNotEmpty() {
        User user = new User("Lucas", "lucas@gmail.com", "1234");
        when(userService.getAllUsers()).thenReturn(List.of(user));
        assertThat(userController.getAllUsers().size()).isEqualTo(1);
    }

    @Test
    void getAllUsers() {
        User user = new User("Lucas", "lucas@gmail.com", "1234");
        User user2 = new User("Sacul", "sacul@gmail.com", "4321");
        List<User> expectedUsers = Arrays.asList(user, user2);
        when(userService.getAllUsers()).thenReturn(expectedUsers);
    }
}
