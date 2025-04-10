package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver= new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("ohbom");
		driver.findElement(By.name("inputPassword")).sendKeys("");
		driver.findElement(By.className("singInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		// xpath- //Tagname[@attribute='value'], input[@placeholder='Username']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("hw");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("hw@gmail.com");

		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(2)"));
		driver.findElement(By.cssSelector("form p")).getText();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("div[@class='gorgot-pwd-btn-container']/button[1]"));
		driver.findElement(By.cssSelector("input[type*='pass]")).sendKeys("pwpw"); // * 정규식
		driver.findElement(By.id("checkOne")).click(); 
		
		// regex div[contains(@class,"pwd")]
		// div[@class='gorgot-pwd-btn-container']/button[1]
		
		
	}

}
