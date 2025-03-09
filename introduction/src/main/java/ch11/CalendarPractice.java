package ch11;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String month="6";
		String date="15";
		String year="2027";
		String[] targetDate= {month,date,year};
//		 List<String> targetDate=Arrays.asList(date,month,year);
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		
		// step 1: 원하는 날짜 고르기 
		// 연도가 안맞다면 연도 맞추러 가기
		if(!driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).getText().contains(year)) {
			driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
			selectYear(driver,year);
		}
		selectMonth(driver,month);
		selectDate(driver,date);
		
		// step 2: 선택된 날짜 검증하기
		List <WebElement> result=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
	
		for(int i=0;i<targetDate.length;i++) {
			Assert.assertEquals(Integer.parseInt(result.get(i).getDomAttribute("value")), Integer.parseInt(targetDate[i]));
		}
		driver.close();
		
	}
	static void selectYear(WebDriver driver, String year) {
		String yearXpath=String.format("//button[text()='%s']", year+"년");
		driver.findElement(By.xpath(yearXpath)).click();
//		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
	}
	
	static void selectMonth(WebDriver driver,String month) {
		driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
	}
	static void selectDate(WebDriver driver, String date) {
		String dayXpath=String.format("//abbr[text()='%s']", date+"일");
		driver.findElement(By.xpath(dayXpath)).click();
	}
}
