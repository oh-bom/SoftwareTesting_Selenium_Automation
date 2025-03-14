package ch15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// above()
		WebElement nameEditBox=driver.findElement(By.cssSelector("[name='name']"));
		driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText(); 
		
		// below()
		WebElement dateofBirth=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		
		// toLeftOf()
		WebElement iceCreamLabel=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
	
		// toRightOF()
		WebElement rdb=driver.findElement(By.id("inlineRadio1"));
		driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText();
	}

}
