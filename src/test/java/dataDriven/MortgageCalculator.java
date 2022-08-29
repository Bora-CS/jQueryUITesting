package dataDriven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalculator {

	static WebDriver driver;
	
	static String url = "https://www.mortgagecalculator.org/";

	static By homeValue = By.id("homeval");
	static By downPayment = By.id("downpayment");
	static By percentRadioButton = By.cssSelector("input[value='percent']");
	static By moneyRadioButton = By.cssSelector("input[value='money']");
	static By interestRate = By.id("intrstsrate");
	static By loanTerm = By.id("loanterm");
	static By taxField = By.id("pptytax");
	static By buyOptionDropDown = By.name("param[refiorbuy]");
	static By calculatButton = By.xpath("//input[@value='Calculate']");

	public static void main(String[] args) {


		PojoClassForMortgageCalculator pojo_1 = 
				new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy");
		
		PojoClassForMortgageCalculator pojo_2 = 
				new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy");
		
		PojoClassForMortgageCalculator pojo_3 = 
				new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy");
		
		PojoClassForMortgageCalculator pojo_4 = 
				new PojoClassForMortgageCalculator("800000", "20000", false, "5", 30,
				"8000", "buy");

		List<PojoClassForMortgageCalculator> datas = new ArrayList<>();
		datas.add(pojo_1);
		datas.add(pojo_2);
		datas.add(pojo_3);
		datas.add(pojo_4);
		
		
		for(PojoClassForMortgageCalculator pojo : datas) {
			testCode(pojo);
		}
		

	}

	
	static void testCode(PojoClassForMortgageCalculator testData) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");
		driver = new ChromeDriver();

		try {

			driver.get(url);

			// Enter Home Value - int homePrice
			enterText(homeValue, testData.getHomePrice());

			// Enter Down payment - int downPayment, int radioOption (dollar, percentage)
			enterText(downPayment, testData.getDownPayment());

			WebElement percentageRadio = driver.findElement(percentRadioButton);
			WebElement moneyRadio = driver.findElement(moneyRadioButton);

			if (testData.getDownPaymentOption()) {
				percentageRadio.click();
			} else {
				moneyRadio.click();
			}

			// Enter Interest Rate - int rate
			enterText(interestRate, testData.getRate());

			// Enter Loan term - int years

			enterText(loanTerm, testData.getTermYear() + "");

			// Enter Property Tax - int tax

			enterText(taxField, testData.getTax());

			// Select Buy / Refi - String (buy, refi)
			WebElement buyingOption = driver.findElement(buyOptionDropDown);
			Select mySelect = new Select(buyingOption);
			if (testData.getBuyOption().equals("buy")) {
				mySelect.selectByValue("1");
			} else {
				mySelect.selectByValue("2");
			}

			// Click Calculate button
			clickButton(calculatButton);

			// Verify Result

			customeWait(5);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			driver.quit();
		}

	}

	static void clickButton(By locator) {
		driver.findElement(locator).click();
	}

	static void enterText(By locator, String text) {
		WebElement elem = driver.findElement(locator);
		elem.sendKeys(text);
		customeWait(1);
	}

	static void customeWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (Exception e) {

		}
	}

}
