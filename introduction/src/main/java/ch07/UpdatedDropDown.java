package ch07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); 
		// * 추가해서 SeniorCitizenDiscount 앞에는 다른거 와도 됨! 
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000); // 요놈 없으면 에러뜸 !! 유의하
		
		for(int i=0;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
		// 캘린더날짜 선택
		driver.findElement(By.cssSelector("ui-state-default ui-state-active")).click();
		
		//
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		};
		
	
	}

}
