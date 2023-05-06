package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.ActionClass;
import base.BaseClass;

public class CustomerProfile extends BaseClass {

	public CustomerProfile() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Customer']")
	WebElement cstmr;
	@FindBy(xpath = "//a[normalize-space()='Cards']")
	WebElement card;
	@FindBy(xpath = "//ul[@class='sub-menu h-100 mm-collapse ng-star-inserted d-block']//a[@class='side-nav-link-ref ng-star-inserted'][normalize-space()='Profile']")
	WebElement profile;
	@FindBy(xpath = "//a[@class='btn btn-primary align-items-center ng-star-inserted']")
	WebElement addcstmr;
	@FindBy(xpath = "//div[@class='main']//input[@id='pan1']")
	WebElement enterPan;
	@FindBy(css = "input[role='combobox']")
	WebElement enterPinCode;
	@FindBy(xpath = "//input[@id='pan1'][1]")
	WebElement clickPan;
	@FindBy(xpath = "//input[@id='pan1'][1]")
	WebElement AgainnPan;
	@FindBy(xpath = "//button[@type='button'][text()='Confirm']")
	WebElement confirmBtn;
	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement customerType;
	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement subcustomerType;
	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement stateOffice;
	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement divisionOfc;
	 @FindBy(xpath="(//input[@type='text'])[9]")
	 WebElement trnsprtHub;
	 @FindBy(xpath="//input[@placeholder='Form Number']")
	 WebElement formNo;
	 @FindBy(xpath="//input[@placeholder='Application Date']")
	 WebElement applDate;
	 @FindBy(xpath="//select[@class='form-select form-control rounded-end-0 ng-pristine ng-valid ng-touched']")
	 WebElement mrMrs;
	 @FindBy(xpath="//input[@placeholder='Customer Name']")
	 WebElement custName;	 
	 @FindBy(xpath="//input[@placeholder='Name on Card']")
	 WebElement NameOnCard; 
	 @FindBy(xpath="(//input[@type='text'])[17]")
	 WebElement constitution;
	 @FindBy(xpath="//div[@class='card-body pt-0']//form//div//button[text()='Next ']")
	 WebElement NextBtn;
	
	 
	 
	 
//	

	public void getStartPage(String pAN, String pincode) {

		ActionClass.click(driver, cstmr);
		ActionClass.click(driver, profile);
		ActionClass.click(driver, addcstmr);
		ActionClass.type(enterPan, pAN);
		ActionClass.type(enterPinCode, pincode);

	}

	public void uploadImage() throws AWTException, InterruptedException {

		WebElement fileUpload = driver.findElement(By.xpath("//div[@class='main']//input[@type='file']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", fileUpload);

		Robot rb = new Robot();
		rb.delay(2000);
		// put path to file in a clipboard
		StringSelection ss = new StringSelection("F:\\IOCL_Automation_Data\\Logo\\imageiocl.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// CTRL+V
		rb.keyPress(KeyEvent.VK_CONTROL); // Press on CTRL key
		rb.keyPress(KeyEvent.VK_V); // Press on CTRL key

		rb.keyRelease(KeyEvent.VK_CONTROL); // Press on CTRL key
		rb.keyRelease(KeyEvent.VK_V); // Press on CTRL key
		// Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10);
	}

	public void clickOnUploadBtn() {

		driver.findElement(By.xpath("//div[@class='main']//button[@type='button'][normalize-space()='Upload']"))
				.click();
		driver.findElement(By.xpath("//div[@class='main']//button[@type='button'][normalize-space()='Upload']"))
				.click();
	}

	public void clickOnConfirmBtn() {

		ActionClass.click(driver, confirmBtn);
	}
	
	public void fillBasicInformation(String cusType, String subCusType,String stOffice,String divOffice,
			String trnsportHub,String formNumber,String appDate,String MrMrs,String cusName,String nameOnCard,
			String cnstitutn) throws AWTException {
	
		Robot rb=new Robot();
		
		ActionClass.waitForWebElementToAppear(customerType);
  	    rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(customerType, cusType);
  	    rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(subcustomerType, subCusType);
		rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(stateOffice, stOffice);
		rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(divisionOfc, divOffice);
		rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(trnsprtHub, trnsportHub);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		
		ActionClass.type(formNo, formNumber);
		rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(applDate, appDate);
		rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(mrMrs, MrMrs);
		rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(custName, cusName);
		rb.keyPress(KeyEvent.VK_ENTER);
		ActionClass.type(NameOnCard, nameOnCard);
		ActionClass.type(constitution, cnstitutn);
		rb.keyPress(KeyEvent.VK_ENTER);		
	}
	public void NextButton() {
		
	ActionClass.click(driver, NextBtn);
		
	}
}
