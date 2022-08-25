package com.onlineLeaveManagetestng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.lms.genericutility.BaseClass;
import com.edu.lms.genericutility.FileUtility;
import com.edu.lms.genericutility.LisImpClass;
import com.edu.lms.objectRepositoryUtility.ListDepartmentPage;
import com.onlineleavemanagement.ListDept;

public class ListDepartmentTest extends BaseClass {
	
	@Test(groups="regression")
	public void verifyListDepartmentTest() throws Throwable
	{
		//String abc= "sales22";
		ListDepartmentPage list=new ListDepartmentPage(driver);
		list.ListDepartment1();
//		FileUtility flib= new FileUtility();
//		String ADDDEP = flib.getPropertyKeyValue("deptName");
		//list.getDynamicXpath(ADDDEP);	
		
		//byte[] ADDDEP = null;
		//byte[] wb = null;
		//Assert.assertEquals(ADDDEP,list.getDynamicXpath(ADDDEP).getText());
		//System.out.println("test pass");
		
	
	}
	
	
		
		

}
