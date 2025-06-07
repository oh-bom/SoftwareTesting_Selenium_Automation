package rahulshettyacademy.tests;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testComponents.BaseTest;
import rahulshettyacademy.testComponents.Retry;
public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException {
		String targetProduct="ZARA COAT 3";
		String testEmail="ohbom@gmail.com";
		String testPw="Qaqa0721!";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(testEmail,testPw);
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
	}
	
	@Test
	public void ProductErrorValidation() throws IOException {
		String targetProduct="ZARA COAT 3";
		String testEmail="ohbom@gmail.com";
		String testPw="Qaqa0721!!";
		ProductCatalogue productCatalogue=landingPage.loginApplication(testEmail,testPw);
		
		List <WebElement> products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(targetProduct);
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay(targetProduct);
		Assert.assertTrue(match);
		
	}

}
