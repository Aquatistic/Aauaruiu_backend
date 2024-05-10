package com.aquarium.aquarium_backend.ServiceTests;

import com.aquarium.aquarium_backend.Repositories.UserEffectorRepository;
import com.aquarium.aquarium_backend.Services.UserEffectorService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserEffectorsServiceTest {
    @Autowired
    UserEffectorService userEffectorService;
    @MockBean
    UserEffectorRepository userEffectorRepository;

    @Test
    void getEffectorsByAquariumId() {
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, null);
        EffectorType effectorType = new EffectorType();
        UserEffectors effector = new UserEffectors(effectorType, aquarium, 1.0f, "Example Control Type");
        List<UserEffectors> expectedEffectors = List.of(effector);
        when(userEffectorRepository.findUserEffectorsByAquariumId(aquarium.getAquariumId())).thenReturn(expectedEffectors);
        List<UserEffectors> effectorsList = userEffectorService.getUserEffectorsByAquariumId(aquarium.getAquariumId());
        assertThat(effectorsList).isEqualTo(expectedEffectors);

    }
    
}
