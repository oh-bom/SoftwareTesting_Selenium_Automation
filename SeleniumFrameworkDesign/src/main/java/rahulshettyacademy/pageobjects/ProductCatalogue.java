package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;
import rahulshettyacademy.abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
		
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); // 아래 코드에서 driver이용하여 초기화, 사용할 드라이버는 this 
	}

	// page factory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy= By.cssSelector(".mb-3");
	By addToCartBy=By.cssSelector("button:last-of-type");
	By toastMsgBy=By.cssSelector("#toast-container");

	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		return products.stream().filter(product->product.findElement(By.cssSelector("b"))
				.getText().equals(productName))
				.findFirst().orElse(null);
	}
	
	public void addProductToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCartBy).click();
		waitForElementToAppear(toastMsgBy);
		waitForElementToDisappear(spinner);
	}

}


