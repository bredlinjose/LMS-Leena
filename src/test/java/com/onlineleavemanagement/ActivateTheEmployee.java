package com.onlineleavemanagement;

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
import com.edu.lms.objectRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActivateTheEmployee {

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
				
				
				
			          //step 4: login to application
				wlib.waitForElementInDOM(driver);
			    driver.get(URL);
				//driver.findElement(By.id("form-username")).sendKeys(UN,Keys.TAB,PWD,Keys.ENTER);
			    LoginPage loginPage=new LoginPage(driver);
			    loginPage.loginToApp(UN,PWD);
				
			         //step 5: Add Department
				driver.findElement(By.linkText("Add Department")).click();
			    
			    
				
		            //step 6: get datas from excelsheet
			    //FileInputStream fis1 = new FileInputStream(".\\Data\\TestCaseData.xlsx");
				//Workbook book =	WorkbookFactory.create(fis1);
				
				 //Sheet sh =book.getSheet("CreateNewDept"); 
				 //String DeptName= sh.getRow(1).getCell(2).getStringCellValue();
				String DeptName= elib.getExcelData("CreateNewDept", 1, 2);		
				driver.findElement(By.id("dptName")).sendKeys(DeptName,Keys.ENTER);
				String success= driver.findElement(By.xpath("//h3[text()='Department Created Successfully']")).getText();
				System.out.println(success);
				//List Department
				driver.findElement(By.xpath("//a[text()=' List Department']")).click();
				//wlib.executeJavaScriptScroll(driver, "window.scrollBy(0,3000);");
				String deptNa =driver.findElement(By.xpath("//table/tbody/tr[*]/td[text()='"+DeptName+"']")).getText();
				if(deptNa.contains(DeptName))
				{
					System.out.println("Test pass");
				}
				else
				{
					System.out.println("Test Fail");
				}
				
				    //step 7: Add Designation
				driver.findElement(By.xpath("//a[text()=' Add Designation']")).click();
				WebElement AddDept=driver.findElement(By.id("dptName"));
		        Select s=new Select(AddDept);
		        s.selectByVisibleText("BOE");
		        //Sheet sh1 =book.getSheet("CreateNewDept");
		        //String DesigName= sh.getRow(2).getCell(2).getStringCellValue();
		        String DesigName=elib.getExcelData("CreateNewDept", 2, 2);
		        driver.findElement(By.xpath("//input[@id='desiName']")).sendKeys(DesigName,Keys.ENTER);
		        String success1 = driver.findElement(By.xpath("//h3[@class='text-success']")).getText();
		        System.out.println(success1);
		        driver.findElement(By.xpath("//ul[@class='sidebar-nav']/li[9]")).click();
				WebElement empDept = driver.findElement(By.id("empDptName"));
				Select s1 = new Select(empDept);
				s1.selectByVisibleText("AutoTesting");
				WebElement empDesignation = driver.findElement(By.id("empDesiName"));
				Select s2 = new Select(empDept);
				s2.selectByVisibleText("AutoTester");
				String empCodeNumber= elib.getExcelData("CreateNewDept", 2, 2);
				driver.findElement(By.id("empCodeNum")).sendKeys(empCodeNumber,Keys.TAB);
				String emailAddress= elib.getExcelData("CreateNewDept", 3, 2);
				driver.findElement(By.id("empEmailAddress")).sendKeys(emailAddress,Keys.TAB);
				String empLoginPassword= elib.getExcelData("CreateNewDept", 4, 2);
				driver.findElement(By.id("empLoginPass")).sendKeys(empLoginPassword,Keys.TAB);
				String empFirstName= elib.getExcelData("CreateNewDept", 5, 2);
				driver.findElement(By.id("empFirstName")).sendKeys(empFirstName,Keys.TAB);
				String empLastName= elib.getExcelData("CreateNewDept", 6, 2);
				driver.findElement(By.id("empLastName")).sendKeys(empLastName,Keys.TAB);
				//calender
				String empDOB= elib.getExcelData("CreateNewDept", 7, 2);
				WebElement caldob = driver.findElement(By.xpath("//*[@id='empDoB']"));
				caldob.click();

				

				WebElement empBloodGroup = driver.findElement(By.id("empBloodGroup"));
				Select s3 = new Select(empBloodGroup);
				s3.selectByVisibleText("O+");
				WebElement empGender = driver.findElement(By.id("empGender"));
				Select s4 = new Select(empGender);
				s4.selectByVisibleText("Female");
				String empPersonalNum= elib.getExcelData("CreateNewDept", 8, 2);
				driver.findElement(By.id("empPhoneNumPersonal")).sendKeys(empPersonalNum,Keys.TAB);
				String empOfficialNum= elib.getExcelData("CreateNewDept", 9, 2);
				driver.findElement(By.id("empPhoneNumOffice")).sendKeys(empOfficialNum,Keys.TAB);
				String empPermanentAddress= elib.getExcelData("CreateNewDept", 10, 2);
				driver.findElement(By.id("empParmanentAddress")).sendKeys(empPermanentAddress,Keys.TAB);    
				String empPresentAddress= elib.getExcelData("CreateNewDept", 11, 2);
				driver.findElement(By.id("empPresentAddress")).sendKeys(empPresentAddress,Keys.ENTER);    

				//step 9: Verify in List Employee
				driver.findElement(By.linkText(" List Employee")).click();
				String actEmpid = elib.getExcelData("CreateNewDept", 2, 2);
		        String expEmpid =driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='SE005']")).getText();
		        if(actEmpid.equals(expEmpid))
		        {
		        	
		        	System.out.println(actEmpid +"is added in employee list");
		        	driver.findElement(By.xpath("//table/tbody/tr[*]/td/following-sibling::td/button[text()='Active']")).click();
		        }
		        else
		        {
		        	System.out.println(actEmpid +"is not added in employee list");
			
		        }
		        
		       
		        }

		
		}



