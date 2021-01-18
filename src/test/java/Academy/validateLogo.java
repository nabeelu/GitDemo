package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
 
public class validateLogo extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(validateLogo.class.getName());

	@BeforeTest
	public void initalize1() throws IOException {

		driver = initializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void logoValidation() throws IOException {

		
		
		log.info("Navigated to home page");
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getLogo().isDisplayed());
		log.info("Logo successfully displayed");
	}

	@Test
	public void gitbranchTest() {
		
		System.out.println("testing git branch");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
