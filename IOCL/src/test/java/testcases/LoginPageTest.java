package testcases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.BaseClass;
import dataprovider.DataProviders;
import pageobjects.CustomerMenu;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginpage;    
	HomePage homepage;
	CustomerMenu cstmrprofile;
	
	public LoginPageTest() {
		super(); //Used to call BaseClass constructor 
	}
	
	@BeforeMethod
	public void setup() {
		launchApp();
		LoginPage loginpage = new LoginPage();
	}

//	@Parameters("browser")
//	@BeforeMethod
//	public void setup(String browser) {
//		launchApp(browser);
//	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}


	@Test(priority=1, description="Login to Application")//It run three times bcz of invocationCount=3 is define
	public void verifyLoginPage() {
		LoginPage loginpage = new LoginPage();
		homepage = loginpage.loginApp(prop.getProperty("username"), prop.getProperty("password")); // This is by
																										// usng
																										// properties
																										// file
		boolean img = driver.findElement(By.xpath("//img[@src='assets/images/ioc/logo.png']")).isDisplayed();
		Assert.assertTrue(img);
	}

	//@Ignore   //or mention in test (enable=false)
	@Test(priority=2, description="Verify the title", groups= {"Sanity"})
	private void verifyTitle() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Welcome To XTRAPOWER Fleet Card1";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		

	//@Ignore   //or mention in test (enable=false)
//		@Test(priority=2, description="Verify the title", dependsOnMethods= {"verifyLoginPage"}, groups= {"Sanity"})
//	public void verifyLoginPage(String UserName, String Password) {
//	LoginPage loginpage=new LoginPage();
//	cstmrprofile=loginpage.loginApp(UserName, Password);

//	@Test(dataProvider="LoginCredentials", dataProviderClass=DataProviders.class)
//	public void verifyLoginPage(Map<String,String> datamap) {
//	LoginPage loginpage=new LoginPage();
//	cstmrprofile=loginpage.loginApp(datamap.get("UserName"),
//			datamap.get("Password"));

	}
}
