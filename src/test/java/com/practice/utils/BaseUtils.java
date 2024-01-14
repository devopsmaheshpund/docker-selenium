package com.practice.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtils {
	protected ChromeDriver driver;

	@BeforeTest
	public void setupDriver() {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","/app/bin/chromedriver");
//		DesiredCapabilities dc = null;
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--window-size=1920, 1080");
	    options.addArguments("--allow-insecure-localhost");
	    options.addArguments("--headless=new");
	    options.addArguments("--disable-gpu");
	    options.addArguments("--no-sandbox");
	    DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
	    caps.setCapability("acceptInsecureCerts", caps);
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
