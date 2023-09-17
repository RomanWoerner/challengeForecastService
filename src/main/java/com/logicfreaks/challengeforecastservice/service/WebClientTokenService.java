package com.logicfreaks.challengeforecastservice.service;

import io.micrometer.common.util.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * File:           WebClientTokenService.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service.impl
 */
@Service
@EnableScheduling
public class WebClientTokenService {

	private final WebClientService webClientService;
	@Value("${billing.api.authenticationUrl}")
	private String url;
	@Value("${billing.api.grantType}")
	private String grantType;
	@Value("${billing.api.clientId}")
	private String clientId;
	@Value("${billing.api.clientSecret}")
	private String clientSecret;
	@Value("${billing.api.user}")
	private String user;
	@Value("${billing.api.password}")
	private String password;
	private String token;

	public WebClientTokenService(WebClientService webClientService) {
		this.webClientService = webClientService;
	}


	/**
	 * Every 10 Minutes, a token will be requested automatically by the Scheduler.
	 */

	@Scheduled(fixedDelay = 600000)
	public void updateToken() {
		String tokenString =
				"&grant_type=" + grantType +
						"&client_secret=" + clientSecret +
						"&client_id=" + clientId +
						"&password=" + password +
						"&username=" + user;

		Consumer<HttpHeaders> httpHeadersConsumer = httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		webClientService.post(url, tokenString, httpHeadersConsumer, String.class).subscribe(jsonString -> {
			JSONObject jsonObject = new JSONObject(jsonString);

			if (jsonObject.has("access_token")) {
				token = "Bearer " + jsonObject.getString("access_token");
			} else {
				token = null;
			}
		});


	}

	/**
	 * Returns the current token and should be called by services that require the current bearer token.
	 */
	public String getToken() {

		if (StringUtils.isBlank(token)) {
			throw new NoSuchElementException("No token stored in WebClientTokenService. \nUrl: " + url);
		}
		return token;
	}
}

