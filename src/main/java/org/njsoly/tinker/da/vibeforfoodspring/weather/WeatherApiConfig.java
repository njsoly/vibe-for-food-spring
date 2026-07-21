package org.njsoly.tinker.da.vibeforfoodspring.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WeatherApiConfig {

	@Bean
	RestClient weatherRestClient(RestClient.Builder builder) {
		return builder
				.baseUrl("https://api.weather.gov")
				.defaultHeader("Accept", "application/geo+json")
				.defaultHeader("User-Agent", "vibe-for-food-spring (https://github.com/njsoly)")
				.build();
	}

}
