package com.automatioExercise.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;
	
	public HomePage(Page page) {
		this.page=page;
	}	
	
	private String loginLink="a[href='/login']";
	private String deleteAccountBtn="a[href='/delete_account']";
	private String productsBtn = "a[href='/products']";
	
	
	public LoginPage clickOnLoginLink() {
		page.click(loginLink);
		return new LoginPage(page);
	}
	public boolean verifyDeleteAccountButtonDisplayed() {
		return page.isVisible(deleteAccountBtn);
	}
	
	public ProductsPage clickOnProductsButton() {
		page.click(productsBtn);
		return new ProductsPage(page);
	}
	public String getHomePageTitle() {
		String homePageTitle = page.title();
		System.out.println("Home Page title is = "+homePageTitle);
		return homePageTitle;
	}

	
	
	
}
