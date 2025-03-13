package ch14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenCartSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
		String targetVege="Rice";
		driver.findElement(By.xpath("//input[@id='search-field']")).click();
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(targetVege);
		List<WebElement> searchResultElement=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> searchResult=searchResultElement.stream().map(it->it.getText()).collect(Collectors.toList());
		List<String> targetList;
		
		do {
			List <WebElement> elementsList=driver.findElements(By.xpath("//tr/td[1]"));
			targetList=elementsList.stream().filter(it->it.getText().contains(targetVege)).map(it->it.getText())
					.collect(Collectors.toList());
			
			if(targetList.size()<=0) driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			
		}while(targetList.size()<=0);
		Assert.assertEquals(searchResult, targetList);
	}
	

}
