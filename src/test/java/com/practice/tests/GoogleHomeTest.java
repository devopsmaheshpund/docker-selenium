package com.practice.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.practice.pages.GoogleHomePage;
import com.practice.utils.BaseUtils;

public class GoogleHomeTest extends BaseUtils{

	GoogleHomePage gp=new GoogleHomePage(driver);
	@Test
	public void googleSearchTest() throws InterruptedException
	{
		gp=new GoogleHomePage(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		gp.getSearchBox().sendKeys("Google Search Box");
		Thread.sleep(1000);
	}
}
