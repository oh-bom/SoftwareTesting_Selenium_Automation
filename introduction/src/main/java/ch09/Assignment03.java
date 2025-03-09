package ch09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment03 {

	public static void main(String[] args) throws InterruptedException {
		
		// Assignment03: 로그인 후, 모든 상품을 카트에 담는 예제 - explicit wait 활용
		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String role="Teacher";
		String username="rahulshettyacademy";
		String password="learning";
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		// 로그인 
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		// 커스텀 라디오 버튼(Admin, User)중 두번째꺼 클릭
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement roles= driver.findElements(By.cssSelector(".form-control")).get(2);
		Select selectedRole= new Select(roles);
		selectedRole.selectByVisibleText(role);
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-info']")));
		
		// 카트에 상품 모두 담기 
		List <WebElement> addBtn=driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		addBtn.forEach(it->it.click());
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
	}

}
