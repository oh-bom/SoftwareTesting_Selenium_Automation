package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".tbody tr td:nth-child(3)") // tr의 3번째 자식 중 td인 칭구 선택 
	private List<WebElement> orderProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;
	
	public Boolean VerifyOrderDisplay(String productName) {
		return orderProducts.stream().anyMatch(it->it.getText().equalsIgnoreCase(productName));
	}
	
}
