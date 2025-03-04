package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumintroduction{

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver= new ChromeDriver(); 
		// chrome driver에 대한 webDriver만 
		// 그냥 chromeDriver라고 선언하면 다른 브라우저에서는 못씀
		
		driver.get("https://www.naverz-corp.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close(); // 현재 탭만 닫기
		driver.quit(); //모든 탭 닫
		
		// 다른 브라우저 ver
//		WebDriver driver=new FirefoxDriver(); //geco=driver

	}

}
