package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;
import rahulshettyacademy.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
		
	public LandingPage(WebDriver driver) {
		super(driver); // parent class인 abstractComponent의 생성자로 보내기 
		this.driver=driver;
		PageFactory.initElements(driver, this); // 아래 코드에서 driver이용하여 초기화, 사용할 드라이버는 this 
	}

	// page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}


