
package testcases;

import java.awt.AWTException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import pageobjects.CustomerMenu;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class CustomerMenuTest extends BaseClass {
	LoginPage loginpage; 
	HomePage homepage;
	CustomerMenu customermenu;
	
	
	public CustomerMenuTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		launchApp();
		loginpage = new LoginPage();
	    homepage= loginpage.loginApp(prop.getProperty("username"), prop.getProperty("password"));
	    customermenu= homepage.clickOnCustomerLink();
	}


	@Test(dataProvider = "customerinfo", dataProviderClass = DataProviders.class)
	public void verifyAddCustomer(Map<String, String> datamap) throws InterruptedException, AWTException {
		customermenu.getStartPage(datamap.get("PAN No"), datamap.get("PIN Code"));
		customermenu.uploadImage();
		Assert.assertTrue(true);
		customermenu.clickOnUploadBtn();

		Assert.assertTrue(true);
		customermenu.clickOnConfirmBtn();
		Assert.assertTrue(true);
    	customermenu.fillBasicInformation(datamap.get("CustomerType"), datamap.get("SubCustomerType"),
				datamap.get("Stateoffice"), datamap.get("DivisionOffice"), datamap.get("Transport Hub "),
				datamap.get("Form Number"), datamap.get("Customer Name"), datamap.get("Name on Card"),
				datamap.get("Constitution"));
		customermenu.NextButton();
		Assert.assertTrue(true, "Next button is clickable");

		customermenu.fillPermanentAddressPage(datamap.get("Address 1"), datamap.get("City"), datamap.get("State"),
				datamap.get("District"),datamap.get("Mobile"),datamap.get("Email"));
	    customermenu.fillKeyOfficialPage(datamap.get("KeyOfficialName"), datamap.get("KeyOfficialMobile"));

	}

	@AfterMethod	
	public void tearDown() {
		driver.quit();
	}
}
