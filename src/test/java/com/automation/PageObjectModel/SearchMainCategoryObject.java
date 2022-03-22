package com.automation.PageObjectModel;


import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.core.logging.Logger;
import junit.framework.Assert;

public class SearchMainCategoryObject {
	private static final org.apache.logging.log4j.Logger logger =  LogManager.getLogger(SearchMainCategoryObject.class);
	WebDriver Driver;
	public void userfindthemaincategory()
	{
	WebElement tab1=Driver.findElement(By.xpath("//a[@title='Women']")); 
	Assert.assertEquals("1st category",true,tab1.isDisplayed());
	
	WebElement tab2=Driver.findElement(By.xpath("(//a[@title=''])[2]")); 
	Assert.assertEquals("2nd category",true,tab2.isDisplayed());
	
	WebElement tab3=Driver.findElement(By.xpath("(//a[@title='T-Shirts'])[2]")); 
	Assert.assertEquals("3rd category",true,tab3.isDisplayed());
	}
	
	public SearchMainCategoryObject(WebDriver Driver)
	{
		this.Driver= Driver;
	}

public void MousehoverToMainCategory() throws InterruptedException
{
	Actions act = new Actions (Driver);
	By tab1 = null;
	act.moveToElement(Driver.findElement(tab1)).build().perform();
	Thread.sleep(2000);
	
	By tab2 = null;
	act.moveToElement(Driver.findElement(tab2)).build().perform();
	Thread.sleep(2000);
	
	By tab3 = null;
	act.moveToElement(Driver.findElement(tab3)).build().perform();
	Thread.sleep(2000);
	
	}




}

