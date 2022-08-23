package widget;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selectmenu {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");

		driver = new ChromeDriver();

		try {

			driver.get("https://jqueryui.com/");

			driver.findElement(By.linkText("Selectmenu")).click();

			driver.switchTo().frame(0);

//			driver.findElement(By.id("speed-button")).click();
//			customeWait(2);
//
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-5")));
//
//			driver.findElement(By.id("ui-id-5")).click();
//
			
			setElementAttribute("files");
			customeWait(2);
			
			WebElement selectFile = driver.findElement(By.id("files"));
			
			Select mySelect = new Select(selectFile);
			mySelect.selectByValue("somefile");
			
			customeWait(2);
			
			setElementAttribute("number");
			
			mySelect = new Select(driver.findElement(By.id("number")));
			mySelect.selectByVisibleText("10");
			
			customeWait(2);
			
			setElementAttribute("salutation");
			
			WebElement titleSelect = driver.findElement(By.id("salutation"));
			mySelect = new Select(titleSelect);
			mySelect.selectByIndex(3);
			
			customeWait(3);
			
			
			driver.switchTo().parentFrame();
			
			driver.findElement(By.linkText("Custom Rendering")).click();
			
			customeWait(2);
			

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

	static void customeWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void setElementAttribute(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').setAttribute('style', 'display: block;')");
	}

}
