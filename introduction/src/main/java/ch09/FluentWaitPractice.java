package ch09;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

class FluentWaitPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click(); // id가 start인 요소 찾고 button 자식 찾기
		
		
		Wait <WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		//Fluent wait에는 없어서 explicit wait의  visibilityOfElement를 함수로 정의 한것
		WebElement foo=wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				}
			else return null;
					
		}});
	
}
}