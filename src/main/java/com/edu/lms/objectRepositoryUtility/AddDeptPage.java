package com.edu.lms.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.lms.genericutility.ExcelUtility;
import com.edu.lms.genericutility.JavaUtility;

public class AddDeptPage {
	WebDriver driver;
		
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		public AddDeptPage (WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			this.driver= driver;
	}
	
		
		@FindBy(linkText = "Add Department")
		private WebElement AddDepartmentLink;
		
		@FindBy(id="dptName")
		private WebElement DepartmentText;

		@FindBy(name="btnSubmit")
		private WebElement AddDeptBtn;
		
		@FindBy(xpath="//h3[text()='Department Created Successfully']")
		private WebElement success;
		
		
		


		public WebElement getSuccess() {
			return success;
		}


		public WebElement getAddDepartmentLink() {
			return AddDepartmentLink;
		}


		public WebElement getDepartmentText() {
			return DepartmentText;
		}


		public WebElement getAddDeptBtn() {
			return AddDeptBtn;
		}


		public void AddDepartment1 (String AddDept) throws Throwable
		
		{
			
			AddDepartmentLink.click();
			DepartmentText.sendKeys(AddDept + jlib.getRanDomNumber());
			AddDeptBtn.click();
			
		}
		
		
		
	}




