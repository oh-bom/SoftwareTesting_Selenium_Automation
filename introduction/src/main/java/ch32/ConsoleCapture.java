package ch32;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleCapture {
	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click(); // a tag
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry=driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs=entry.getAll();
		
		logs.forEach(it->{
			System.out.println(it.getMessage());
		});
		
	}
}
