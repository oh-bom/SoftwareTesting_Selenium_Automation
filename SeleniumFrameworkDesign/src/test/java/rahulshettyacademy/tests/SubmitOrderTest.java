package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String targetProduct="ZARA COAT 3";
	String testEmail="ohbom@gmail.com";
	String testPw="Qaqa0721!";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
		
		List <WebElement> products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage=cartPage.goToCheckOut();
		checkoutPage.selectCountry("Korea");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();

		Assert.assertTrue(confirmationPage.verifyConfirmMessage("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue=landingPage.loginApplication(testEmail, testPw);
		OrderPage orderPage=productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(targetProduct));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
	
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/rahulshettyacademy/data/PurchaseOrder.json");
		
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}

}
