package rahulshettyacademy.testComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup(); //pom.xml에 dependency 추가후 사용
			
			ChromeOptions options= new ChromeOptions();
	
			if(browserName.contains("headless")) {
				options.addArguments("--headless=new");
			}
			
			driver= new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); // full-screen
			
		}else {
			// 다른 브라우저들 
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		return driver;
	}
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//String to HashMap - Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference <List<HashMap<String,String>>>(){
			
		});
		
		return data;
			
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File newFile=new File(System.getProperty("user.dir")+"/reports/"+testCaseName+".png");
		FileUtils.copyFile(source, newFile);
		return System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public void launchApplication() throws IOException {
		driver=initializeDriver();
		landingPage= new LandingPage(driver);
		landingPage.goTo();
//		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
}
