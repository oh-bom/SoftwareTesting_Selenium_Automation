package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="hw";
		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver= new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password=getPassword(driver);
		driver.get("https://www.rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("");
		driver.findElement(By.className("singInBtn")).click();
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfuly loggged in");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-conainer'] h2")).getText(), "Hello"+name+",");
	}
	
	public static String getPassword(WebDriver driver) {
		driver.get("https://www.rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
//		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText=driver.findElement(By.cssSelector("form p")).getText();
		// please use temporary password 'hw'to login
		
		String[] passwordArray=passwordText.split("'");
		// please use temporary password, hw'to login
		
		String password=passwordArray[1].split("'")[0]; // hw
		return password;
		
		
	}
	

}
