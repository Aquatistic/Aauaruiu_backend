package com.aquarium.aquarium_backend.ControllerTests;

import com.aquarium.aquarium_backend.Controllers.UserEffectorController;
import com.aquarium.aquarium_backend.Services.UserEffectorService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
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
public class UserEffectorsControllerTest {
    @Autowired
    UserEffectorController userEffectorController;

    @MockBean
    UserEffectorService userEffectorService;

    @Test
    void getEffectorsByAquariumId() {
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, null);
        EffectorType effectorType = new EffectorType();
        UserEffectors effector = new UserEffectors(effectorType, aquarium, 1.0f, "Example Control Type");
        List<UserEffectors> expectedEffectors = List.of(effector);
        when(userEffectorService.getUserEffectorsByAquariumId(aquarium.getAquariumId())).thenReturn(expectedEffectors);
        ResponseEntity<List<UserEffectors>> effectorsList = userEffectorController.getEffectorsByAquariumId(aquarium.getAquariumId());
        assertThat(effectorsList).isEqualTo(new ResponseEntity<>(expectedEffectors, HttpStatus.OK));

    }
}
