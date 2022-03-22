package com.automation.PageObjectModel;

import org.apache.logging.log4j.EventLogger;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Loader;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;



public class UrlValidtionObject {
	private static final Logger logger = LogManager.getLogger(UrlValidtionObject.class);
	WebDriver driver;
	
	public void UrlValidtionObject (WebDriver driver)
	{
		this.driver = driver;

	}
	public void titlevalidation(String expected)
	{
		String actual = driver.getTitle();
		Assert.assertEquals("Page Title Validation",expected,actual );
		logger.info("Page Title Validation Successful" + actual);
	}
public void navigatetoIndexpage() {
	if(driver.getCurrentUrl().equalsIgnoreCase("https://automationpractice.com")) 
	{
		System.out.println("Test pass");
		logger.info("Test passed");
	}
	else
	{
		System.out.println("Test Failed");
		logger.info("Test Filed");
	}
	logger.info("The index page URL = "+ driver.getCurrentUrl());
}

}