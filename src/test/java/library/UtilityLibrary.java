package library;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityLibrary {

	WebDriver driver;
	final boolean demo = false;

	public UtilityLibrary(WebDriver passedDriver) {

		driver = passedDriver;

	}

	public WebElement getElement(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		highLight(locator);
		return driver.findElement(locator);
	}

	public List<WebElement> getListOfElements(By locator) {
		return driver.findElements(locator);
	}

	public void clickElement(By locator) {
		customeWait(1);
		getElement(locator).click();
	}

	public void clickElement(WebElement elem) {
		customeWait(1);
		elem.click();
	}

	public String getText(By locator) {
		String text = getElement(locator).getText();
		return text;
	}
	
	public void enterText(By locator, String text) {
		getElement(locator).sendKeys(text);
		
	}
	
	

	public void enterIntoFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void enterIntoFrame(By locator) {
		driver.switchTo().frame(driver.findElement(locator));
	}

	public void backToDefaultFromFrame() {
		driver.switchTo().defaultContent();
	}

	/** Select Functionality **/

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

	/** Actions Functionality **/
	public void hoverToElement(By locator) {

		Actions myAction = new Actions(driver);

		myAction.moveToElement(getElement(locator)).build().perform();

	}

	public void setElementAttribute(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').setAttribute('style', 'display: block;')");
	}

	public void highLight(By locator) {
		if (demo) {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int i = 0; i < 3; i++) {
				js.executeScript("arguments[0].setAttribute('style', 'background-color: yellow;')",
						driver.findElement(locator));
				customeWait(0.5);
				js.executeScript("arguments[0].setAttribute('style', '')", driver.findElement(locator));
				customeWait(0.5);
			}
		}

	}

	public void customeWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void customeWait(double second) {
		try {
			Thread.sleep((int) (second * 1000)); // 0.2 * 1000 -> 200 ? 200.00
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
