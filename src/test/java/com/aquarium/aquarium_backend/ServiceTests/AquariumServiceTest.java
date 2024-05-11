package com.aquarium.aquarium_backend.ServiceTests;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.UserRepository;
import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AquariumServiceTest {
    @Autowired
    AquariumService aquariumService;

    @MockBean
    AquariumRepository aquariumRepository;

    @MockBean
    UserRepository userRepository;

    @Test
    void getAllUsersAquariumsEmptyAquariumAndUsers() {
        List<Aquarium> expectedAquariums = List.of();
        when(aquariumRepository.findAquariumsByUserId(1L)).thenReturn(expectedAquariums);
        Exception exception = assertThrows(Exception.class, () -> aquariumService.getAllUsersAquariums(1L));
        assertEquals("User does not exist", exception.getMessage());
    }

    @Test
    void getAllUsersByUserIdEmptyAquariumList() throws Exception {
        Long userId = 1L;
        User user = new User("Lucas", "lucas@gmail.com", "1234");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, user);
        Aquarium aquarium2 = new Aquarium("My Aquarium2", 130.0f, user);
        List<Aquarium> expectedAquariums = List.of(aquarium, aquarium2);
        when(aquariumRepository.findAquariumsByUserId(userId)).thenReturn(expectedAquariums);
        assertThat(aquariumService.getAllUsersAquariums(userId)).isEqualTo(expectedAquariums);
    }
}
