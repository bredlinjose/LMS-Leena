package com.onlineleavemanagement;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.edu.lms.genericutility.ExcelUtility;
import com.edu.lms.genericutility.FileUtility;
import com.edu.lms.genericutility.JavaUtility;
import com.edu.lms.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

		public class UserLeaveDetails {
		

			public static void main(String[] args) throws Throwable
			{
				
				WebDriver driver = null;
				WebDriverUtility wlib=new WebDriverUtility();
				FileUtility flib= new FileUtility();
				JavaUtility jlib= new JavaUtility();
				ExcelUtility elib=new ExcelUtility();


				 //step 1: Get properties from commondata
				
				String URL = flib.getPropertyKeyValue("url");
				String USERNAME = flib.getPropertyKeyValue("username");
				String PASSWORD = flib.getPropertyKeyValue("password");
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
				wlib.waitForElementInDOM(driver);
				driver.get(URL);

				//step 4: login to application
				driver.findElement(By.id("form-username")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);

                 Thread.sleep(1000);
				//step 5: User Details
				driver.findElement(By.xpath("//a[contains(text(),'Leave Details')]")).click();
				driver.findElement(By.xpath("//a[text()='Go back ']")).click();
				WebElement wb=driver.findElement(By.xpath("//table//tbody//tr//td//a[text()='BOE0001']"));
				wb.click();
				String expRes=driver.findElement(By.xpath("//h1[contains(text(),'Leave History')]")).getText();
			    String actRes = "Leave History For : BOE0001";
			    if(actRes.equalsIgnoreCase(expRes))
			    {
			    	System.out.println("test pass");
			    }
			    else
			    {
			    	System.out.println("test fail");
			    }
			    }

			 
			    
				
	}


