package com.edu.lms.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.lms.genericutility.FileUtility;

public class ListDepartmentPage {
	
	

	WebDriver driver;
	

	public ListDepartmentPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver= driver;
    }
	
	@FindBy(xpath ="//a[text()=' List Designation']")
	private WebElement ListDepartmentLink;
	
	//@FindBy(xpath="//table//tbody//tr[*]/td[text()='"+ADDDEP+"']")
	//private WebElement Result;
	
	
	//public WebElement getResult() {
		//return Result;
	//}

	

	public void ListDepartment1 ()
	
	{
		ListDepartmentLink.click();
		
	}

	public WebElement getListDepartmentLink() {
		return ListDepartmentLink;
	}

	
	//public WebElement getDynamicXpath(String ADDDEP)
	//{
		
		//WebElement wb=driver.findElement(By.xpath("//table/tbody/tr/td[text()='Sales899']"));
		//return wb;
	//}


}
