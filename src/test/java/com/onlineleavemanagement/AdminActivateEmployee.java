package com.onlineleavemanagement;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.Properties;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

import com.edu.lms.genericutility.ExcelUtility;
import com.edu.lms.genericutility.FileUtility;
import com.edu.lms.genericutility.JavaUtility;
import com.edu.lms.genericutility.WebDriverUtility;

//import com.edu.leavemanagement.genericlib.ExcelUtility;
	//import com.edu.leavemanagement.genericlib.FileUtility;
	//import com.edu.leavemanagement.genericlib.WebDriverUtility;

	import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminActivateEmployee
	{

		public static void main(String[] args) throws Throwable
		{
			
			WebDriver driver = null;
			WebDriverUtility wlib=new WebDriverUtility();
			FileUtility flib= new FileUtility();
			JavaUtility jlib= new JavaUtility();
			ExcelUtility elib=new ExcelUtility();


			//step 1: get properties from commondata
			//FileInputStream fis = new FileInputStream(".\\Data\\commonData.properties");
			//Properties prob = new Properties();
			//prob.load(fis);
			String URL = flib.getPropertyKeyValue("url");
			String USERNAME = flib.getPropertyKeyValue("username");
			String PASSWORD = flib.getPropertyKeyValue("password");
			String BROWSER = flib.getPropertyKeyValue("browser");
			
			
			Random r = new Random();
			int num=r.nextInt(1000);

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
			wlib.waitForElementInDOM(driver);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);

			//step 4: login to application
			driver.findElement(By.id("form-username")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);

			//step 5:Get data from excelsheet for admin
			driver.findElement(By.xpath("//ul[@class='sidebar-nav']/li[5]")).click();
			//FileInputStream fis1 = new FileInputStream(".\\Data\\excelsheet.xlsx");
			//Workbook book =	WorkbookFactory.create(fis1);
			//Sheet sh =book.getSheet("TestSheet");
			// step 6: add department
			//Random r = new Random();
			//	int num= r.nextInt();
			String deptName= elib.getExcelData("Admin_TestSheet", 1, 2);
			driver.findElement(By.id("dptName")).sendKeys(deptName +num,Keys.ENTER);
			// step 7: add designation
			driver.findElement(By.xpath("//ul[@class='sidebar-nav']/li[7]")).click();
			WebElement dd = driver.findElement(By.id("dptName"));
			Select s = new Select(dd);
			s.selectByVisibleText("AutoTesting"+num);
			String designationName= elib.getExcelData("Admin_TestSheet", 2, 2);
			driver.findElement(By.id("desiName")).sendKeys(designationName+num,Keys.ENTER);
			// step 8: add employee
			driver.findElement(By.xpath("//ul[@class='sidebar-nav']/li[9]")).click();
			WebElement empDept = driver.findElement(By.id("empDptName"));
			Select s1 = new Select(empDept);
			s1.selectByVisibleText("AutoTesting"+num);
			WebElement empDesignation = driver.findElement(By.id("empDesiName"));
			Select s2 = new Select(empDesignation);
			s2.selectByVisibleText("AutoTester"+num);
			String empCodeNumber= elib.getExcelData("Admin_TestSheet", 3, 2);
			driver.findElement(By.id("empCodeNum")).sendKeys(empCodeNumber+num,Keys.TAB);
			String emailAddress= elib.getExcelData("Admin_TestSheet", 4, 2);
			driver.findElement(By.id("empEmailAddress")).sendKeys(emailAddress,Keys.TAB);
			DataFormatter format = new DataFormatter();
			String empLoginPassword =elib.getExcelData("Admin_TestSheet", 5, 2);
			//String empLoginPassword= format.formatCellValue(eLib.getExcelData("TestSheet", 8, 4));
			
			driver.findElement(By.id("empLoginPass")).sendKeys(empLoginPassword,Keys.TAB);
			String empFirstName= elib.getExcelData("Admin_TestSheet", 6, 2);
			driver.findElement(By.id("empFirstName")).sendKeys(empFirstName+num,Keys.TAB);
			String empLastName= elib.getExcelData("Admin_TestSheet", 7, 2);
			driver.findElement(By.id("empLastName")).sendKeys(empLastName+num,Keys.TAB);
			//calender
			

			//WebElement caldob = driver.findElement(By.xpath("//*[@id='empDoB']"));
			//caldob.click();
			String empDOB=elib.getExcelData("Admin_TestSheet", 8, 2);
			//String empDOB= eLib.getExcelData("TestSheet", 8, 7);
			driver.findElement(By.xpath("//*[@id='empDoB']")).sendKeys(empDOB,Keys.TAB);
			WebElement empBloodGroup = driver.findElement(By.id("empBloodGroup"));
			Select s3 = new Select(empBloodGroup);
			s3.selectByVisibleText("O+");
			WebElement empGender = driver.findElement(By.id("empGender"));
			Select s4 = new Select(empGender);
			s4.selectByVisibleText("Female");
			String empPersonalNum=elib.getExcelDataWithDateFormat("Admin_TestSheet", 9, 2);
			//String empPersonalNum= eLib.getExcelData("TestSheet", 8, 8);
			driver.findElement(By.id("empPhoneNumPersonal")).sendKeys(empPersonalNum,Keys.TAB);
			String empOfficialNum=elib.getExcelDataWithDateFormat("Admin_TestSheet", 10, 2);
			//String empOfficialNum= eLib.getExcelData("TestSheet", 8, 9);
			driver.findElement(By.id("empPhoneNumOffice")).sendKeys(empOfficialNum,Keys.TAB);
			String empPermanentAddress=elib.getExcelDataWithDateFormat("Admin_TestSheet", 11, 2);
			//String empPermanentAddress= eLib.getExcelData("TestSheet", 8, 10);
			driver.findElement(By.id("empParmanentAddress")).sendKeys(empPermanentAddress,Keys.TAB);   
			String empPresentAddress=elib.getExcelDataWithDateFormat("Admin_TestSheet", 13, 2);
			//String empPresentAddress= eLib.getExcelData("TestSheet", 8, 11);
			driver.findElement(By.id("empPresentAddress")).sendKeys(empPresentAddress,Keys.ENTER);    
	         Thread.sleep(2000);
			//step 9: Verify in List Employee and activate
			driver.findElement(By.xpath(" //a[text()=' List Employee']")).click();
			WebElement verifyDD =driver.findElement(By.id("empDptName"));
			verifyDD.click();
			Select vs = new Select(verifyDD);
			vs.selectByVisibleText(deptName +num);
			driver.findElement(By.xpath("//table/tbody/tr[*]/td/following-sibling::td/button[text()='Active']")).click();
		}
	}
			
//			String actEmpid = eLib.getExcelData("TestSheet", 8, 2)+num;
//	        String expEmpid =driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='SE005+num']")).getText();
//	        if(actEmpid.equals(expEmpid))
//	        {
//	        	
//	        	System.out.println(actEmpid +"is added in employee list");
//	        	driver.findElement(By.xpath("//table/tbody/tr[*]/td/following-sibling::td/button[text()='Active']")).click();
//	        }
//	        else
//	        {
//	        	System.out.println(actEmpid +"is not added in employee list");
	//	
//	        }
//	        


