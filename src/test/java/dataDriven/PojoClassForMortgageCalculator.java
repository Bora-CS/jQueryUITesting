package dataDriven;

public class PojoClassForMortgageCalculator {

	
	
	private String homePrice;
	String downPayment;
	Boolean downPaymentOption;
	String rate;
	int termYear;
	String tax;
	String buyOption;
	String monthlyPayment;
	
	public PojoClassForMortgageCalculator
	(String passedHomePrice, String passedDownPayment, Boolean passedDownPaymentOption, 
			String passedRate, int passedTermYear, String passedTax, String passedBuyOption,
			String passedMonthlyPayment) {
		
		this.homePrice = passedHomePrice;
		this.downPayment = passedDownPayment;
		downPaymentOption = passedDownPaymentOption;
		rate = passedRate;
		this.termYear = passedTermYear;
		this.tax = passedTax;
		this.buyOption = passedBuyOption;
		this.monthlyPayment = passedMonthlyPayment;
		
	}
	
	public String getMonthlyPayment() {
		return monthlyPayment;
	}
	
	
	public String getHomePrice() {
		return homePrice;
	}
	
	public String getDownPayment() {
		return downPayment;
	}
	
	public Boolean getDownPaymentOption() {
		return downPaymentOption;
	}
	
	public String getRate() {
		return rate;
	}
	
	public int getTermYear() {
		return termYear;
	}
	
	public String getTax() {
		return tax;
	}
	public String getBuyOption() {
		return buyOption;
	}
	
	

}
