package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class HomePageTest extends BaseClass{ //controlShiftO to extend BaseClass

	LoginPage loginpage; 
	HomePage homepage;

	public HomePageTest() {
		super(); //Used to call BaseClass constructor 
	}
	
	@BeforeMethod
	public void setup() {
		launchApp();
	    loginpage = new LoginPage();
	    homepage= loginpage.loginApp(prop.getProperty("username"), prop.getProperty("password"));
	    
	}
	
	@Test(priority=1)
	public void verifygetHomePageTitle() {
	String homePageTitle=homepage.getHomePageTitle();
	Assert.assertEquals(homePageTitle, "Welcome To XTRAPOWER Fleet Card","Home Page title not matched");
		
	}
	
	@Test(priority=2)
	public void verifygetUserName() {
		Assert.assertTrue(homepage.getUserName());
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
}}
