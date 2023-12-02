package ms.cloud.guru.client.beer.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ms.cloud.guru.client.beer.web.model.BeerDto;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

	public final String BEER_PATH_V1 = "/api/v1/beer/";

	private String apiHost;
	
	private final RestTemplate restTemplate;
	

	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	public BeerDto getBeerById(UUID uuid)
	{
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
	}

}
