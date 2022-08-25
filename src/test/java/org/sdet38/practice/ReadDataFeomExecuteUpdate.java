package org.sdet38.practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFeomExecuteUpdate {

	public static void main(String[] args) throws SQLException
	{

	      //step 1: create driver
			Driver driverRerf = new Driver();
			
			Connection connection = null;
			 
		// step 2: register the driver to JDBC
			DriverManager.registerDriver(driverRerf);
			
		//step 3: Establish the connection - database name
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet38", "root", "root");
			
		//step 4: create statement 
			Statement statement =connection.createStatement();
			
		// step 5: execute query - table name
			String query ="insert into empdetails values(102,'Raj',98766570,'Bengaluru');";
			int result = statement.executeUpdate(query);
			System.out.println(result);
			
		//step 6: validate
			if(result==1)
			{
				System.out.println("data added successfully");
			}
			else
			{
				System.out.println("data does not added");
			}
			
		//step 7: close connection
			connection.close();
			System.out.println("connection closed");
	}

}

