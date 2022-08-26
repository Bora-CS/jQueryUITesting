package dataDriven;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.BaseTest;
import library.UtilityLibrary;
import pageLocators.CostcoLocators;

public class Costco extends BaseTest {

	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.costco.com");
//		driver.manage().window().maximize();
		lib = new UtilityLibrary(driver);

	}

	@Test
	public void test() {

		String[] test1 = { "9785888", "2,399.99" };
		String[] test2 = { "9865001", "1,599.99" };
		String[] test3 = { "9765080", "1,799.99" };
		String[] test4 = { "9755165", "269.99" };
		String[] test5 = { "9785090", "2,299.99" };
		String[] test6 = { "9885008", "1,599.99" };
		String[] test7 = { "9786780", "199.99" };
		String[] test8 = { "9832132", "129.99" };
		String[] test9 = { "9765022", "1,899.99" };
		String[] test10 = { "9765165", "399.99" };

		String[][] testDatas = { test1, test2, test3, test4, test5, test6, test7, test8, test9, test10 };

		for (String[] temp : testDatas) {
			String prodcutId= temp[0];
			String expectingProductPrice = temp[1];
			
			// 1. search for a product id
			lib.enterText(CostcoLocators.searchBox, prodcutId);

			lib.enterText(CostcoLocators.searchBox, "" + Keys.ENTER);

			// 2. get product title and product price

			String productTitle = lib.getText(CostcoLocators.PDP_productTitle);

			String productPrice = lib.getText(CostcoLocators.PDP_productPrice);

			// 3. verify the price is matching the given price

			Assert.assertEquals(productPrice, expectingProductPrice,
					"The product is not match, the product is: " + productTitle);

		}

	}

}
