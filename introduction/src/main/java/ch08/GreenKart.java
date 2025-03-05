package ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/ohbom/Downloads/chromedriver-mac-arm64_v133/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		// 자바 리스트 생성 법
		// array: 사이즈 고정, 변경 불가, 속도 빠름  
		// arrayList: 사이즈 가변, 삽입/삭제 쉬움
		// ver1. array to List
		String[] itemsNeeded= {"Cucumber","Brocolli"};
		List itemList=Arrays.asList(itemsNeeded);
		
		// ver2. array to List short ver
		List<String> itemList2=new ArrayList<>(Arrays.asList("Cucumber","Brocolli"));
		
		// ver3
		List<String> itemList3=new ArrayList<>(List.of("Cucumber","Brocolli"));
		
		// 다양한 상품 중 오이만 담는 법
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		int cnt=0;
		for(int i=0;i<products.size();i++) {
			String name=products.get(i).getText();
			
			// 전처리 {상품명 - 1 Kg}에서 상품명만 추
			name=name.split("-")[0].trim();
			
			if(itemList.contains(name)) {
				// 이 코드의 문제: add to cart 버튼 텍스트가 added로 바뀌면서 해당하는 요소가 하나 없어지면서 인덱스 뒤로 밀
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				cnt++;
				if(cnt==itemList.size()) break;
			}
				
		}
		
	}

}
