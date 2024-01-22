package pomPages;

import org.openqa.selenium.By;

public class LoginPage {

	By emailTF=By.xpath("//input[@id='Email']");
	
	By pwdTF=By.xpath("//input[@id='Password']");
	
	By logInBtn=By.xpath("//input[@value='Log in']");
	
	By loginUnsuccessErrorMsg=By.xpath("//div[@class='validation-summary-errors']");

	public By getEmailTF() {
		return emailTF;
	}

	public By getPwdTF() {
		return pwdTF;
	}

	public By getLogInBtn() {
		return logInBtn;
	}

	public By getLoginUnsuccessErrorMsg() {
		return loginUnsuccessErrorMsg;
	}
}
