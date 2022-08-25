package org.sdet38.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException 
	{
	
		//Step 1:- use file input stream to load the property file //
		FileInputStream fis =new FileInputStream(".\\Data\\commondata.properties");
		
		//Step 2:- create object for properties and load the file //
		Properties prop =new Properties();
		prop.load(fis);
		
		//Step 3:- provide the key to read the value//
		String URL=prop.getProperty("url");
		System.out.println(URL);
		
		String USERNAME=prop.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD=prop.getProperty("password");
		System.out.println(PASSWORD);
		

		String BROWSER=prop.getProperty("browser");
		System.out.println(BROWSER);
		
		
	}

}
