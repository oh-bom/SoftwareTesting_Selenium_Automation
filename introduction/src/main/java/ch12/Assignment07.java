package ch12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment07 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// 1. 테이블의 row: tbody안의 tr개수 구하기 
		int row=driver.findElements(By.cssSelector(".table-display tbody tr")).size()-1;
		System.out.println("row:"+row);
		
		// 2. 테이블의 column: 첫번째 tr안의 th개수 구하기 
		WebElement infoRow=driver.findElements(By.cssSelector(".table-display tbody tr")).get(0);
		int column=infoRow.findElements(By.cssSelector("th")).size();
		System.out.println("column:"+column);
		
		// 3. 테이블의 2번째 row 데이터 출력
		int targetRowNumber=2;
		WebElement targetRow=driver.findElements(By.cssSelector(".table-display tbody tr")).get(targetRowNumber);
		
		for(int i=0;i<column;i++) {
			String columnName=infoRow.findElements(By.cssSelector("th")).get(i).getText();
			String columnData=targetRow.findElements(By.cssSelector("td")).get(i).getText();
			System.out.println(columnName+":"+columnData);
		}
		
		// 풀이 접근법: 테이블 먼저 접근 후 간단하게 tr 태그이름으로 접
		WebElement table=driver.findElement(By.id("product"));
		table.findElement(By.tagName("tr")); 
		
	}

}
