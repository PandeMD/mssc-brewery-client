package ms.cloud.guru.client.beer.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ms.cloud.guru.client.beer.web.model.BeerDto;
import ms.cloud.guru.client.beer.web.model.Customer;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient client;

//	Beer Data Test
	
	@Test
	void testGetBeerById() {
		BeerDto beerDto = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(beerDto);
	}
	
	@Test
	void testSaveNewBeer()
	{
		BeerDto dto = BeerDto.builder().beerName("New Beer").build();
		
		URI uri = client.saveNewBeer(dto);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}
	
	@Test
	void testupdateBeer()
	{
		BeerDto dto = BeerDto.builder().beerName("New Beer").build();
		
		client.updateBeer(UUID.randomUUID(), dto);
		
	}
	
	@Test
	void testDeleteBeer()
	{
		client.deleteBeer(UUID.randomUUID());
	}
	
//	Customer Data Test
	
	@Test
	void testGetCutomerById()
	{
		Customer customer = client.getCustomerById(UUID.randomUUID());
		
		assertNotNull(customer);
	}
	
	@Test
	void testSaveNewCustomer()
	{
		Customer newCustomer = Customer.builder().CustName("Ram").build();
		
		URI uri = client.saveNewCustomer(newCustomer);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateCustomer()
	{
		Customer updateCust = Customer.builder().CustName("Krishna").build();
		
		client.updateCustomer(UUID.randomUUID(), updateCust);
	}

	@Test
	void testDeleteCustomer()
	{
		client.deleteCustomer(UUID.randomUUID());
	}
	
}
