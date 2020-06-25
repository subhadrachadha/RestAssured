package com.students.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDataFromExcelSheet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://172.16.3.121:3306/bus","subhadra.singh","yatra@123");
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from city_master limit 5 \\G;");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		con.close();  
		}
		catch(Exception e)
		{ System.out.println(e);}
		}  
		
	
}
