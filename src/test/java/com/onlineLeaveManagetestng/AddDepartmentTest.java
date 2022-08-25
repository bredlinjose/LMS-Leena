package com.onlineLeaveManagetestng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.lms.genericutility.BaseClass;
import com.edu.lms.genericutility.FileUtility;
import com.edu.lms.objectRepositoryUtility.AddDeptPage;

@Listeners(com.edu.lms.genericutility.LisImpClass.class)
public class AddDepartmentTest extends BaseClass
{

	FileUtility flib= new FileUtility();
	
	@Test
	public void verifyAddDepartTest() throws Throwable
	{
		String d1= flib.getPropertyKeyValue("deptName");
		AddDeptPage add = new AddDeptPage(driver);
	    add.AddDepartment1(d1);
	  //validation
		String ExpectedRes="Department Created Successfully" ;
		String ActualRes=add.getSuccess().getText();
		Assert.assertEquals(ActualRes, ExpectedRes);
		
		    //if(ActualRes.equalsIgnoreCase(ExpectedRes)) {
			System.out.println("Test case pass");
		    }
			}
	


