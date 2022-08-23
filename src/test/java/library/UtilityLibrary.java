package library;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	public void backToDefaultFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	
	
	
	/**Select Functionality**/
	
	public void selectFunctionByValue(By locator, String value) {
		
		Select mySelect = new Select(driver.findElement(locator));
		mySelect.selectByValue(value);
		
	}
	
	public void selectFunctionByVisibleText(By locator, String text) {
		
		Select mySelect = new Select(driver.findElement(locator));
		mySelect.selectByVisibleText(text);
		
	}
	
	public void selectFunctionByIndex(By locator, int index) {
		
		Select mySelect = new Select(driver.findElement(locator));
		mySelect.selectByIndex(index);
		
	}
	
	
	
	
	
	
	
	public void setElementAttribute(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').setAttribute('style', 'display: block;')");
	}
	
	
	
	
	
	
	
	
	
	public void customeWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

}
