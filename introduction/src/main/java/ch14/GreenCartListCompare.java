package ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenCartListCompare {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		// 1. 정렬 올바른지 체크 
		// 1-1. 내가 처음에 푼 코드 
		driver.findElement(By.xpath("//tr//th[1]")).click();
		WebElement table=driver.findElement(By.cssSelector(".table-bordered"));
		List<String> checkedList=new ArrayList<>(Arrays.asList());
		
		List<WebElement> rows=table.findElements(By.cssSelector("tbody tr"));

		rows.forEach(it->{
			String column=it.findElements(By.cssSelector("td")).get(0).getText();
			checkedList.add(column);
		});
		
		List<String> sortedLis2=checkedList.stream().sorted().collect(Collectors.toList());
		if(checkedList.equals(sortedLis2)) System.out.println("well sorted");
		else System.out.println("incorrectly sorted");
		
		// 1-2. 수업 코드
		List <WebElement> elementsList=driver.findElements(By.xpath("//tr/td[1]"));
		
		List <String> originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		// 2. 감자의 가격을 출력해요 
		
		// 2-1. 내가 해본 코드
		String targetVege="Potato";
		List<WebElement> vegeList=driver.findElements(By.xpath("//td[1]"));
		vegeList.stream().forEach(it->{
			if(it.getText().equals(targetVege)) {
				String price=it.findElement(By.xpath("./parent::tr/td[2]")).getText(); // ./: 현재 경로에서 시작 //: 절대경로에서 시작
				System.out.printf("price of %s : %s",targetVege,price);
			}
		});
		
		// 2-2. 수업 코드 - 페이지 이동하며 포테이토 찾기 
		driver.findElement(By.xpath("//tr//th[1]")).click();
		List<String> targetPriceList;
		do {
			List <WebElement> elementsList2=driver.findElements(By.xpath("//tr/td[1]"));
			targetPriceList=elementsList2.stream().filter(it->it.getText().contains(targetVege))
			.map(it->getPriceVeggie(it)).collect(Collectors.toList());
			
			if(targetPriceList.size()>0) {
				targetPriceList.forEach(it->System.out.printf("Price of %s: %s",targetVege,it));
			}else {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(targetPriceList.size()<=0);
		
	}
	

	private static String getPriceVeggie(WebElement it) {
		return it.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
