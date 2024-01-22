package webTestCases;

import org.testng.annotations.Test;

import genericLib.BaseClass;

public class Module1_Registration extends BaseClass{

	@Test
	public void tc001_Valid_Data()
	{
		webUtil.openBrowser("Chrome");
		webUtil.maximizeBrowser();
		webUtil.navigateTo("https://demowebshop.tricentis.com/");
		webUtil.setImplicitWait(20);
		webUtil.click(hp.getRegisterLink());
		webUtil.click(rp.getGenderRadioBtn("male"));
		webUtil.enterInputInto(rp.getFirstNameTF(), "Dummy");
		webUtil.enterInputInto(rp.getLastNameTF(), "User");
		String gmail = util.generateRandomGmail();
		webUtil.enterInputInto(rp.getEmailTF(), gmail);
		webUtil.enterInputInto(rp.getPwdTF(), "Ka@12345");
		webUtil.enterInputInto(rp.getConfirmPwdTF(), "Ka@12345");
		webUtil.click(rp.getRegisterBtn());
		webUtil.verifyIfDisplayed(rp.getRegistrationSuccessMsg());
		webUtil.closeBrowser();
	}
	@Test
	public void tc002_Invalid_Data()
	{
		webUtil.openBrowser("Edge");
		webUtil.maximizeBrowser();
		webUtil.navigateTo("https://demowebshop.tricentis.com/");
		webUtil.setImplicitWait(20);
		webUtil.click(hp.getRegisterLink());
		webUtil.click(rp.getGenderRadioBtn("male"));
		webUtil.enterInputInto(rp.getFirstNameTF(), "Dummy");
		webUtil.enterInputInto(rp.getLastNameTF(), "User");
		webUtil.enterInputInto(rp.getEmailTF(), "mkar@gmail.com");
		webUtil.enterInputInto(rp.getPwdTF(), "Ka@12345");
		webUtil.enterInputInto(rp.getConfirmPwdTF(), "Ka@12345");
		webUtil.click(rp.getRegisterBtn());
		webUtil.verifyIfDisplayed(rp.getAlreadyRegisteredErrorMsg());
		webUtil.closeBrowser();
	}
}
