package pomPages;

import org.openqa.selenium.By;

public class ProductDescriptionPage {

	By processorSlowRadioBtn=By.xpath("//label[normalize-space(text())='Processor']/ancestor::dl//label[normalize-space(text())='Slow']");
	
	By addToCartBtn=By.xpath("//input[@class='button-1 add-to-cart-button']");
	
	By productAddedMsg=By.xpath("//p[text()='The product has been added to your ']");
	
	By closeIcon=By.xpath("//span[@class='close']");
	
	public By getProductName(String name) 
	{
		return By.xpath("//div[@class='product-name']/h1[normalize-space(text())='"+name+"']");
	}

	public By getProcessorSlowRadioBtn() {
		return processorSlowRadioBtn;
	}

	public By getAddToCartBtn() {
		return addToCartBtn;
	}

	public By getProductAddedMsg() {
		return productAddedMsg;
	}

	public By getCloseIcon() {
		return closeIcon;
	}
}
