package widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.BaseTest;

public class CheckboxRadio extends BaseTest{

	

	
	
	
	@Test
	public void radioGroup() {
		

		
		clickElement(By.linkText("Radio Group"));
		driver.switchTo().frame(0);
		clickElement(By.xpath("//label[text()='Paris']"));
		
	}
	
	
	
	@Test
	public void noIconTest() {

		driver.findElement(By.linkText("No Icons")).click();

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		clickElement(By.xpath("//label[text()='New York']"));
		
		List<WebElement> hotelRate = driver.findElements(By.xpath("//*[text()='Hotel Ratings: ']/..//label"));
		
		for(WebElement rate: hotelRate) {
			clickElement(rate);
		}
		
		List<WebElement> bedType = driver.findElements(By.xpath("//*[text()='Bed Type: ']/..//label"));
		
		for(WebElement bed: bedType) {
			clickElement(bed);
		}		

	}

	@Test
	public void defaultTest() {

		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//label[text()='New York']")).click();

		driver.findElement(By.xpath("//label[@for='checkbox-1']/span[contains(@class,'checkboxradio')][1]")).click();

		driver.findElement(By.xpath("//label[text()='r']")).click();

		customeWait(2);

		driver.findElement(By.xpath("//label[@for='checkbox-nested-2']/span[contains(@class,'checkboxradio')][1]"))
				.click();

		WebElement checkBox_1Bed = driver.findElement(By.xpath("//*[@for='checkbox-nested-4']"));
		checkBox_1Bed.click();

		customeWait(2);

		boolean isChecked = checkBox_1Bed.isSelected();

		System.out.println("the value is: " + isChecked);

	}

	public void clickElement(By locator) {
		customeWait(1);
		driver.findElement(locator).click();
	}
	
	public void clickElement(WebElement elem) {
		customeWait(1);
		elem.click();
	}

	static void customeWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
