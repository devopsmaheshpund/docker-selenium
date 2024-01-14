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
		System.setProperty("webdriver.chrome.driver","/app/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("window-size=1024,768"); // Bypass OS security model
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
