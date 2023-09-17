package com.logicfreaks.challengeforecastservice.controller;

import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.service.ForecastService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File:           ForecastController.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.controller
 */
@RestController
@RequestMapping("/forecast")
public class ForecastController {

	private final ForecastService forecastService;

	public ForecastController(ForecastService forecastService) {
		this.forecastService = forecastService;
	}

	@GetMapping(value = "/getForecast", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Forecast> getForecast() {
		return ResponseEntity.ok(forecastService.getForecast());
	}

}
