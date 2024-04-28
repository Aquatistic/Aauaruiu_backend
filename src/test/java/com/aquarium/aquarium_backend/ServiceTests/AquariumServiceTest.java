package com.aquarium.aquarium_backend.ServiceTests;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AquariumServiceTest {
    @Autowired
    AquariumService aquariumService;

    @MockBean
    AquariumRepository aquariumRepository;

    @Test
    void getAllUsersAquariumsEmptyAquariumAndUsers() {
        List<Aquarium> expectedAquariums = List.of();
        when(aquariumRepository.findAquariumsByUserId(1L)).thenReturn(expectedAquariums);
        assertThat(aquariumService.getAllUsersAquariums(1L)).isEqualTo(expectedAquariums);
    }

    @Test
    void getAllUsersByUserIdEmptyAquariumList() {
        User user = new User("Lucas", "lucas@gmail.com", "1234");
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, user);
        Aquarium aquarium2 = new Aquarium("My Aquarium2", 130.0f, user);
        List<Aquarium> expectedAquariums = List.of(aquarium, aquarium2);
        when(aquariumRepository.findAquariumsByUserId(user.getUserId())).thenReturn(expectedAquariums);
        assertThat(aquariumService.getAllUsersAquariums(user.getUserId())).isEqualTo(expectedAquariums);
    }
}
