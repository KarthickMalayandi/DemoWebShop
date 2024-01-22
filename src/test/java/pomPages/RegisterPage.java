package pomPages;

import org.openqa.selenium.By;

public class RegisterPage 
{
	By firstNameTF=By.xpath("//input[@id='FirstName']");
	
	By lastNameTF=By.xpath("//input[@id='LastName']");
	
	By emailTF=By.xpath("//input[@id='Email']");
	
	By pwdTF=By.xpath("//input[@id='Password']");
	
	By confirmPwdTF=By.xpath("//input[@id='ConfirmPassword']");
	
	By registerBtn=By.xpath("//input[@id='register-button']");
	
	By registrationSuccessMsg=By.xpath("//div[normalize-space(text())='Your registration completed']");

	By alreadyRegisteredErrorMsg=By.xpath("//li[text()='The specified email already exists']");
	
	public By getAlreadyRegisteredErrorMsg() {
		return alreadyRegisteredErrorMsg;
	}

	public By getRegistrationSuccessMsg() {
		return registrationSuccessMsg;
	}

	public By getGenderRadioBtn(String gender) {
		return By.xpath("//input[@id='gender-"+gender+"']");
	}

	public By getFirstNameTF() {
		return firstNameTF;
	}

	public By getLastNameTF() {
		return lastNameTF;
	}

	public By getEmailTF() {
		return emailTF;
	}

	public By getPwdTF() {
		return pwdTF;
	}

	public By getConfirmPwdTF() {
		return confirmPwdTF;
	}

	public By getRegisterBtn() {
		return registerBtn;
	}
}
