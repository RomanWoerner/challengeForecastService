package com.logicfreaks.challengeforecastservice.unit.service;

import com.logicfreaks.challengeforecastservice.service.WebClientService;
import com.logicfreaks.challengeforecastservice.service.WebClientTokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * File:           WebClientTokenServicetest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service
 */
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class WebClientTokenServiceTest {

	@Mock
	private WebClientService webClientService;
	@InjectMocks
	private WebClientTokenService webClientTokenService;

	@Test
	void testUpdateToken_shouldCall_webClientPost() {

		assertThrows(NullPointerException.class, () -> {
			webClientTokenService.updateToken();
		});


		verify(webClientService, times(1)).post(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
	}

	@Test
	void testGetToken_shouldReturn_Token() {

		String token = "BAERER = asdkjfhauhg";
		ReflectionTestUtils.setField(webClientTokenService, "token", token);

		String resultToken = webClientTokenService.getToken();

		assertEquals(resultToken, token);

	}

	@Test
	void testUpdateToken_shouldSet_tokenToResponse() {

		//Arrange
		String fakeAccessToken = "djfewukhfaifli232fu2wifi234th928fh";
		Mono<String> fakeMono = Mono.just("{\"access_token\": \"" + fakeAccessToken + "\"}");

		//Configure
		doReturn(fakeMono).when(webClientService).post(any(), any(), any(), any());
		ReflectionTestUtils.setField(webClientTokenService, "url", "url");
		ReflectionTestUtils.setField(webClientTokenService, "user", "user");
		ReflectionTestUtils.setField(webClientTokenService, "password", "password");

		//Act
		webClientTokenService.updateToken();

		//Assert
		Assertions.assertEquals(webClientTokenService.getToken(), "Bearer " + fakeAccessToken);
	}

	@Test
	void testUpdateToken_shouldThrow_noTokenException() {

		//Arrange
		Mono<String> fakeMono = Mono.just("{\"noToken\": \"noToken\"}");

		//Configure
		doReturn(fakeMono).when(webClientService).post(any(), any(), any(), any());
		ReflectionTestUtils.setField(webClientTokenService, "url", "url");
		ReflectionTestUtils.setField(webClientTokenService, "user", "user");
		ReflectionTestUtils.setField(webClientTokenService, "password", "password");

		//Act
		//webClientTokenService.updateToken();

		//Assert
		Assertions.assertThrows(Exception.class, () -> webClientTokenService.getToken());
	}
}