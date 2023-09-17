package com.logicfreaks.challengeforecastservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * File:           Debitor.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
public class Debitor {

	private int id;
	private String name;
	private String location;
	private String country;
	private String postcode;
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Debitor debitor)) return false;
		return getId() == debitor.getId() && Objects.equals(getName(), debitor.getName()) && Objects.equals(getLocation(), debitor.getLocation()) && Objects.equals(getCountry(), debitor.getCountry()) && Objects.equals(getPostcode(), debitor.getPostcode()) && Objects.equals(getPhoneNumber(), debitor.getPhoneNumber()) && Objects.equals(getEmail(), debitor.getEmail());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getLocation(), getCountry(), getPostcode(), getPhoneNumber(), getEmail());
	}

	@Override
	public String toString() {
		return "Debitor{" +
				"id=" + id +
				", name='" + name + '\'' +
				", location='" + location + '\'' +
				", country='" + country + '\'' +
				", postcode='" + postcode + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
