package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;
	
	public Boolean VerifyProductDisplay(String productName) {
		return cartProducts.stream().anyMatch(it->it.getText().equalsIgnoreCase(productName));
	}
	
	public CheckoutPage goToCheckOut() {
		checkoutBtn.click();
		return new CheckoutPage(driver);
	}
}
