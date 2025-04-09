package rahulshettyacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); //pom.xml에 dependency 추가후 사용
		WebDriver driver= new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String targetProduct="ZARA COAT 3";
		String testEmail="ohbom@gmail.com";
		String testPw="Qaqa0721!";
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue=landingPage.loginApplication(testEmail,testPw);
		
		List <WebElement> products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(targetProduct);
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay(targetProduct);
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage=cartPage.goToCheckOut();
		checkoutPage.selectCountry("Korea");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();

		Assert.assertTrue(confirmationPage.verifyConfirmMessage("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
