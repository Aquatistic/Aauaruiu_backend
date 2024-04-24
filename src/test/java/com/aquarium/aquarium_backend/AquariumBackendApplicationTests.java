package com.aquarium.aquarium_backend;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AquariumBackendApplicationTests {

	@Test
	void contextLoads() {
	}
	public void testExample() {
		int expected = 1;
		int result = 1;
		assertThat(result).isEqualTo(expected);
	}

}
