package ch11;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		// 1. count footer link
		WebElement footerdriver=driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		// 2. 특정 컬럼에있는 link 수 세기  
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		// 3.click on each link in the column and check if the pages are opening
		List <WebElement> linkList= columndriver.findElements(By.tagName("a"));
		String clickonLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		//Keys.CONTROL: 여러키 동시에 누르기, control+enter:새탭으로 키기 
		linkList.forEach(it->it.sendKeys(clickonLinkTab));
		
		// 4. opens all the tabs and print titles
		for(int i=0;i<columndriver.findElements(By.tagName("a")).size();i++) {
			linkList.forEach(it->it.sendKeys(clickonLinkTab));
			Thread.sleep(5000L);
			
			Set<String> windows=driver.getWindowHandles();
			Iterator<String>it=windows.iterator();
			
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			// latest 켜진것부터 oldest 순으로 찍힘 
			
;		}
		
	
	}

}
