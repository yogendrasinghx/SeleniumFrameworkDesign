/*package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.Header;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.PaymentPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StandAloneTest {

	public static void main(String[] args) {
		
		String productname="ZARA COAT 3";
		String creditcardnumber = "1234 9931 9292 5678";
		String month ="05";
		String year = "23";
		String cvv = "123";
		String name = "Yogendra Singh";
		String coupon = "rahulshettyacademy";
		String country = "ind";
		String countryMatch = "India";
		
		BaseTest bt = new BaseTest();
		bt.initializeDriver();
		
		
		
		
		String username ="yogendra@rahulshettyacademy.com";
		String password = "yogendra@zxZX12!@";
		
		landingPage.loginApplication(username,password);
		
		
		ProductCatalogue productCat = new ProductCatalogue(driver);
		
	
		productCat.addProductToCart(productname);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		Header header = new Header(driver);
		header.clickOnCartButton();
		
		CartPage cartpage = new CartPage(driver);
		
		Boolean match = cartpage.cartCheck(productname);
		
		Assert.assertTrue(match);
		
		cartpage.checkoutCart();
		
		PaymentPage paymentpage = new PaymentPage(driver);
		
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
		paymentpage.clickOnPlaceOrderButton();
		
		//click on download csv
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		confirmationpage.downloadCSV();

	}

}*/
