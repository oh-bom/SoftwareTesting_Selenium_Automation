package ch09;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GreenKartWithWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // 모든 라인마다 적용 globally, 비추천 
		
		// Explicit wait
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
				

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<String> itemList=new ArrayList<>(List.of("Cucumber","Brocolli"));
		addItems(driver, itemList);
		
		// cart 들어가
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		
		// promotion 입
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		driver.findElement(By.cssSelector("span.promoInfo")).getText();
	}

	public static void addItems(WebDriver driver, List<String> itemList) {
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		int cnt=0;
		for(int i=0;i<products.size();i++) {
			String name=products.get(i).getText();
			name=name.split("-")[0].trim();
			
			if(itemList.contains(name)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				cnt++;
				if(cnt==itemList.size()) break;
			}
				
		}
	}

}
