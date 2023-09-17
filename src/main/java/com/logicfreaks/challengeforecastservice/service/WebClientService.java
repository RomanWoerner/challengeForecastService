package com.logicfreaks.challengeforecastservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * File:           WebClientService.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service.impl
 */
@Service
@Slf4j
public class WebClientService {

	private static final String ERROR_OCCURRENCE_MESSAGE = "Error occurrence: ";
	private final WebClient webClient;

	public WebClientService(WebClient webClient) {
		this.webClient = webClient;
	}

	public <T> Mono<T> get(String path, Consumer<HttpHeaders> httpHeadersConsumer, Class<T> clazz) {

		return webClient.get()
				.uri(path)
				.headers(httpHeadersConsumer)
				.retrieve()
				.onStatus(HttpStatusCode::is5xxServerError, response ->
						response.bodyToMono(String.class)
								.flatMap(errorMessage -> {
									log.error(ERROR_OCCURRENCE_MESSAGE + errorMessage);
									return Mono.error(new ErrorResponseException(response.statusCode()));
								})
				)
				.onStatus(HttpStatusCode::is4xxClientError, response ->
						response.bodyToMono(String.class)
								.flatMap(errorMessage -> {
									log.error(ERROR_OCCURRENCE_MESSAGE + errorMessage);
									return Mono.error(new ErrorResponseException(response.statusCode()));
								})
				)
				.bodyToMono(clazz)
				.doOnError(error -> log.error(ERROR_OCCURRENCE_MESSAGE + error.getMessage()));
	}

	public <T> Mono<T> post(String path, Object object, Consumer<HttpHeaders> httpHeadersConsumer, Class<T> clazz) {

		return webClient.post()
				.uri(path)
				.headers(httpHeadersConsumer)
				.bodyValue(object)
				.retrieve()
				.onStatus(HttpStatusCode::is5xxServerError, response ->
						response.bodyToMono(String.class)
								.flatMap(errorMessage -> {
									log.error(ERROR_OCCURRENCE_MESSAGE + errorMessage);
									return Mono.error(new ErrorResponseException(response.statusCode()));
								})
				)
				.onStatus(HttpStatusCode::is4xxClientError, response ->
						response.bodyToMono(String.class)
								.flatMap(errorMessage -> {
									log.error(ERROR_OCCURRENCE_MESSAGE + errorMessage);
									return Mono.error(new ErrorResponseException(response.statusCode()));
								})
				)
				.bodyToMono(clazz)
				.doOnError(error -> log.error(ERROR_OCCURRENCE_MESSAGE + error.getMessage()));
	}
}
