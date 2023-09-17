package com.logicfreaks.challengeforecastservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

/**
 * File:           Invoice.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
public class Invoice {
	private int id;
	@JsonProperty("billing_number")
	private int invoiceNumber;
	@JsonProperty("receipt_date")
	private Date invoiceDate;
	@JsonProperty("netto")
	private double nettoAmount;
	@JsonProperty("brutto")
	private double bruttoAmount;
	@JsonProperty("type")
	private String status;

	private double balance;
	@JsonProperty("Debitor")
	private Debitor debitor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getNettoAmount() {
		return nettoAmount;
	}

	public void setNettoAmount(double nettoAmount) {
		this.nettoAmount = nettoAmount;
	}

	public double getBruttoAmount() {
		return bruttoAmount;
	}

	public void setBruttoAmount(double bruttoAmount) {
		this.bruttoAmount = bruttoAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Debitor getDebitor() {
		return debitor;
	}

	public void setDebitor(Debitor debitor) {
		this.debitor = debitor;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (!(object instanceof Invoice invoice)) return false;
		return getId() == invoice.getId() && getInvoiceNumber() == invoice.getInvoiceNumber() && Double.compare(invoice.getNettoAmount(), getNettoAmount()) == 0 && Double.compare(invoice.getBruttoAmount(), getBruttoAmount()) == 0 && Double.compare(invoice.getBalance(), getBalance()) == 0 && Objects.equals(getInvoiceDate(), invoice.getInvoiceDate()) && Objects.equals(getStatus(), invoice.getStatus()) && Objects.equals(getDebitor(), invoice.getDebitor());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getInvoiceNumber(), getInvoiceDate(), getNettoAmount(), getBruttoAmount(), getStatus(), getBalance(), getDebitor());
	}

	@Override
	public String toString() {
		return "Invoice{" +
				"id=" + id +
				", invoiceNumber=" + invoiceNumber +
				", invoiceDate=" + invoiceDate +
				", nettoAmount=" + nettoAmount +
				", bruttoAmount=" + bruttoAmount +
				", status='" + status + '\'' +
				", balance=" + balance +
				", debitor=" + debitor +
				'}';
	}
}

