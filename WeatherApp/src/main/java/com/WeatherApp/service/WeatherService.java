package com.WeatherApp.service;

import org.springframework.http.ResponseEntity;

public interface WeatherService {
	
	public ResponseEntity<String> getForecastSummaryByLocationName(String city);
	public ResponseEntity<String> getHourlyForecastByLocationName(String city);

}
