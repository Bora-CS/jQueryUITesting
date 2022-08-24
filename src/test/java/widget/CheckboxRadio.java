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
		

		
		lib.clickElement(By.linkText("Radio Group"));
		lib.enterIntoFrame(0);
		
		lib.clickElement(By.xpath("//label[text()='Paris']"));
		
	}
	
	
	
	@Test
	public void noIconTest() {

		lib.clickElement(By.linkText("No Icons"));

		lib.enterIntoFrame(By.className("demo-frame"));
		lib.enterIntoFrame(0);
		
		

		lib.clickElement(By.xpath("//label[text()='New York']"));
		
		List<WebElement> hotelRate = lib.getListOfElements(By.xpath("//*[text()='Hotel Ratings: ']/..//label"));
		
		
		
		for(WebElement rate: hotelRate) {
			lib.clickElement(rate);
		}
		
		List<WebElement> bedType = lib.getListOfElements(By.xpath("//*[text()='Bed Type: ']/..//label"));
		
		for(WebElement bed: bedType) {
			lib.clickElement(bed);
		}		

	}

	@Test
	public void defaultTest() {

		lib.enterIntoFrame(0);

		lib.clickElement(By.xpath("//label[text()='New York']"));
		lib.clickElement(By.xpath("//label[@for='checkbox-1']/span[contains(@class,'checkboxradio')][1]"));
		lib.clickElement(By.xpath("//label[text()='r']"));
		
		
		lib.customeWait(2);

	
		lib.clickElement(By.xpath("//label[@for='checkbox-nested-2']/span[contains(@class,'checkboxradio')][1]"));

		
		
		WebElement checkBox_1Bed = lib.getElement(By.xpath("//*[@for='checkbox-nested-4']"));
		
		checkBox_1Bed.click();

		lib.customeWait(2);

		boolean isChecked = checkBox_1Bed.isSelected();

		System.out.println("the value is: " + isChecked);

	}



}
