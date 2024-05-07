package com.aquarium.aquarium_backend.ControllerTests;

import com.aquarium.aquarium_backend.Controllers.AquariumController;
import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AquariumControllerTest {
    @Autowired
    AquariumController aquariumController;

    @MockBean
    AquariumService aquariumService;

    @Test
    void getAllUsersAquariumsEmptyAquariumAndUsers() {
        List<Aquarium> expectedAquariums = List.of();
        when(aquariumService.getAllUsersAquariums(1L)).thenReturn(expectedAquariums);
        assertThat(aquariumController.getAquariumByUserId(1L)).isEqualTo(new ResponseEntity<>(expectedAquariums, HttpStatus.OK));
    }

    @Test
    void getAllUsersAquariumsNonEmpty() {
        User user = new User("Lucas", "lucas@gmail.com", "1234");
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, user);
        Aquarium aquarium2 = new Aquarium("My Aquarium2", 130.0f, user);
        List<Aquarium> expectedAquariums = List.of(aquarium, aquarium2);
        when(aquariumService.getAllUsersAquariums(user.getUserId())).thenReturn(expectedAquariums);
        assertThat(aquariumController.getAquariumByUserId(user.getUserId())).isEqualTo(new ResponseEntity<>(expectedAquariums, HttpStatus.OK));
    }
}
