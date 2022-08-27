package dateDriven;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import library.BaseTest;
import library.UtilityLibrary;
import pageLocators.costcoLocator;

public class Costco extends BaseTest{

	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.costco.com/");
		driver.manage().window().maximize();
		lib = new UtilityLibrary(driver);
	}
	
	public void test() {
		
		lib.enterText(costcoLocator.searchBox, "text");
		lib.enterText(costcoLocator.searchBox,"" + Keys.ENTER);
		
		
		
	}
}
