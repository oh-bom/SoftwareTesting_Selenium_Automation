package ch13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		
		WebDriver driver = new ChromeDriver();
		SoftAssert a = new SoftAssert();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int SuccessCode=200;
		
		// 하나의 a href만 접근
		driver.findElement(By.cssSelector("a[href*='soapui']")).getDomAttribute("href");
		// href에 "soapui"문자열이 들어간 a 태그 속성을 찾기
		// *= :부분일치, ^=접두사 일치, $= 접미사 일치, = 완전일치
		
		// 모든 a href 접근
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement link:links) {
			String url=link.getDomProperty("href");
			HttpURLConnection conn= (HttpURLConnection) new URI(url).toURL().openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode=conn.getResponseCode();
			
			if(responseCode>400){
				String failMessage="the link with text: "+link.getText()+"is broken with code: "+responseCode;
					
				System.out.printf("the link with text %s is broken with code %s",link.getText(),responseCode);
//				Assert.assertTrue(false); // hard assertion 
				a.assertTrue(responseCode<400, failMessage);
				
			}
			
			a.assertAll(); // 이거 있어야 failure 리포트함
			
		}
		
		
		

	}

}
