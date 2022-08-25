package com.onlineleavemanagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineLeaveApplication  {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = null;
  //step 1: get properties from commondata
		FileInputStream fis = new FileInputStream(".\\Data\\commonData.properties");
		Properties prob = new Properties();
		prob.load(fis);
		String URL = prob.getProperty("url");
		String UN = prob.getProperty("username");
		String PWD = prob.getProperty("password");
		String BROWSER = prob.getProperty("browser");
		
	//step 2: launch browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
	//step 3: Open application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20,);
		driver.get(URL);
		
	//step 4: login to application
		driver.findElement(By.id("form-username")).sendKeys(UN,Keys.TAB,PWD,Keys.ENTER);
		
	//step 5: Add Department
		driver.findElement(By.linkText("Add Department")).click();
		
// //step 6: get datas from excelsheet
	FileInputStream fis1 = new FileInputStream(".\\Data\\testdata.xlsx");
		Workbook book =	WorkbookFactory.create(fis1);
		Sheet sh =book.getSheet("Sheet1");
        String DeptName= sh.getRow(3).getCell(0).getStringCellValue();
		driver.findElement(By.id("dptName")).sendKeys(DeptName,Keys.ENTER);
//		String empLeaveReason =sh.getRow(7).getCell(7).getStringCellValue();
//		driver.findElement(By.id("livReason")).sendKeys(empLeaveReason,Keys.TAB);
//	    String fromdate =sh.getRow(8).getCell(7).getStringCellValue();
//		driver.findElement(By.id("livEmplivFrom")).sendKeys(fromdate);
//		
	}

}