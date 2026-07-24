package org.njsoly.tinker.da.vibeforfoodspring.weather;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

	private final RestClient weatherRestClient;

	public WeatherService(RestClient weatherRestClient) {
		this.weatherRestClient = weatherRestClient;
	}

	public JsonNode getPoint(String latitude, String longitude) {
		return weatherRestClient.get()
				.uri("/points/{latitude},{longitude}", latitude, longitude)
				.retrieve()
				.body(JsonNode.class);
	}

	public JsonNode getForecast(String wfo, int x, int y) {
		return weatherRestClient.get()
				.uri("/gridpoints/{wfo}/{x},{y}/forecast", wfo, x, y)
				.retrieve()
				.body(JsonNode.class);
	}

	public JsonNode getHourlyForecast(String wfo, int x, int y) {
		return weatherRestClient.get()
				.uri("/gridpoints/{wfo}/{x},{y}/forecast/hourly", wfo, x, y)
				.retrieve()
				.body(JsonNode.class);
	}

	public JsonNode getActiveAlerts() {
		return weatherRestClient.get()
				.uri("/alerts/active")
				.retrieve()
				.body(JsonNode.class);
	}

	public JsonNode getLatestObservation(String stationId) {
		return weatherRestClient.get()
				.uri("/stations/{stationId}/observations/latest", stationId)
				.retrieve()
				.body(JsonNode.class);
	}

	public JsonNode getZoneForecast(String type, String zoneId) {
		return weatherRestClient.get()
				.uri("/zones/{type}/{zoneId}/forecast", type, zoneId)
				.retrieve()
				.body(JsonNode.class);
	}

}
