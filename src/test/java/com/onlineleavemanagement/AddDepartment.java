package com.onlineleavemanagement;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.edu.lms.genericutility.ExcelUtility;
import com.edu.lms.genericutility.FileUtility;
import com.edu.lms.genericutility.JavaUtility;
import com.edu.lms.genericutility.WebDriverUtility;
import com.edu.lms.objectRepositoryUtility.AddDeptPage;
import com.edu.lms.objectRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDepartment {
	

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib= new FileUtility();
		JavaUtility jlib= new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		
		
		
		WebDriver driver = null;
		  //step 1: get properties from commondata
				//FileInputStream fis = new FileInputStream(".\\Data\\commonData.properties");
				//Properties prob = new Properties();
				//prob.load(fis);
				String URL = flib.getPropertyKeyValue("url");
				String UN = flib.getPropertyKeyValue("username");
				String PWD = flib.getPropertyKeyValue("password");
				String BROWSER = flib.getPropertyKeyValue("browser");
				String ADDDEP = flib.getPropertyKeyValue("AddDept");
				
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
				
				
			          //step 4: login to application
				wlib.waitForElementInDOM(driver);
			    driver.get(URL);
			    LoginPage lp=new LoginPage(driver);
			    lp.loginToApp(UN,PWD);
				//driver.findElement(By.id("form-username")).sendKeys(UN,Keys.TAB,PWD,Keys.ENTER);
				
			         //step 5: Add Department
			    AddDeptPage add = new AddDeptPage(driver);
			    add.AddDepartment1(ADDDEP);
			   
			    String success= driver.findElement(By.xpath("//h3[text()='Department Created Successfully']")).getText();
				System.out.println(success);
				
}

	
}
