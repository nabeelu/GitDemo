package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		// FileInputStream fis = new FileInputStream(//
		// "C:\\Users\\Nabeel\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver",
			// "F:\\Selenium jars and drivers\\Selenium Browser drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "F:\\Selenium jars and drivers\\Selenium Browser drivers\\geckodriver.exe");
			 */
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			// code for Ie
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;

	}

}
