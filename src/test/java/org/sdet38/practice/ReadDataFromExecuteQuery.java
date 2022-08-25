package org.sdet38.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromExecuteQuery {

	public static void main(String[] args) throws SQLException 
	{
      //step 1: create driver
		Driver driverRerf = new Driver();
		
		Connection connection = null;
		 
	// step 2: register the driver to JDBC
		DriverManager.registerDriver(driverRerf);
		
	//step 3: Establish the connection - database name
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		
	//step 4: create statement 
		Statement statement =connection.createStatement();
		
	// step 5: execute query - table name
		String query ="select * from empdetails;";
		String expectedData ="Praju";
		ResultSet result = statement.executeQuery(query);
		
	//step 6: validate
		boolean flag = false;
		while(result.next())
		{
			String actualData =result.getString(2);
			if(expectedData.equalsIgnoreCase(actualData))
			{
				System.out.println(actualData);
				flag = true; //flag raising 
				break;
				
			}
			
		}
		if(flag==true)
		{
			System.out.println("data is present in the database");
		}
		else
		{
			System.out.println("data is not present in database");
		}
		
	//step 7: close connection
		connection.close();
		System.out.println("connection closed");
	}

}