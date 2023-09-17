package com.logicfreaks.challengeforecastservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * File:           WebClientConfig.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.config
 */
@Configuration
public class WebClientConfig {

	/**
	 * Spring will instantiate "webClient" as Singleton-Bean
	 */
	@Bean
	public WebClient webClient() {
		return WebClient.create();
	}
}
