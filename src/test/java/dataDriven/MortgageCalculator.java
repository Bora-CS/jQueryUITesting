package dataDriven;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.UtilityLibrary;

public class MortgageCalculator {

	WebDriver driver;
	UtilityLibrary lib;

	String url = "https://www.mortgagecalculator.org/";

	By homeValue = By.id("homeval");
	By downPayment = By.id("downpayment");
	By percentRadioButton = By.cssSelector("input[value='percent']");
	By moneyRadioButton = By.cssSelector("input[value='money']");
	By interestRate = By.id("intrstsrate");
	By loanTerm = By.id("loanterm");
	By taxField = By.id("pptytax");
	By buyOptionDropDown = By.name("param[refiorbuy]");
	By calculatButton = By.xpath("//input[@value='Calculate']");

	@BeforeMethod
	public void runBeforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");
		driver = new ChromeDriver();
		lib = new UtilityLibrary(driver);
	}

	@AfterMethod
	public void runAftermethod() {
		lib.customeWait(3);
		driver.quit();
	}

	@Test
	void testCode() {

		PojoClassForMortgageCalculator pojo_1 = new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy", "$5,262.21");

		PojoClassForMortgageCalculator pojo_2 = new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy", "$5,262.21");

		PojoClassForMortgageCalculator pojo_3 = new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy", "$0");

		PojoClassForMortgageCalculator pojo_4 = new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy", "$0");

		List<PojoClassForMortgageCalculator> datas = new ArrayList<>();
		datas.add(pojo_1);
		datas.add(pojo_2);
		datas.add(pojo_3);
		datas.add(pojo_4);

		for (PojoClassForMortgageCalculator testData : datas) {

			driver.get(url);

			// Enter Home Value - int homePrice
			lib.enterText(homeValue, testData.getHomePrice());

			// Enter Down payment - int downPayment, int radioOption (dollar, percentage)
			lib.enterText(downPayment, testData.getDownPayment());

			WebElement percentageRadio = driver.findElement(percentRadioButton);
			WebElement moneyRadio = driver.findElement(moneyRadioButton);

			if (testData.getDownPaymentOption()) {
				percentageRadio.click();
			} else {
				moneyRadio.click();
			}

			// Enter Interest Rate - int rate
			lib.enterText(interestRate, testData.getRate());

			// Enter Loan term - int years

			lib.enterText(loanTerm, testData.getTermYear() + "");

			// Enter Property Tax - int tax

			lib.enterText(taxField, testData.getTax());

			// Select Buy / Refi - String (buy, refi)
			WebElement buyingOption = driver.findElement(buyOptionDropDown);
			Select mySelect = new Select(buyingOption);
			if (testData.getBuyOption().equals("buy")) {
				mySelect.selectByValue("1");
			} else {
				mySelect.selectByValue("2");
			}

			// Click Calculate button
			lib.clickElement(calculatButton);
			lib.customeWait(3);

			// Verify Result
			String actualPrice = lib.getText(By.xpath("//h3[contains(text(),'$')]"));
			System.out.println("Price :" + actualPrice);

			Assert.assertEquals(actualPrice, testData.getMonthlyPayment(), "This test case is failed");

			lib.customeWait(5);
			System.out.println("This test case is passed");
		}

	}

}
