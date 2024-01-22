package pomPages;

import org.openqa.selenium.By;

public class HomePage 
{
	By registerLink=By.xpath("//a[text()='Register']");
	
	By loginLink=By.xpath("//a[@class='ico-login']");
	
	By computerTab=By.xpath("//ul[@class='top-menu']//a[normalize-space(text())='Computers']");
	
	By destopsSubTab=By.xpath("//ul[@class='top-menu']//a[normalize-space(text())='Desktops']");
	
	By searchTF=By.xpath("//input[@value='Search store']");
	
	By shoppingCartLink=By.xpath("//span[text()='Shopping cart']");

	public By getShoppingCartLink() {
		return shoppingCartLink;
	}

	public By getSearchTF() {
		return searchTF;
	}

	public By getSearchSuggestion(String suggestion) 
	{
		return By.xpath("//li[@class='ui-menu-item']//a[text()='"+suggestion+"']");
	}
	
	public By getComputerTab() {
		return computerTab;
	}

	public By getDestopsSubTab() {
		return destopsSubTab;
	}

	public By getRegisterLink() {
		return registerLink;
	}

	public By getLoginLink() {
		return loginLink;
	}
	
	public By getAccountName(String name)
	{
		return By.xpath("//a[text()='"+name+"']");
	}
}
