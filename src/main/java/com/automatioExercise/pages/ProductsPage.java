package com.automatioExercise.pages;

import com.microsoft.playwright.Page;

public class ProductsPage {
	Page page;
	
	private String  productAddToCartBtn = "//a[contains(text(),'Add to cart')][@data-product-id='1']";
	private String continueShoppingButton = "//button[text()='Continue Shopping']";
	
	public ProductsPage(Page page) {
		this.page = page;
	}
	public String getProductsPageTitle() {
		String productsPageTitle = page.title();
		System.out.println("Products Page Title = "+productsPageTitle);
		return productsPageTitle;
	}
	
	public void selectProductToAddToCart() {
		page.locator(productAddToCartBtn).first().hover();
//		String productAddToCart = String.format(productAddToCartBtn, productName);
		page.locator(productAddToCartBtn).first().click();
	
	}
	
	public boolean isDisplayedContinueShoppingButton(){
		return page.isVisible(continueShoppingButton);
	}
	
}
