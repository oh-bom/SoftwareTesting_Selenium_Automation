package ch07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// 이름, 이메일 , 비밀번호
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("hyewon");
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("hyewonlim.dev@gmail.com");
		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("testpw");
		
		driver.findElement(By.id("exampleCheck1")).click(); // 라디오 버튼 체크
		
		// q1. 성별 선택  
		WebElement sexDropDown=driver.findElement(By.id("exampleFormControlSelect1"));
		// <select> 요소 가리키는 webElement
		Select sex=new Select(sexDropDown); //어떤 webElement에 대한 드롭다운 기능 수행할지 지정 
		sex.selectByVisibleText("Female");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[value='option1']")).click(); //학생 클릭
		
		// 생일 선택
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("2000-07-21");
		//q2. 직접 캘린더 선택해서 하는건 모르겠음
		
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();

	}

}
