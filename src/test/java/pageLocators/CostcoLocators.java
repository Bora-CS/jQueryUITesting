package pageLocators;

import org.openqa.selenium.By;

public class CostcoLocators {
	
	
	public static final By searchBox = By.id("search-field");
	

	public static final By PDP_productTitle = By.xpath("//*[@automation-id='productName']");
	public static final By PDP_productPrice = By.xpath("//*[@automation-id='productPriceOutput']");
}
