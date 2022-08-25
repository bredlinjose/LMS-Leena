package com.edu.lms.genericutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.edu.lms.objectRepositoryUtility.LoginPage;
import com.edu.lms.objectRepositoryUtility.LogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	/* Object Creation for Lib */
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public static WebDriver sdriver;
	/* Initialization */
	String URL;
	String UN;
	String PWD;
	String BROWSER;

	@BeforeSuite(groups = "regression")
	public void configBS() {
		System.out.println("==================== Connect the DataBase ====================");	
	}

	@BeforeClass(groups = "regression")
	public void configBC() throws Throwable {
		System.out.println("==================== Launch the Browser ====================");
		
		BROWSER = flib.getPropertyKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
         sdriver = driver;
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);	
	}
	
	@BeforeMethod(groups = "regression")
	public void configBM() throws Throwable {
		System.out.println("==================== Login the Application ====================");
		URL = flib.getPropertyKeyValue("url");
		UN = flib.getPropertyKeyValue("username");
		PWD = flib.getPropertyKeyValue("password");
		driver.get(URL);
		LoginPage lg = new LoginPage(driver);
		lg.loginToApp(UN, PWD);
	}

	@AfterMethod(groups = "regression")
	public void configAM() {
		System.out.println("==================== Logout the Application ====================");
		
		LogoutPage lt = new LogoutPage(driver);
		lt.logoutFromApp();
	}

	@AfterClass(groups = "regression")
	public void configAC() {
		System.out.println("==================== Close the Browser ====================");
		
		driver.quit();
	}

	@AfterSuite(groups = "regression")
	public void configAS() {
		System.out.println("==================== Close the DataBase ====================");
	}
}