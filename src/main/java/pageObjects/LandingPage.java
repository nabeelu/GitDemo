package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By signin = By.cssSelector("[href*='sign_in']");
	private By text = By.xpath("//*[@class='text-center']/h2");
	private By logo = By.cssSelector("[class='img-responsive logo']");
	private By header = By.cssSelector("[class*='video-banner']");
	

	public LoginPage getLogin() {

		 driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	/*public WebElement getLogin() {

		return driver.findElement(signin);
	}
*/
	public WebElement getTitle() {

		return driver.findElement(text);
	}
	
	public WebElement getLogo() {

		return driver.findElement(logo);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}


}
