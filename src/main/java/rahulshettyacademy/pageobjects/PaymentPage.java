package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".payment__types div:first-child")
	WebElement creditcardbutton;
	
	@FindBy(xpath="//input[@value='4542 9931 9292 2293']")
	WebElement creditcardnumber;
	
	@FindBy(xpath="(//select[@class='input ddl'])[1]")
	WebElement monthElement;
	
	@FindBy(xpath="(//select[@class='input ddl'])[2]")
	WebElement yearElement;
	
	@FindBy(xpath="//div[contains(text(),'CVV Code')]/following-sibling::input")
	WebElement cvvElement;
	
	@FindBy(xpath="//div[contains(text(),'Name on Card')]/following-sibling::input")
	WebElement cardholdernameElement;
	
	@FindBy(xpath="//div[contains(text(),'Apply Coupon')]/following-sibling::input")
	WebElement couponFieldElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement couponButtonElement;
	
	@FindBy(css=".ngx-spinner-overlay")
	WebElement animation;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryElement;
	
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	List<WebElement> countryOptions;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement placeOrderButton;
	
	
	
	public void clickOnCreditCardButton() {
		creditcardbutton.click();
	}
	
	public void fillCreditCardData(String cardnumber) {
		creditcardnumber.clear();
		creditcardnumber.sendKeys(cardnumber);
		
	}
	
	public void selectMonth(String month) {
		
		Select selmonth = new Select(monthElement);
		
		selmonth.selectByVisibleText(month);	
		
	}
	
	public void selectYear(String year) {
		
		Select selyear = new Select(yearElement);
		
		selyear.selectByVisibleText(year);	
	}
	
	public void fillCvv(String cvv) {
		cvvElement.sendKeys(cvv);
	}
	
	public void fillCardHolderName(String name) {
		
		cardholdernameElement.sendKeys(name);
	}
	
	public void applyCouponCode(String coupon) {
		couponFieldElement.sendKeys(coupon);
		couponButtonElement.click();
		//wait for animation to complete
		waitForInvisibilityOfAnimation(animation);
	}
	
	public void typecountry(String country) {
		
		countryElement.sendKeys(country);
	}
	
	public void selectCountry(String country) {
		
		
		countryOptions.stream().filter(s->s.getText().equalsIgnoreCase(country)).findFirst().orElse(null).click();
	}
	
	public ConfirmationPage clickOnPlaceOrderButton() {
		
		placeOrderButton.click();
		return new ConfirmationPage(driver);
	}
	

}
