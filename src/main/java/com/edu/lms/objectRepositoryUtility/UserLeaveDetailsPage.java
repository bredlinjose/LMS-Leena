package com.edu.lms.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.lms.genericutility.ExcelUtility;
import com.edu.lms.genericutility.JavaUtility;

public class UserLeaveDetailsPage {
	WebDriver driver;
	
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
	public UserLeaveDetailsPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver= driver;
}
	@FindBy(xpath = "//a[contains(text(),'Leave Details')]")
	private WebElement UserDetailsLink;
	
	@FindBy(xpath ="//a[text()='Go back ']")
	private WebElement GoBack;

	@FindBy(xpath="//table//tbody//tr//td//a[text()='BOE0001']")
	private WebElement EmployeeCode;
	
	@FindBy(xpath="//h1[contains(text(),'Leave History')]")
	private WebElement Result;
	
	public WebElement getUserDetailsLink() {
		return UserDetailsLink;
	}

	public WebElement getGoBack() {
		return GoBack;
	}

	public WebElement getEmployeeCode() {
		return EmployeeCode;
	}

	public WebElement getResult() {
		return Result;
	}


    public void uldetails()
    {
    	UserDetailsLink.click();
    	GoBack.click();
    	EmployeeCode.click();
    	
    
    }
    }
