package ch16;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotations {
	
	@BeforeClass	
	public void beforeClass() {
		System.out.println("before the class ");
	}
	
	@AfterClass	
	public void afterClass() {
		System.out.println("after the class ");
	}
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test ex. db 초기화 ");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	@BeforeMethod // xml파일과 관계없이 모든 method 앞에서 수행, ex) 쿠키 캐치 
	public void beforeMethod() {
		System.out.println("before every method");
	}
	
	@Test
	public void annotationTest() {
		// appium
		System.out.println("annotation Test");
	}
	
	@Test(groups={"grouptest"})
	public void grouptest1() {

		System.out.println("grouptest1");
	}
	
	@Test(groups={"grouptest"})
	public void grouptest2() {

		System.out.println("grouptest2");
	}
	
	@Test(groups={"grouptest"})
	public void grouptest3() {

		System.out.println("grouptest3");
	}


}
