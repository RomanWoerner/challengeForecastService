package com.logicfreaks.challengeforecastservice.unit.config;

import com.logicfreaks.challengeforecastservice.config.WebClientConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * File:           WebClientConfigtest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.config
 */
@RunWith(MockitoJUnitRunner.class)
class WebClientConfigTest {


	@Test
	void testWebClientConfig_shouldReturn_wellConfiguredTemplate() {

		//Arrange
		WebClientConfig webClientConfig = new WebClientConfig();
		//Act
		WebClient webClient = webClientConfig.webClient();

		//Assert
		Assertions.assertNotNull(webClient);
	}
}