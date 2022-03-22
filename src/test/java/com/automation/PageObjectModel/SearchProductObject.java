package com.automation.PageObjectModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class SearchProductObject {
	
	private static final Logger Logger = LogManager.getLogger(SearchProductObject.class);
	WebDriver driver;
	private By searchbox = By.xpath("//input[@class='search-query form-control ac_input']");
	private By searchbtn = By.xpath("// img[@name='submit_search']");
	
	public SearchProductObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchproduct(String product_name)
	{
		driver.findElement(searchbox).sendKeys(product_name);
		driver.findElement(searchbtn).click();
		Logger.info("Search product information Displayed");
	

}
	public void productdiscriptionpage(String expected)
	{
		String actualtitle = driver.getTitle();
		Assert.assertEquals("Page validation",expected ,actualtitle);
		Logger.info("page validate");
	}
}