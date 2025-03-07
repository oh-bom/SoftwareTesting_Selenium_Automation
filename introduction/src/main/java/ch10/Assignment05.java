package ch10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		
		// frame 자체가 독립적이기 때문에 중첩된 프레임을 접근하려면 순차적으로 접근해야함
		
//		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
//		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		
	
		System.out.print(driver.findElement(By.id("content")).getText());
		
		
		
	}

}
