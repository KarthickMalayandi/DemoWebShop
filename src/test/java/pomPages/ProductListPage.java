package pomPages;

import org.openqa.selenium.By;

public class ProductListPage 
{
	By desktopsHeader=By.xpath("//h1[text()='Desktops']");
	
	public By getDesktopsHeader() {
		return desktopsHeader;
	}

	public By getAddToCartBtn(String productName) 
	{
		return By.xpath("//a[text()='"+productName+"']/../..//input[@value='Add to cart']");
	}
}
