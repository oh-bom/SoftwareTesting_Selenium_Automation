package ch32;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		Map deviceMetrics=new HashMap();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 100);
		deviceMetrics.put("mobile", true);
		
		String commandStr="Emulation.setDeviceMetricsOverride";
		
		driver.executeCdpCommand(commandStr, deviceMetrics);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Library")).click();
	}

}
