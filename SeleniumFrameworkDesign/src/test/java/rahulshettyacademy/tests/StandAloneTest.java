package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import java.io.IOException;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testComponents.BaseTest;

public class StandAloneTest extends BaseTest {

//	public static void main(String[] args) {
	@Test
	public void submitOrder() throws IOException {
		String targetProduct="ZARA COAT 3";
		String testEmail="ohbom@gmail.com";
		String testPw="Qaqa0721!";
		
		// base Test로 통합 
//		WebDriverManager.chromedriver().setup(); //pom.xml에 dependency 추가후 사용
//		WebDriver driver= new ChromeDriver();
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.manage().window().maximize();
//		LandingPage landingPage= new LandingPage(driver);
//		landingPage.goTo();
		
//		LandingPage landingPage=launchApplication(); // baseTest에서 beforemethod로 수행 
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
//		driver.close();
	}

}
