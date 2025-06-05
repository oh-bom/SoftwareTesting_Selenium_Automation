package ch32;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) {
		ChromeDriver driver= new ChromeDriver();
		
		DevTools devTools=driver.getDevTools();
		
		Map<String,Object> coordinates=new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitutde", 3);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC201b")).get(0).click();
		
		String title=driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.print(title);
	}

}
