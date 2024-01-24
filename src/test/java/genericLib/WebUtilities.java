package genericLib;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtilities {

	WebDriver driver;
	
	public void openBrowser(String browserName)
	{
		String name = browserName.toLowerCase();
		
		switch (name) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("--disable-dev-shm-usage");
			driver=new ChromeDriver(chromeOpt);
			Reporter.log("Chrome browser is opened", true);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt =new FirefoxOptions();
			firefoxOpt.addArguments("--disable-dev-shm-usage");
			driver=new FirefoxDriver(firefoxOpt);
			Reporter.log("FireFox browser is opened", true);
			break;	
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOpt=new EdgeOptions();
			edgeOpt.addArguments("--disable-dev-shm-usage");
			driver=new EdgeDriver(edgeOpt);
			Reporter.log("Edge browser is opened", true);
			break;	
		default:
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt1 = new ChromeOptions();
			chromeOpt1.addArguments("--disable-dev-shm-usage");
			driver=new ChromeDriver(chromeOpt1);
			Reporter.log("Chrome browser is opened", true);
			break;
		}
	}
	
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized", true);
	}
	
	public void navigateTo(String url)
	{
		driver.get(url);
		Reporter.log("Navigated to "+url, true);
	}
	
	public void setImplicitWait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		Reporter.log("Implicit wait set to : "+seconds+" seconds", true);
	}
	
	public void click(By locator)
	{
		String name = driver.findElement(locator).getText();
		if(name.isBlank())
		{
			name=driver.findElement(locator).getAttribute("textContent");
		}
		driver.findElement(locator).click();
		Reporter.log(name+" is clicked", true);
	}
	
	public void enterInputInto(By locator, String input)
	{
		String name = driver.findElement(locator).getText();
		if(name.isBlank())
		{
			name=driver.findElement(locator).getAttribute("textContent");
		}
		driver.findElement(locator).sendKeys(input);
		Reporter.log("Entered "+input+" into "+name, true);
	}
	
	public void clearAndEnterInputInto(By locator, String input)
	{
		String name = driver.findElement(locator).getText();
		if(name.isBlank())
		{
			name=driver.findElement(locator).getAttribute("textContent");
		}
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(input);
		Reporter.log("Cleared and entered "+input+" into "+name, true);
	}
	
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser is closed", true);
	}
	
	public void verifyIfDisplayed(By locator)
	{
		String name = driver.findElement(locator).getText();
		if(name.isBlank())
		{
			name=driver.findElement(locator).getAttribute("textContent");
		}
		driver.findElement(locator).isDisplayed();
		Reporter.log(name+" is displayed", true);
	}
	
	public void mouseHoverOn(By locator)
	{
		String name = driver.findElement(locator).getText();
		if(name.isBlank())
		{
			name=driver.findElement(locator).getAttribute("textContent");
		}
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(locator));
		a.perform();
		Reporter.log("Mouse hovered on "+name, true);
	}
	
	public void scrollTill(By locator)
	{
		String name = driver.findElement(locator).getText();
		if(name.isBlank())
		{
			name=driver.findElement(locator).getAttribute("textContent");
		}
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
		Reporter.log("Scrolled till "+name, true);
	}
	
	public String getAttributeOfElement(By locator, String attributeName)
	{
		String val = driver.findElement(locator).getAttribute(attributeName);
		Reporter.log("Value of "+attributeName+" attribute is "+val, true);
		return val;
	}
	
}
