package ch07;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value=\"AIP\"])[1]")).click();
	
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		
		// ver1. 인덱스로 접근하는 방법
		driver.findElement(By.xpath("(//a[@value=\"DEL\"])[2]")).click();
		
		// ver2. 부모-자식 순으로 접근하는 방
		// // div[@id="ctl00_mainContent_ddl_destinationStation1_CTNR"] //a[@value="DEL"]
		
		
		
	}

}
