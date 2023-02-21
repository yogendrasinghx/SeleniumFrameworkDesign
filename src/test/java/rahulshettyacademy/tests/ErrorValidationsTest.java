package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.LandingPage;

public class ErrorValidationsTest extends BaseTest{
	
	@Test(dataProvider="getData")
	public void errorValidation(String username,String password,String productName) {
		
		landingPage.loginApplication(username,password);
		
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][] {{"yogendra@rahulshettyacademy.com","yogendra@zxdZX12!@","ZARA COAT 3"},{"himanshu@rahulshettyacademy.com","Abcd123!@#","ADIDAS ORIGINAL"}};
	}

}
