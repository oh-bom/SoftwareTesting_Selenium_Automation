//package rahulshettyacademy.tests;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;  
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class RawStandAloneTest_BeforeRefactor {
//
//	public static void main(String[] args) {
//		
//		WebDriverManager.chromedriver().setup(); //pom.xml에 dependency 추가후 사용
//		WebDriver driver= new ChromeDriver();
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		
//		String targetProduct="ZARA COAT 3";
//		String testEmail="ohbom@gmail.com";
//		String testPw="Qaqa0721!";
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.manage().window().maximize();
//		
//		LandingPage landingPage= new LandingPage(driver);
//		landingPage.goTo();
//		ProductCatalogue productCatalogue=landingPage.loginApplication(testEmail,testPw);
//		
//		// LandingPage class로 대체
////		driver.findElement(By.id("userEmail")).sendKeys("ohbom@gmail.com");
////		driver.findElement(By.id("userPassword")).sendKeys("Qaqa0721!");
////		driver.findElement(By.id("login")).click();
//	
//		List <WebElement> products= productCatalogue.getProductList();
//		
//		// productCatalogue로 대체 
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']")));
////		List<WebElement> products= driver.findElements(By.xpath("//div[@class='card-body']"));
//		
//		productCatalogue.addProductToCart(targetProduct);
//		CartPage cartPage=productCatalogue.goToCartPage();
//		
////		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b"))
////				.getText().equals(targetProduct))
////				.findFirst().orElse(null);
////		
////		prod.findElement(By.cssSelector("button:last-of-type")).click();
//		
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
////		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		
////		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		
//		Boolean match=cartPage.VerifyProductDisplay(targetProduct);
//		Assert.assertTrue(match);
//		CheckoutPage checkoutPage=cartPage.goToCheckOut();
//		checkoutPage.selectCountry("Korea");
//		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
//		
////		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
////		// anyMatch(): 확인 여부만 체크할때 , filter(): elements 필요할때 
////		Boolean match=cartProducts.stream().anyMatch(it->it.getText().equalsIgnoreCase(targetProduct));
////		Assert.assertTrue(match);
////		driver.findElement(By.cssSelector(".totalRow button"));
//			
////		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("korea");
////		
////		Actions a= new Actions(driver);
////		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"korea").build().perform();
////		
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ta-results")));
////		driver.findElements(By.cssSelector("ta-item:nth-of-type(1)"));
////		
////		driver.findElement(By.cssSelector(".action__submit")).click();
//
//		Assert.assertTrue(confirmationPage.verifyConfirmMessage("THANKYOU FOR THE ORDER."));
//		driver.close();
//	}
//
//}
