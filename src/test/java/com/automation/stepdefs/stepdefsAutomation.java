package com.automation.stepdefs;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.core.DriverFactoryWeb;

//import com.automation.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefsAutomation {
	
	 private static final Logger logger = LogManager.getLogger(stepdefsAutomation.class);
	 private static final CharSequence Product_Name = null;
	 WebDriver driver;
	    String base_url = "https://automationpractice.com";
	    int implicit_wait_timeout_in_sec = 20;
	    Scenario scn;	
	    
 @Before
 public void setUp(Scenario scn) throws Exception
 {    
	 this.scn = scn;
	 String browserName = DriverFactoryWeb.getBrowserName();
     driver = DriverFactoryWeb.getWebDriverForBrowser(browserName);
     logger.info("Browser invoked.");

 }
 @After(order=1)
 public void cleanup() {
	 DriverFactoryWeb.quitDriver();
 }
 @After(order=2)
 public void takeScreenShot(Scenario a)
 {
	 if(!a.isFailed())
	 {
		 TakesScreenshot scrnShot =(TakesScreenshot)driver;
		 byte[]data = scrnShot.getScreenshotAs(OutputType.BYTES);
		 scn.attach(data,"image/png","Failed Step Name:" + a.getName());
		 }else {
			 scn.log("Test case is passed,No Screen shot is captured");
		 }
	 
 }

@Given("User validate Application URL")
public void user_validate_application_url() {
	driver.get(base_url);
    String titleofpage = driver.getTitle();
    scn.log("Page Title is="+ titleofpage);

}

@When("User open URL and validate")
public void user_open_url_and_validate() {
	String expected = "My Store";
    String actual = driver.getTitle();
    Assert.assertEquals("Page Title Validation",expected,actual);
     scn.log("Page Title is validation succesfull"+ actual);

}

@Then("User redirected to index page")
public void user_redirected_to_index_page() {
	scn.log("After Validation user page will open");

   
}

@And ("User open index page")
public void User_open_index_page() {
	String indexPageURL = driver.getCurrentUrl();
	scn.log("indexPageURL");
	
}

@When("The Application logo is displayed")
public void the_application_logo_is_displayed() {
	 boolean logoPresent = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).isDisplayed();
	    Assert.assertTrue(logoPresent);
	    scn.log("Logo Displayed");
    
}

@Then("The Application logo width is {int} and height is {int}")
public void the_application_logo_width_is_and_height_is(Integer int1, Integer int2) {
	int width = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getSize().getWidth();
	int height = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getSize().getHeight();
	System.out.println("Width:"+width+"Height:"+height);
	Assert.assertEquals(width,350);
	Assert.assertEquals(height,99);
}


@Then("Validate main product categories count should be {int}")
public void validate_main_product_categories_count_should_be(Integer int1) {
	System.out.println("inside validate_main_product_categories_count_should_be ");  
}
@Then("Text the displayed {int} categories is shown below")
public void text_the_displayed_categories_is_shown_below(Integer int1) {
	System.out.println("inside validate_main_product_categories_count_should_be  ");
    

}
@When("User Search for product {string}")
public void user_search_for_product(String Product_Name) {
	WebElement searchbox=driver.findElement(By.xpath("//input [@class='search_query form-control ac_input']"));
	searchbox.sendKeys(Product_Name);
	
	WebElement searchbtn=driver.findElement(By.xpath("//button [@name='submit_search']"));
	searchbtn.click();
	scn.log("Displayed search product information");	
   
}
@Then("The search result page is displayed")
public void the_search_result_page_is_displayed() {
	String expectedtitle="Search - My Store";
	String actualtitle = driver.getTitle();
	Assert.assertEquals("Page validation",expectedtitle,actualtitle);
	logger.info("Page validation");
   

}

@When("User click on footer link")
public void user_click_on_footer_link_and_validate()
    {
	WebElement footerlink = driver.findElement(By.xpath("//li[@class='twitter']/a[@target='_blank']"));
	footerlink.click();
	logger.info("footerlink will open");
	if(driver.getCurrentUrl().equalsIgnoreCase("seleniumfrmwrk"))
		System.out.println("Test passed");
	else
	    System.out.println("Test failed");
    }

@Then("Twitter account will open in new tab")
public void twitter_account_will_open_in_a_tab()
    {
	
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
	String original= it.next();
	String twitterAC= it.next();
	driver.switchTo().window(twitterAC);
	
	WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
	WebElement accName=driver.findElement(By.xpath("(//span[contains(text(),'Selenium Framework')])[2]"));
			Assert.assertEquals("Account Name",true,accName.isDisplayed());
			
			driver.switchTo().window(original);

	}




}








