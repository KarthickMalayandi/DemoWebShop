package webTestCases;

import org.testng.annotations.Test;

import genericLib.BaseClass;

public class Module3_Search extends BaseClass {

	@Test
	public void tc001_Search_via_NavigationBar()
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
		webUtil.mouseHoverOn(hp.getComputerTab());
		webUtil.click(hp.getDestopsSubTab());
		webUtil.verifyIfDisplayed(plp.getDesktopsHeader());
		webUtil.closeBrowser();
	}
	
	@Test
	public void tc002_Search_via_SearchTF()
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
		webUtil.enterInputInto(hp.getSearchTF(), "computer");
		webUtil.click(hp.getSearchSuggestion("Simple Computer"));
		webUtil.verifyIfDisplayed(pdp.getProductName("Simple Computer"));
		webUtil.closeBrowser();
	}
}
