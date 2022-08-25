package com.edu.lms.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LisImpClass implements ITestListener{
	public void onTestSuccess(ITestResult result) {
		JavaUtility jlib= new JavaUtility();
		String date=jlib.getSystemDateInIST();
		String testName= result.getMethod().getMethodName();
		System.out.println("============Execute and am listening=============");
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File("./ScreenShot/" +testName+date+ ".png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}


