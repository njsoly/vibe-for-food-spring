package org.njsoly.tinker.da.vibeforfoodspring.weather;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	private final WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping("/points/{latitude},{longitude}")
	public JsonNode getPoint(@PathVariable String latitude, @PathVariable String longitude) {
		return weatherService.getPoint(latitude, longitude);
	}

	@GetMapping("/gridpoints/{wfo}/{x},{y}/forecast")
	public JsonNode getForecast(@PathVariable String wfo, @PathVariable int x, @PathVariable int y) {
		return weatherService.getForecast(wfo, x, y);
	}

	@GetMapping("/gridpoints/{wfo}/{x},{y}/forecast/hourly")
	public JsonNode getHourlyForecast(@PathVariable String wfo, @PathVariable int x, @PathVariable int y) {
		return weatherService.getHourlyForecast(wfo, x, y);
	}

	@GetMapping("/alerts/active")
	public JsonNode getActiveAlerts() {
		return weatherService.getActiveAlerts();
	}

	@GetMapping("/stations/{stationId}/observations/latest")
	public JsonNode getLatestObservation(@PathVariable String stationId) {
		return weatherService.getLatestObservation(stationId);
	}

	@GetMapping("/zones/{type}/{zoneId}/forecast")
	public JsonNode getZoneForecast(@PathVariable String type, @PathVariable String zoneId) {
		return weatherService.getZoneForecast(type, zoneId);
	}

}
