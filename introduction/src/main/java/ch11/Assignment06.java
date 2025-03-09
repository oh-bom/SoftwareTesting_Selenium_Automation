package ch11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment06 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. option2 체크박스 고르고 라벨 로그 찍기 
		WebElement checkBoxArea=driver.findElement(By.id("checkbox-example"));
		checkBoxArea.findElement(By.id("checkBoxOption2")).click();
		String optionName=driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
		System.out.println(optionName);
		
		// 2. drop down에서 라벨에서 고른거랑 같은거 고르기
		WebElement dropdowns=driver.findElement(By.id("dropdown-class-example"));
		Select dropDownOption=new Select(dropdowns);
		dropDownOption.selectByVisibleText(optionName);
		
		// 3. 고른거 edit text에 띄우기 
		driver.findElement(By.id("name")).sendKeys(optionName);
		
		// 4. alert창 누르고 거기에 옵션 text이 잘 띄워진 것인지 verify하기  
		driver.findElement(By.id("alertbtn")).click();
		String alertMessage=driver.switchTo().alert().getText();
		// v1: 문자열 split으로 찾기 
//		String alertOptionName=alertMessage.split(",")[0].split(" ")[1];
//		Assert.assertEquals(alertOptionName, optionName);
//		driver.switchTo().alert().accept();
		
		// v2: 문자열 포함 여부 판단 
		if(alertMessage.contains(optionName)) driver.switchTo().alert().accept();
		
	}

}
