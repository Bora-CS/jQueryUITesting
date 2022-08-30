package dataDriven;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	
	
//  a  b  sum	
//	3  5  8
//	4  5  10
//	3  31 34
	
	@DataProvider
	public Object[][] dataSource() {
		
		Object[][] datas = new Object[3][3];
		Object[] test1 = {3,5,8};
		Object[] test2 = {4,5,10};
		Object[] test3 = {3,31,34};
		
		datas[0] = test1;
		datas[1] = test2;
		datas[2] = test3;
		
		return datas;
	}


	@Test(dataProvider = "dataSource")
	public void calculateSumTesting(int a, int b, int sum) {

//		int a = data[0], b=data[1], sum=data[2];
		
		// a+b  ?= sum
		Assert.assertTrue(a+b==sum);
		
//		Assert.assertEquals(a+b, sum);

	}
	
	
	
	
	
	
	
	

}
