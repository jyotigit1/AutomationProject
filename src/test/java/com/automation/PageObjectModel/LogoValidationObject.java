package com.automation.PageObjectModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoValidationObject 
 {
  private static final Logger Logger = LogManager.getLogger(LogoValidationObject.class);
	WebDriver driver;
	private By search_logo = By.xpath("// img[@class='img-responsive']");
	
	public LogoValidationObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void logovisibility()
	{
		WebElement logo =driver.findElement(search_logo);
		Actions act =new Actions(driver); 
		act.moveToElement(logo).build().perform();
		Logger.info("Logo Displayed");
	}
	public void width_height()
	{
		int width = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getSize().getWidth();
		int height = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getSize().getHeight();
		System.out.println("Width:"+width+"Height:"+height);
		Assert.assertEquals(width,350);
		Assert.assertEquals(height,99);

	}
}
