package com.automationExercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationExercise.base.BaseTest;
import com.automationExercise.constants.AppConstants;

public class LoginTest extends BaseTest {
	
	
	@Test(priority = 2)
	public void Login() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.enterUserEmail(prop.getProperty("username"));
		loginPage.enterUserPassword(prop.getProperty("password"));
		loginPage.clickOnLoginButton();
		Assert.assertTrue(homePage.verifyDeleteAccountButtonDisplayed());
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		loginPage = homePage.clickOnLoginLink();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	

}
