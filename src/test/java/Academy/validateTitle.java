package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
 

public class validateTitle extends base {
	LandingPage l;
	public   WebDriver driver;
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());
	@BeforeTest
	public void initalize1() throws IOException {

		driver = initializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
	}

	@Test
	public void titleValidation() throws IOException {
	
		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.error("Title validation failed");

	}
	

	@Test
	public void headerValidation() throws IOException {
	  
		//l = new LandingPage(driver);
		
		System.out.println(l.getHeader().getText());
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING\r\n" + 
				"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");

 

		
	
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
