package utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver);

	public void afterNavigateTo(String url, WebDriver driver);

	public void beforeChangeValueOf(WebElement element, WebDriver driver);

	public void afterChangeValueOf(WebElement element, WebDriver driver);

	public void beforeClickOn(WebElement element, WebDriver driver);

	public void afterClickOn(WebElement element, WebDriver driver);

	public void beforeNavigateBack(WebDriver driver);

	public void afterNavigateBack(WebDriver driver);

	public void beforeNavigateForward(WebDriver driver);

	public void afterNavigateForward(WebDriver driver);

	public void onException(Throwable error, WebDriver driver);

	public void beforeFindBy(By by, WebElement element, WebDriver driver);

	public void afterFindBy(By by, WebElement element, WebDriver driver);

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver);

	public void afterScript(String script, WebDriver driver);

	public void beforeAlertAccept(WebDriver driver);

	public void afterAlertAccept(WebDriver driver);

	public void afterAlertDismiss(WebDriver driver);

	public void beforeAlertDismiss(WebDriver driver);

	public void beforeNavigateRefresh(WebDriver driver);

	public void afterNavigateRefresh(WebDriver driver);

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend);

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend);

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1);

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2);

	public void afterSwitchToWindow(String arg0, WebDriver arg1);

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0);

	public void beforeGetText(WebElement arg0, WebDriver arg1);

	public void beforeSwitchToWindow(String arg0, WebDriver arg1);

}
