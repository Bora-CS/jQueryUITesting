package interaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://jqueryui.com/");

			driver.findElement(By.linkText("Resizable")).click();

			driver.switchTo().frame(0);

			Actions boraAction = new Actions(driver);
			WebElement movePoint = driver.findElement(By.xpath("//*[@id='resizable']//*[contains(@class,'ui-icon')]"));

			boraAction.moveToElement(movePoint).clickAndHold().moveByOffset(100, 0).release().build().perform();

			customeWait(1);

			boraAction.dragAndDropBy(movePoint, -100, 100);

			customeWait(1);

			boraAction.clickAndHold(movePoint).moveByOffset(200, 100).build().perform();

			customeWait(1);

		} catch (Exception e) {
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

}
