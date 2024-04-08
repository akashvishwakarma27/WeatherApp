package com.WeatherApp.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService{

    private String apiKey = "2deb36eba6587498a63c170018923844";

    @Autowired
    private RestTemplate restTemplate;

    @Override
	public ResponseEntity<String> getForecastSummaryByLocationName(String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> sum = new HttpEntity<>(headers);

        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        try {
            return restTemplate.exchange(url, HttpMethod.GET, sum, String.class);
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error Weather API: " + e.getMessage());
        }
    }

    @Override
	public ResponseEntity<String> getHourlyForecastByLocationName(String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> hour = new HttpEntity<>(headers);

        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey;

        try {
            return restTemplate.exchange(url, HttpMethod.GET, hour, String.class);
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error Weather API: " + e.getMessage());
        }
    }

}
