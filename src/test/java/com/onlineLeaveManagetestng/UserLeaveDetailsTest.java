package com.onlineLeaveManagetestng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.lms.genericutility.BaseClass;
import com.edu.lms.objectRepositoryUtility.UserLeaveDetailsPage;

public class UserLeaveDetailsTest extends BaseClass {
    @Test
	public void verifyUserLeaveDetailsTest() throws Throwable
	{
    	UserLeaveDetailsPage ul=new UserLeaveDetailsPage(driver);
    	ul.uldetails();
    	//validation
    	String ExpectedRes="Leave History For : BOE0001" ;
		String ActualRes=ul.getResult().getText();
		Assert.assertEquals(ActualRes, ExpectedRes);
		System.out.println("Test case pass");
	}
    	
	}
