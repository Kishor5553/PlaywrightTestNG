package com.automationExercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationExercise.base.BaseTest;
import com.automationExercise.constants.AppConstants;

public class HomePageTest extends BaseTest {

	@Test(priority = 2)
	public void navigateToProducts() {
		productsPage = homePage.clickOnProductsButton();
		String productsPageTitle = productsPage.getProductsPageTitle();
		Assert.assertEquals(productsPageTitle, AppConstants.PRODUCT_PAGE_TITLE);
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String homePageTitle= homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, AppConstants.HOME_PAGE_TITLE);
	}
}
