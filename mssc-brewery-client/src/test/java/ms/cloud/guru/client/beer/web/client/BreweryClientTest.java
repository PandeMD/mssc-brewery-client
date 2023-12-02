package ms.cloud.guru.client.beer.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ms.cloud.guru.client.beer.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient client;

	@Test
	void testGetBeerById() {
		BeerDto beerDto = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(beerDto);
	}

}
