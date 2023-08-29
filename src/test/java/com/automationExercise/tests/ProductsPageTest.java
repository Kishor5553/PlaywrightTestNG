package com.automationExercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationExercise.base.BaseTest;

public class ProductsPageTest extends BaseTest {
	
	@Test
	public void addToCartProduct() throws InterruptedException {
		productsPage = homePage.clickOnProductsButton();
		productsPage.selectProductToAddToCart();
		Assert.assertTrue(productsPage.isDisplayedContinueShoppingButton());
	}
	

}
