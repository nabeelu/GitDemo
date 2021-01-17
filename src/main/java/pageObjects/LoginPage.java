package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// By email = By.id("user_email");

	 @FindBy(id = "user_email")
	 private  WebElement email;

	 @FindBy(xpath = "//input[@id='user_password']")
	private WebElement password;

	@FindBy(css = "[value='Log In']")
	private WebElement login;

	
	@FindBy(css = "[href*='password/new']")
	private WebElement forgotPassword;
	
	public WebElement getEmail() {

		return email;
	}

	public WebElement getPassword() {

		return password;
	}

	public WebElement getSubmit() {

		return login;
	}
	
	public forgotPasswordPage forgotPassword() {

		 forgotPassword.click();
		 return new forgotPasswordPage(driver);
	}

}
