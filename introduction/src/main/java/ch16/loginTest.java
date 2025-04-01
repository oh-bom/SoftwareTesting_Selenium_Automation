package ch16;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class loginTest {
	
	@Parameters({"URL","APKKey/username"})
	@Test
	public void WebLogin(String urlname,String ApiKey) {
		// selenium
		System.out.println("Web login");
		System.out.println(urlname); // xml에 선언해둔 글로벌 상수 가졍
		System.out.println(ApiKey);
	}
	
	@Test
	public void MobileLogin() {
		// appium
		System.out.println("Mobile login");
	}
	
	@Test(timeOut=4000)
	public void MobileSignIn() {
		// appium
		System.out.println("Mobile SignIn");
	}
	@Test(enabled=false)
	public void MobileSignOut() {
		// appium
		System.out.println("Mobile SingOut");
	}
	
	@Test(dependsOnMethods= {"WebLogin","MobileLogin"}) // webLogin, MobileLogin 실행 후 해당함수 실행 
	public void LoginApi() {
		// restful api
		System.out.println("Login api");
	}
	
	@Test(groups={"grouptest"})
	public void grouptest3() {

		System.out.println("grouptest in logintest");
	}
	
	@Test(dataProvider="getData")
	public void getDataTest(String username, String password) {
		System.out.println(username+password);
	}
	
	@DataProvider
	public Object[][] getData() {
		// 1st combination - username, password - good credit history
		// 2nd -username password - no credit history
		// 3rd  fraudelent credit history
		Object[][] data=new Object[3][2];
		
		// 1st
		data[0][0]="first username";
		data[0][1]="first password";
		
		// 2nd
		data[1][0]="second username";
		data[1][1]="second password";
		
		// 3rd
		data[2][0]="third username";
		data[2][1]="third password";
		
		return data;
	}
}
