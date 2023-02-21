package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	By toast = By.cssSelector("#toast-container");
	
	@FindBy(css=".col-lg-4.col-md-6")
	List<WebElement> products;
	
	@FindBy(css=".ngx-spinner-overlay")
	WebElement animation;
	
	//Wait for product to load and get product list web element
	public List<WebElement> getProductList() {
		waitForInvisibilityOfElement(toast);
		return products;
	}
	
	//Get product by name
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	//Click on Add to Cart Button of desired product
	public Header addProductToCart(String productName) {
		List<WebElement> cart = getProductByName(productName).findElements(By.tagName("button"));
		WebElement cartbutton = cart.stream().filter(s->s.getText().equals("Add To Cart")).findFirst().orElse(null);
		cartbutton.click();
		waitForInvisibilityOfAnimation(animation);
		waitForInvisibilityOfElement(toast);
		return new Header(driver);
		
		
	}
	

}
