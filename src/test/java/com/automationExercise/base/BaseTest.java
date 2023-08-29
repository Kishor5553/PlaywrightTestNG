package com.automationExercise.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automatioExercise.pages.HomePage;
import com.automatioExercise.pages.LoginPage;
import com.automatioExercise.pages.ProductsPage;
import com.automationExercise.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;

public class BaseTest {
	
	PlaywrightFactory playwrightFactory;
	Page page;
	protected Properties prop;
	
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected ProductsPage productsPage;

	
	@BeforeTest
	public void setup() {
		playwrightFactory = new PlaywrightFactory();
		prop = playwrightFactory.init_prop();
		page = playwrightFactory.initBrowser(prop);
		homePage= new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
