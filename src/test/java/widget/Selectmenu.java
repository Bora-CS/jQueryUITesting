package widget;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import library.BaseTest;
import library.UtilityLibrary;

public class Selectmenu extends BaseTest {

	@Test
	public void selectTest() {

		lib.clickElement(By.linkText("Selectmenu"));

		lib.enterIntoFrame(0);

		lib.setElementAttribute("files");
		lib.customeWait(2);

		lib.selectFunctionByValue(By.id("files"), "somefile");

		lib.customeWait(2);

		lib.setElementAttribute("number");

		lib.selectFunctionByVisibleText(By.id("number"), "10");

		lib.customeWait(2);

		lib.setElementAttribute("salutation");

		lib.selectFunctionByIndex(By.id("salutation"), 3);

		lib.customeWait(3);

		lib.backToDefaultFromFrame();

		lib.clickElement(By.linkText("Custom Rendering"));

		lib.customeWait(2);

	}

}
