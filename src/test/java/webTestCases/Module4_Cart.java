package webTestCases;

import org.testng.annotations.Test;

import genericLib.BaseClass;

public class Module4_Cart extends BaseClass
{
	@Test
	public void tc001_Add_Product()
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
		webUtil.scrollTill(plp.getAddToCartBtn("Simple Computer"));
		webUtil.click(plp.getAddToCartBtn("Simple Computer"));
		webUtil.verifyIfDisplayed(pdp.getProductName("Simple Computer"));
		webUtil.click(pdp.getProcessorSlowRadioBtn());
		webUtil.click(pdp.getAddToCartBtn());
		webUtil.verifyIfDisplayed(pdp.getProductAddedMsg());
		webUtil.click(pdp.getCloseIcon());
		webUtil.closeBrowser();
	}
	
	@Test(dependsOnMethods = "tc001_Add_Product")
	public void tc002_Update_Product()
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
		webUtil.click(hp.getShoppingCartLink());
		webUtil.verifyIfDisplayed(cp.getShoppingCartHeader());
		webUtil.verifyIfDisplayed(cp.getAddedProduct("Simple Computer"));
		webUtil.clearAndEnterInputInto(cp.getProductQty("Simple Computer"), "5");
		webUtil.click(cp.getUpdateCartBtn());
		String val = webUtil.getAttributeOfElement(cp.getProductQty("Simple Computer"), "value");
		util.verifyExpString(val, "5");
		webUtil.closeBrowser();
	}
	
	@Test(dependsOnMethods = "tc001_Add_Product")
	public void tc003_Delete_Product()
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
		webUtil.click(hp.getShoppingCartLink());
		webUtil.verifyIfDisplayed(cp.getShoppingCartHeader());
		webUtil.verifyIfDisplayed(cp.getAddedProduct("Simple Computer"));
		webUtil.clearAndEnterInputInto(cp.getProductQty("Simple Computer"), "0");
		webUtil.click(cp.getUpdateCartBtn());
		webUtil.verifyIfDisplayed(cp.getEmptyCartText());
		webUtil.closeBrowser();
	}
}
