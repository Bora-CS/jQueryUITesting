package widget;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import library.BaseTest;

public class Button extends BaseTest {
	
	
	@Test
	public void defaultTest() {
		
		lib.clickElement(By.linkText("Button"));
		lib.enterIntoFrame(0);
		
		lib.clickElement(By.xpath("(//button)[1]"));
		lib.clickElement(By.xpath("(//button)[2]"));
		
		
	}

}
