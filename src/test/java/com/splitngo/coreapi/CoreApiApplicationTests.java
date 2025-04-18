package com.splitngo.coreapi;

import com.splitngo.coreapi.repositories.TripRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class CoreApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@TestConfiguration
	static class MockedDependencies {
		@Bean
		public TripRepository tripRepository() {
			return Mockito.mock(TripRepository.class);
		}
	}

}
