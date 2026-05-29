package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
	public void getDBconnection(String url, String username, String password) throws SQLException {
		try{
			Driver driver= new Driver();
		
		DriverManager.registerDriver(driver);
		
		 con= DriverManager.getConnection(url, username, password);
		}catch(Exception e) {}
		
		
	}
	
	public void getDBconnection() throws SQLException {
		try{
			Driver driver= new Driver();
		
		DriverManager.registerDriver(driver);
		
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3307/ninja_hrm", "root", "root");
		}catch(Exception e) {}
		
		
	}
	public void closeDbconnection() throws SQLException {
		try{con.close();
		}
		catch(Exception e) {}
	}
	public ResultSet executeConSelectQuery(String query) throws SQLException {
		ResultSet result= null;
	

		try{Statement stat =con.createStatement();
		 result= stat.executeQuery(query);
		} catch(Exception e) {}
			return result;
		}
	public int executeNonselectQuery (String query1) {
		int result =0;
		
		
		try{Statement stat =con.createStatement();
		 result= stat.executeUpdate(query1);
		} catch(Exception e) {}
			return result;
			
		}
		
	
		
		
	
	

}
