package pomPages;

import org.openqa.selenium.By;

public class CartPage {

	By shoppingCartHeader=By.xpath("//h1[text()='Shopping cart']");
	
	By updateCartBtn=By.xpath("//input[@value='Update shopping cart']");
	
	By emptyCartText=By.xpath("//div[normalize-space(text())='Your Shopping Cart is empty!']");

	public By getEmptyCartText() {
		return emptyCartText;
	}

	public By getUpdateCartBtn() {
		return updateCartBtn;
	}

	public By getShoppingCartHeader() {
		return shoppingCartHeader;
	}

	public By getAddedProduct(String product) {
		return By.xpath("//table[@class='cart']//td[@class='product']/a[@class='product-name' and text()='"+product+"']");
	}

	public By getProductQty(String product) {
		return By.xpath("//tr[@class='cart-item-row']//a[text()='"+product+"']/ancestor::table//input[@class='qty-input']");
	}
	
	
}
