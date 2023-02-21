package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".infoWrap h3")
	List<WebElement> cartinfo;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutButton;
	
	public boolean cartCheck(String productName) {
		return cartinfo.stream().anyMatch(info->info.getText().equalsIgnoreCase(productName));
	}
	
	public PaymentPage checkoutCart() {
		checkoutButton.click();
		return new PaymentPage(driver);
	}
	

}
