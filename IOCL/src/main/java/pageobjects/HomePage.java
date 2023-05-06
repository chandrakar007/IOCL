package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {

	//Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	} 

	@FindBy(xpath = "//span[normalize-space()='Admin']")
	WebElement adminlink;
	
	@FindBy(xpath="//span[@class='d-none d-xl-inline-block ms-1 font-size-13']")
	WebElement userName;
	
	@FindBy(xpath = "//span[normalize-space()='Customer']")
	WebElement customerLink;

	@FindBy(xpath = "//span[normalize-space()='Merchant']")
	WebElement merchantLink;
	
		
	public String getHomePageTitle() {
		return driver.getTitle();  
		//"Welcome To XTRAPOWER Fleet Card"	
	}
	
	public boolean getUserName() {
		return userName.isDisplayed(); 
		//"Welcome To XTRAPOWER Fleet Card"	
	}
	
//	public AdminMenu clickOnAdminLink() {
//		adminlink.click();
//		return new AdminMenu();	
//	}
	
	public CustomerMenu clickOnCustomerLink() {
		customerLink.click();
		return new CustomerMenu();	
	}
	
	public MerchantMenu clickOnMerchantLink() {
		customerLink.click();
		return new MerchantMenu();	
	}
}
