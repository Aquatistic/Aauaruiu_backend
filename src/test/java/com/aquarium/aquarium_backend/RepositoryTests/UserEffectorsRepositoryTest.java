package com.aquarium.aquarium_backend.RepositoryTests;

import com.aquarium.aquarium_backend.Repositories.AquariumRepository;
import com.aquarium.aquarium_backend.Repositories.EffectorTypeRepository;
import com.aquarium.aquarium_backend.Repositories.UserEffectorRepository;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import com.aquarium.aquarium_backend.databaseTables.UserEffectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserEffectorsRepositoryTest {

    @Autowired
    UserEffectorRepository userEffectorRepository;
    @Autowired
    AquariumRepository aquariumRepository;
    @Autowired
    EffectorTypeRepository effectorTypeRepository;

    @BeforeEach
    void init() {
        aquariumRepository.deleteAll();
        userEffectorRepository.deleteAll();
    }

    @Test
    void findEffectorsAllEmpty() {
        List<UserEffectors> userEffectorsList = userEffectorRepository.findUserEffectorsByAquariumId(1L);
        List<UserEffectors> expectedUserEffectors = new ArrayList<>();
        assertThat(userEffectorsList).isEqualTo(expectedUserEffectors);
    }

    @Test
    void findEffectorsEffectorsEmpty() {
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, null);
        aquariumRepository.save(aquarium);
        List<UserEffectors> userEffectorsList = userEffectorRepository.findUserEffectorsByAquariumId(aquarium.getAquariumId());
        List<UserEffectors> expectedUserEffectors = new ArrayList<>();
        assertThat(userEffectorsList).isEqualTo(expectedUserEffectors);
    }

    @Test
    void findEffectorsNonEmpty() {
        Aquarium aquarium = new Aquarium("My Aquarium", 100.0f, null);
        aquariumRepository.save(aquarium);
        EffectorType effectorType = new EffectorType();
        effectorTypeRepository.save(effectorType);
        UserEffectors effector = new UserEffectors(effectorType, aquarium, 1.0f, "Example Control Type");
        userEffectorRepository.save(effector);
        List<UserEffectors> userEffectorsList = userEffectorRepository.findUserEffectorsByAquariumId(aquarium.getAquariumId());
        List<UserEffectors> expectedUserEffectors = List.of(effector);
        assertThat(userEffectorsList).isEqualTo(expectedUserEffectors);
    }
}
