package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.forgotPasswordPage;
import resources.base;

 
public class HomePage extends base {
	//testing Git hub
	//made some more changes
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
			
	@BeforeTest
	public void initalize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is intialized");
	
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		LandingPage l = new LandingPage(driver);
		//l.getLogin().click();
		LoginPage lp = l.getLogin();
		//LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getSubmit().click();
		forgotPasswordPage fp =lp.forgotPassword();
		fp.getEmail().sendKeys("abc@gmail.com");
		fp.sendInstructions().click();
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestrictedusesr@gmail.com";
		data[0][1] = "123";
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "345";
		return data;

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
