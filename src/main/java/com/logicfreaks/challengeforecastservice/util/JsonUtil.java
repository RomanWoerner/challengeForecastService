package com.logicfreaks.challengeforecastservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;

/**
 * File:           JsonUtil.java
 * Version:        Revision: 0.1
 * Last changed:   14.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
public class JsonUtil {


	/**
	 * A private constructor is used to hide the public constructor since method calls are static.
	 */
	private JsonUtil() {

	}

	/**
	 * Prase Json String to object
	 *
	 * @param json  payload
	 * @param clazz
	 * @param <T>
	 * @return Object of given class.
	 * @throws JsonProcessingException
	 */
	public static <T> T parseJsonToObject(String json, Class<T> clazz) throws JsonProcessingException {

		if (StringUtils.isBlank(json) || clazz == null) {
			throw new IllegalArgumentException("Json String or clazz is null.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return objectMapper.readValue(json, clazz);
	}

	/**
	 * Parse Object into an Jason String.
	 *
	 * @param object
	 * @return JsonString
	 * @throws JsonProcessingException
	 */
	public static String paseObjectToJson(Object object) throws JsonProcessingException {

		if (object == null) throw new IllegalArgumentException("Given Object is null");

		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.writeValueAsString(object);
	}
}
