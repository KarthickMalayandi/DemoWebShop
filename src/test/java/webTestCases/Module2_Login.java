package webTestCases;

import org.testng.annotations.Test;

import genericLib.BaseClass;

public class Module2_Login extends BaseClass
{

	@Test
	public void tc001_Valid_Data()
	{
		webUtil.openBrowser("Chrome");
		webUtil.maximizeBrowser();
		webUtil.navigateTo("https://demowebshop.tricentis.com/");
		webUtil.setImplicitWait(20);
		webUtil.click(hp.getLoginLink());
		webUtil.enterInputInto(lp.getEmailTF(), "mkar@gmail.com");
		webUtil.enterInputInto(lp.getPwdTF(), "Ka@12345");
		webUtil.click(lp.getLogInBtn());
		webUtil.verifyIfDisplayed(hp.getAccountName("mkar@gmail.com"));
		webUtil.closeBrowser();
	}
	
	@Test
	public void tc002_Invalid_Data()
	{
		webUtil.openBrowser("Edge");
		webUtil.maximizeBrowser();
		webUtil.navigateTo("https://demowebshop.tricentis.com/");
		webUtil.setImplicitWait(20);
		webUtil.click(hp.getLoginLink());
		webUtil.enterInputInto(lp.getEmailTF(), "karti@hotmail.com");
		webUtil.enterInputInto(lp.getPwdTF(), "Ka@12345");
		webUtil.click(lp.getLogInBtn());
		webUtil.verifyIfDisplayed(lp.getLoginUnsuccessErrorMsg());
		webUtil.closeBrowser();
	}
}
