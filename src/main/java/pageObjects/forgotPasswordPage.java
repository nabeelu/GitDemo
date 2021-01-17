package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class forgotPasswordPage {

	WebDriver driver;

	public forgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// By email = By.id("user_email");

	private @FindBy(css = "[type='email']")
	WebElement email;

	private @FindBy(css = "[value='Send Me Instruction']")
	WebElement sendInstructions;
 

	public WebElement getEmail() {

		return email;
	}

	public WebElement sendInstructions() {

		return sendInstructions;
	}

	 

}
