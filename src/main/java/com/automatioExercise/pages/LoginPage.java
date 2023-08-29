package com.automatioExercise.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	
	private String loginLink="a[href='/login']";
	private String loginEmailField="input[data-qa='login-email']";
	private String loginPassword="//input[@name='password']";
	private String loginBtn="button[data-qa='login-button']";
	
	public LoginPage(Page page) {
		this.page=page;
	}
	
	public String getLoginPageTitle() {
		String loginPageTitle = page.title();
		System.out.println("Login Page Title = "+loginPageTitle);
		return loginPageTitle;
	}
	public void clickOnLoginLink() {
		page.click(loginLink);
	}
	public void enterUserEmail(String userEmail) {
		page.fill(loginEmailField, userEmail);
	}
	
	public void enterUserPassword(String userPassword) {
		page.fill(loginPassword, userPassword);
	}
	
	public void clickOnLoginButton() {
		page.click(loginBtn);
	}
}
