package ms.cloud.guru.client.beer.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ms.cloud.guru.client.beer.web.model.BeerDto;
import ms.cloud.guru.client.beer.web.model.Customer;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

	public final String BEER_PATH_V1 = "/api/v1/beer/";
	public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

	private String apiHost;

	private final RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
//	Beer Data

	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
	}

	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
	}

	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apiHost + BEER_PATH_V1 + uuid, beerDto);
	}

	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + uuid);
	}

//	Customer Data
	
	public Customer getCustomerById(UUID customerId) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + customerId.toString(), Customer.class);
	}

	public URI saveNewCustomer(Customer customer) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customer);
	}

	public void updateCustomer(UUID customerId, Customer customer) {
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId, customer);
	}

	public void deleteCustomer(UUID customerId) {
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId);
	}


}
