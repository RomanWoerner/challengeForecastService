package com.logicfreaks.challengeforecastservice.model;

import java.util.Objects;

/**
 * File:           Forecast.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
public class Forecast {

	private final double brutto;
	private final double netto;
	private final int timeFrame;
	private final String timeFrameUnit;

	private Forecast(ForecastBuilder forecastBuilder) {
		this.brutto = forecastBuilder.brutto;
		this.netto = forecastBuilder.netto;
		this.timeFrame = forecastBuilder.timeFrame;
		this.timeFrameUnit = forecastBuilder.timeFrameUnit;
	}

	public double getBrutto() {
		return brutto;
	}

	public double getNetto() {
		return netto;
	}

	public int getTimeFrame() {
		return timeFrame;
	}

	public String getTimeFrameUnit() {
		return timeFrameUnit;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (!(object instanceof Forecast forecast)) return false;
		return Double.compare(forecast.brutto, brutto) == 0 && Double.compare(forecast.netto, netto) == 0 && timeFrame == forecast.timeFrame && Objects.equals(timeFrameUnit, forecast.timeFrameUnit);
	}

	@Override
	public int hashCode() {
		return Objects.hash(brutto, netto, timeFrame, timeFrameUnit);
	}

	@Override
	public String toString() {
		return "Forecast{" +
				"brutto=" + brutto +
				", netto=" + netto +
				", timeFrame=" + timeFrame +
				", timeFrameUnit='" + timeFrameUnit + '\'' +
				'}';
	}

	public static class ForecastBuilder {

		private final int timeFrame;
		private double brutto;
		private double netto;
		private String timeFrameUnit;

		public ForecastBuilder(int timeFrame) {
			this.timeFrame = timeFrame;
		}

		public ForecastBuilder setBrutto(double brutto) {
			this.brutto = brutto;
			return this;
		}

		public ForecastBuilder setNetto(double netto) {
			this.netto = netto;
			return this;
		}

		public ForecastBuilder setTimeFrameUnit(String timeFrameUnit) {
			this.timeFrameUnit = timeFrameUnit;
			return this;
		}

		public Forecast build() {
			return new Forecast(this);
		}
	}
}
