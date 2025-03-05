package ch07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String nameText="ohbom";
		
		driver.findElement(By.id("name")).sendKeys(nameText);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();	
		
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); // js alert 창 ok 클릭 
		
		driver.findElement(By.id("name")).sendKeys(nameText);
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();	
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		
	}

}
