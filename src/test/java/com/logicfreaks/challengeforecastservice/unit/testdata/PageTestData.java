package com.logicfreaks.challengeforecastservice.unit.testdata;


import com.logicfreaks.challengeforecastservice.model.Page;

/**
 * File:           PageTestData.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.testdata
 */
public class PageTestData {

	public static Page setUpPageTestData() {
		Page page = new Page();

		page.setPageCount(2);
		page.setPage(1);
		page.setEmbedded(EmbeddedTestData.setUpEmbeddedTestData());
		page.setTotalItems(1);
		page.setPageSize(1);

		return page;
	}
}
