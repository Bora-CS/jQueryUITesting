package dataDriven;

public class PojoClassForMortgageCalculator {

	
	
	private String homePrice;
	String downPayment;
	Boolean downPaymentOption;
	String rate;
	int termYear;
	String tax;
	String buyOption;
	
	public PojoClassForMortgageCalculator
	(String passedHomePrice, String passedDownPayment, Boolean passedDownPaymentOption, 
			String passedRate, int passedTermYear, String passedTax, String passedBuyOption) {
		
		this.homePrice = passedHomePrice;
		this.downPayment = passedDownPayment;
		downPaymentOption = passedDownPaymentOption;
		rate = passedRate;
		this.termYear = passedTermYear;
		this.tax = passedTax;
		this.buyOption = passedBuyOption;
		
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
