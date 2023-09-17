package com.logicfreaks.challengeforecastservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * File:           Page.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model.pagination
 */
public class Page {

	private int page;
	@JsonProperty("page_size")
	private int pageSize;
	@JsonProperty("total_items")
	private int totalItems;
	@JsonProperty("page_count")
	private int pageCount;
	@JsonProperty("_embedded")
	private Embedded embedded;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Embedded getEmbedded() {
		return embedded;
	}

	public void setEmbedded(Embedded embedded) {
		this.embedded = embedded;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (!(object instanceof Page page1)) return false;
		return getPage() == page1.getPage() && getPageSize() == page1.getPageSize() && getTotalItems() == page1.getTotalItems() && getPageCount() == page1.getPageCount() && Objects.equals(getEmbedded(), page1.getEmbedded());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPage(), getPageSize(), getTotalItems(), getPageCount(), getEmbedded());
	}

	@Override
	public String
	toString() {
		return "Page{" +
				"page=" + page +
				", pageSize=" + pageSize +
				", totalItems=" + totalItems +
				", pageCount=" + pageCount +
				", embedded=" + embedded +
				'}';
	}
}
