package androidTestCases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import genericLib.BaseClass;

public class MobileWebTC extends BaseClass{

	@Test
	public void tc001_Registration() throws MalformedURLException, InterruptedException
	{
		androidUtil.openChromeAndroidApp_BS("Google Pixel 6 Pro", "13");
		androidUtil.enterUrlIntoBrowser("https://demowebshop.tricentis.com/");
		androidUtil.setImplicitWait(10);
		androidUtil.verifyIfDisplayed(hp.getRegisterLink());
		androidUtil.tapOn(hp.getRegisterLink());
		androidUtil.tapOn(rp.getGenderRadioBtn("male"));
		androidUtil.enterInputInto(rp.getFirstNameTF(), "Dummy");
		androidUtil.enterInputInto(rp.getLastNameTF(), "User");
		String gmail = util.generateRandomGmail();
		androidUtil.enterInputInto(rp.getEmailTF(), gmail);
		androidUtil.enterInputInto(rp.getPwdTF(), "Ka@12345");
		androidUtil.enterInputInto(rp.getConfirmPwdTF(), "Ka@12345");
		androidUtil.hideAndroidKeyBoard();
		androidUtil.tapOn(rp.getRegisterBtn());
		androidUtil.verifyIfDisplayed(rp.getRegistrationSuccessMsg());
		androidUtil.closeBrowserApp();
		
	}
	
	@Test
	public void tc002_Login() throws MalformedURLException, InterruptedException
	{
		androidUtil.openChromeAndroidApp_BS("Google Pixel 6 Pro", "13");
		androidUtil.enterUrlIntoBrowser("https://demowebshop.tricentis.com/");
		androidUtil.setImplicitWait(10);
		androidUtil.verifyIfDisplayed(hp.getRegisterLink());
		androidUtil.tapOn(hp.getLoginLink());
		androidUtil.enterInputInto(lp.getEmailTF(), "mkar@gmail.com");
		androidUtil.enterInputInto(lp.getPwdTF(), "Ka@12345");
		androidUtil.hideAndroidKeyBoard();
		androidUtil.tapOn(lp.getLogInBtn());
		androidUtil.verifyIfDisplayed(hp.getAccountName("mkar@gmail.com"));
		androidUtil.closeBrowserApp();
	}
}
