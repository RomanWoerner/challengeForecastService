package com.logicfreaks.challengeforecastservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * File:           Embedded.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
public class Embedded {

	@JsonProperty("list_debits")
	private List<Invoice> invoiceList;

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Embedded embedded)) return false;
		return Objects.equals(getInvoiceList(), embedded.getInvoiceList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getInvoiceList());
	}

	@Override
	public String toString() {
		return "Embedded{" +
				"invoiceList=" + invoiceList +
				'}';
	}
}
