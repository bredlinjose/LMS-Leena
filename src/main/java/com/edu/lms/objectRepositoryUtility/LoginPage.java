package com.edu.lms.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
}
	
	@FindBy(id="form-username")
	private WebElement CodeEdt;

	@FindBy(id="form-password")
	private WebElement PasswordEdt;

	@FindAll({@FindBy(name="btnSubmit"), @FindBy(xpath="//button[text()='Log In!']")})
	private WebElement loginBtn;
	
	    
	    
	    public WebElement getCodeEdt() {
		return CodeEdt;
	}



	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}



	public WebElement getLoginBtn() {
		return loginBtn;
	}



		public void loginToApp(String username,String password)
	    {
			CodeEdt.sendKeys(username);
			PasswordEdt.sendKeys(password);
	    	loginBtn.click();
	    }
	    	
	    }
	    
	    
    




