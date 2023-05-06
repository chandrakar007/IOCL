package pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionClass;
import base.BaseClass;



public class LoginPage extends BaseClass {
	
	public LoginPage() //Constructor of LoginPage used for initialization purpose.
	//Whenever we create an object of a class constructor gets called and we can initialize objects. 
	//We can have multiple classes for different features but driver should be one and sync with all.
	
   {
	//Initializing the Page Objects
	 PageFactory.initElements(driver, this);  //PageFactory is a class and initElements is a method.
//driver is coming from BaseClass and 'this' means it is pointing to the current class objects(all the variables of webElements(InputUsername,Inputpwd etc))
    //PageFactory.initElements(getDriver(), this);
	}
	
	//PageFactory- OR(Object Repository):
	   @FindBy(xpath="//input[@id='email']")
	   WebElement InputUsername;
	   @FindBy(xpath="//input[@placeholder='Enter password']")
	   WebElement Inputpswd;
	   @FindBy(xpath="(//button[normalize-space()='Log In'])[1]")
	   WebElement login;  
	   ////div[@id='toast-container']
	   @FindBy(xpath="//div[@id='toast-container']")
	   WebElement errorMessage;


  
	public HomePage loginApp(String uname, String pswd) {
		// TODO Auto-generated method stub
		ActionClass.type(InputUsername,uname);
		ActionClass.type(Inputpswd,pswd);
		ActionClass.click(driver,login);
		return new HomePage();	
	}
    }	
//		 InputUsername.sendKeys(userName);
//		   Inputpswd.sendKeys(password);
//		   login.click();
	
	
//	public String getErrorMessage() {
//		
//		waitForWebElementToAppear(errorMessage);
//		return errorMessage.getText(); 
//	
	
	
	 
	

	


