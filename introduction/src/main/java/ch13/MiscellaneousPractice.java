package ch13;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class MiscellaneousPractice {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. SSL check
		ChromeOptions options=new ChromeOptions();
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444"); //ip adress or ip port
		options.setCapability("proxy", proxy);
		
		// 2. cookie handling
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");
		
		// 안전한 세션관리 시나리오: 쿠키 삭제, 홈페이지 다시 리다이렉트, 로그인 
		
		// 3. 스크린샷 찍기 
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// TakesScreenshot 인터페이스는 WebDriver는 구현x, ChromeDriver에만 구현되어있음
		// 그래서 TakesScreenshot으로 driver를 캐스팅 후 chrome driver에 구현된 getScreenshotAs() 사용 
		FileUtils.copyFile(src,new File("/Users/ohbom/Downloads/screenshot.png"));
		
		
		
	}

}
