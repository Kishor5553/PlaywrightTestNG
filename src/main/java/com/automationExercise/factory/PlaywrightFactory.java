package com.automationExercise.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	
	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}
	public static Browser getBrowser() {
		return tlBrowser.get();
	}
	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}
	public static Page getPage() {
		return tlPage.get();
	}
	
	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is= "+browserName);
		
//		playwright= Playwright.create();
		tlPlaywright.set(Playwright.create());
		
		switch (browserName.toLowerCase()) {
		case "chromium": 
//			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome" :
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
					.setChannel("chrome")));
			break;
		case "msedge" :
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
					.setChannel("msedge")));
			break;
		case "firefox" :
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari" :
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		default:
			System.out.println("Please pass the valid browser name...!");
			break;
		}
		
		tlBrowserContext.set(getBrowser().newContext());
		tlPage.set(getBrowserContext().newPage());
		getPage().navigate(prop.getProperty("url"));
		
		
//		browserContext = browser.newContext();
//		page = browserContext.newPage();
//		page.navigate(prop.getProperty("url"));
		
		return getPage();
	}
	
	public Properties init_prop() {
		try {
			FileInputStream fp= new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fp);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshotOfFailureTests/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
	
}
