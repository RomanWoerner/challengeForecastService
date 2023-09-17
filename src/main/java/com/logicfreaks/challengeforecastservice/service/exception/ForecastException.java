package com.logicfreaks.challengeforecastservice.service.exception;

/**
 * File:           ForecastException.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service.exception
 */
public class ForecastException extends RuntimeException {
	public ForecastException(String message, Exception ex) {
		super(message + "\r\n" + ex.getMessage());
	}
}
