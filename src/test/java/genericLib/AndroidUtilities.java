package genericLib;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class AndroidUtilities {

	AndroidDriver driver;
	
	public void openAndroidApp(String appPackage, 
			String appActivity, String deviceName,
			Boolean noReset, Boolean autoGrantPermission) throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformName", "Android");
		cap.setCapability("noReset", noReset);
		if (noReset==false) 
		{
			cap.setCapability("autoGrantPermissions", true);
		} 
		
		driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"),cap);
	}
	
	public void openChromeAndroidApp_BS(String deviceName, String platformVersion) throws MalformedURLException
	{
		String userName="karthickm_8iF4SC";
		String accessKey="9cmMWtfcAofz2tZerxqW";
		String url = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
		DesiredCapabilities cap=new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("browserName", "chrome");
		browserstackOptions.put("deviceName", deviceName);
		browserstackOptions.put("realMobile", "true");
		browserstackOptions.put("osVersion", platformVersion);
		cap.setCapability("bstack:options", browserstackOptions);
		
		driver=new AndroidDriver(new URL(url),cap);
        Reporter.log("ChromeBrowser app is opened", true);
	}
	
	public void setImplicitWait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		Reporter.log("Implicit wait set to : "+seconds, true);
	}
	
	public void enterUrlIntoBrowser(String url)
	{
		driver.get(url);
		Reporter.log("Navigated to "+url, true);
	}
	
	public void hideAndroidKeyBoard()
	{
		driver.hideKeyboard();
		Reporter.log("Keyboard hided", true);
	}
	
	public void tapOn(By locator)
	{
		String name = driver.findElement(locator).getText();
		driver.findElement(locator).click();
		Reporter.log("Tapped on "+name, true);
	}
	
	public Boolean verifyIfDisplayed(By locator)
	{
		String name = driver.findElement(locator).getText();
		if (driver.findElement(locator).isDisplayed()) {
			Reporter.log(name+" is displayed", true);
			return true;
		}else
		{
			Reporter.log(name+" is not displayed", true);
			return false;
		}
	}
	
	public void enterInputInto(By locator, String input)
	{
		String name = driver.findElement(locator).getText();
		driver.findElement(locator).sendKeys(input);
		Reporter.log("Entered "+input+" into "+name, true);
	}
	
	public void closeBrowserApp()
	{
		driver.quit();
		Reporter.log("Closed browser app", true);
	}
}
