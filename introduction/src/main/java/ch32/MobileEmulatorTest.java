package ch32;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.emulation.Emulation;
public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		
		// send commands to CDP Methods
		// CDP methods will invoke and get access to chrome dev tools
		devTools.send(Emulation.setDeviceMetricsOverride(600,1000 , 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Library")).click();
	
	}

}
