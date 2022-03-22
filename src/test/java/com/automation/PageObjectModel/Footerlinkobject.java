package com.automation.PageObjectModel;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;

public class Footerlinkobject {
	private static final Logger logger = LogManager.getLogger(Footerlinkobject.class);
	private static final By Account_Name = null;
	WebDriver driver;
	
	public void UrlValidtionObject (WebDriver driver)
	{
		this.driver = driver;

	}
	public void user_click_on_footer_link_and_validate() throws InterruptedException
    {
	Thread.sleep(2000);
	By footerlink = null;
	driver.findElement(footerlink).click();
	logger.info("footerlink will open");
	System.out.println("The current url -"+driver.getCurrentUrl() );
	System.out.println("The title is -"+driver.getTitle() );
	
	if(driver.getCurrentUrl().equalsIgnoreCase("My Store"))
		System.out.println("Test passed");
	else
	    System.out.println("Test failed");
    }


public void twitter_account_will_open_in_a_tab()
    {
	
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
	String original= it.next();
	String twitterAC= it.next();
	driver.switchTo().window(twitterAC);
	
	WebDriverWait webDriverWait1 = new WebDriverWait(driver,10);
    Assert.assertEquals("Account Name",true,driver.findElement(Account_Name).isDisplayed());
		
    WebDriverWait webDriverWait2 = new WebDriverWait(driver,10);
    
    logger.info("Twitteraccount will open name as - Selenium Framework");
    


    }

}
