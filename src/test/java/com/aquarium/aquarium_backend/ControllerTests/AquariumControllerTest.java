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
    void getAllUsersAquariumsEmptyAquariumAndUsers() throws Exception {
        Exception e = new Exception("User does not exist");
        List<Aquarium> expectedAquariums = List.of();
        when(aquariumService.getAllUsersAquariums(1L)).thenThrow(e);
        assertThat(aquariumController.getAquariumByUserId(1L)).isEqualTo(new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @Test
    void getAllUsersAquariumsNonEmpty() throws Exception {
        Long userId = 1L;
        User user = new User("Lucas", "lucas@gmail.com", "1234");
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, user);
        Aquarium aquarium2 = new Aquarium("My Aquarium2", 130.0f, user);
        List<Aquarium> expectedAquariums = List.of(aquarium, aquarium2);
        when(aquariumService.getAllUsersAquariums(userId)).thenReturn(expectedAquariums);
        assertThat(aquariumController.getAquariumByUserId(userId)).isEqualTo(new ResponseEntity<>(expectedAquariums, HttpStatus.OK));
    }
}
