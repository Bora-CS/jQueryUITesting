package widget;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseTest;

public class Accordion extends BaseTest {
	
	@Test
	public void defaultTest() {
		
		lib.clickElement(By.linkText("Accordion"));
		lib.enterIntoFrame(0);
		
		lib.clickElement(By.id("ui-id-3"));
		lib.customeWait(1);
		String text = lib.getText(By.id("ui-id-4"));
		 
		Assert.assertEquals(text, "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.");

	}
	
	
	@Test
	public void collapseContent() {
		
		lib.clickElement(By.linkText("Accordion"));
		lib.clickElement(By.linkText("Collapse content"));
		lib.enterIntoFrame(0);
		lib.clickElement(By.id("ui-id-3"));
		lib.customeWait(1);
		String text = lib.getText(By.id("ui-id-4"));
		
		Assert.assertEquals(text, "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna. ");
		
	}
	
}
