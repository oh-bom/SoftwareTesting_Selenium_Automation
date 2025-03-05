package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver= new ChromeDriver();
		
		// parent to children
		//header/div/button[1]/following-sibiling::button[1]
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("header/div/button[1]/following-sibiling::button[1]")).getText());
		
		// children to parent
		// header/div/button[1]/parent::div/parent::head(grand parent)
		
	}

}
