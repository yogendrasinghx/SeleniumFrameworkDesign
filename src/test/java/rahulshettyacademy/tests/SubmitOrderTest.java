package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.Header;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.PaymentPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		
		//String productname="ZARA COAT 3";
		String creditcardnumber = "1234 9931 9292 5678";
		String month ="05";
		String year = "23";
		String cvv = "123";
		String name = "Yogendra Singh";
		String coupon = "rahulshettyacademy";
		String country = "ind";
		String countryMatch = "India";
		
		
		
		//String username ="yogendra@rahulshettyacademy.com";
		//String password = "yogendra@zxZX12!@";
		
		
		ProductCatalogue productCat = landingPage.loginApplication(input.get("email"),input.get("password"));
		
	
		Header header = productCat.addProductToCart(input.get("product"));
		
		
		CartPage cartpage = header.clickOnCartButton();
		
		
		Boolean match = cartpage.cartCheck(input.get("product"));
		
		Assert.assertTrue(match);
		
		PaymentPage paymentpage = cartpage.checkoutCart();
		
		
		
		//Click on Credit Card Button
		paymentpage.clickOnCreditCardButton();
		
		//Type credit card number
		paymentpage.fillCreditCardData(creditcardnumber);
		
		
		//Select Month
		paymentpage.selectMonth(month);
		
		
		//Select Year
		paymentpage.selectYear(year);
		
		
		//Type cvv
		paymentpage.fillCvv(cvv);
		
		//Type name on card
		paymentpage.fillCardHolderName(name);
		
		//Type Coupon and click
		paymentpage.applyCouponCode(coupon);
		
		
		//Type country name
		paymentpage.typecountry(country);
		
		//Click on country
		paymentpage.selectCountry(countryMatch);
		
		//Click on Place order button
		ConfirmationPage confirmationpage = paymentpage.clickOnPlaceOrderButton();
		
		//click on download csv
		
		confirmationpage.downloadCSV();
		
		//driver.close();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		/*HashMap<Object,Object> map1 = new HashMap<>();
		map1.put("email", "yogendra@rahulshettyacademy.com");
		map1.put("password", "yogendra@zxZX12!@");
		map1.put("product", "ZARA COAT 3");
		
		HashMap<Object,Object> map2 = new HashMap<>(); 
		map2.put("email", "yogendra2@rahulshettyacademy.com");
		map2.put("password", "yogendra@zxZX12!@");
		map2.put("product", "ADIDAS ORIGINAL");*/
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//purchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}


}
