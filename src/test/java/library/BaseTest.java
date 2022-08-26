package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	
	public WebDriver driver;
	public UtilityLibrary lib;
	
	
	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
//		driver.manage().window().maximize();
		lib = new UtilityLibrary(driver);

	}
	
	
	@AfterMethod
	public void endTest() {
		lib.customeWait(3);
		driver.quit();
	}
	
	
}
