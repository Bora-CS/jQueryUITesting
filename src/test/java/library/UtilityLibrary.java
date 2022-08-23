package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityLibrary {
	
	WebDriver driver;
	
	public UtilityLibrary(WebDriver passedDriver) {
		
		driver = passedDriver;
		
	}
	
	
	
	public void clickElement(By locator) {
		customeWait(1);
		driver.findElement(locator).click();
	}
	
	public void clickElement(WebElement elem) {
		customeWait(1);
		elem.click();
	}
	 
	
	public String getText(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}
	
	
	
	
	public void enterIntoFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	
	
	
	public void customeWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

}
