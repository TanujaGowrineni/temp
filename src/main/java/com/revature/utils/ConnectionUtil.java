package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static ConnectionUtil instance;
	
	private ConnectionUtil() {
		super();
	}
	
	public static ConnectionUtil getInstance() {
		if(instance == null) {
			instance = new ConnectionUtil();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		//For many frameworks using JDBC or working with JDBC it is necessary
		//to "register" the driver. Letting the framework know what Driver
		//JDBC is using. This is not always required for base JDBC projects. 
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://javafs220404.ckelth81wx17.eu-west-2.rds.amazonaws.com:5432/demos";
		String username = "postgres"; //It is possible to hide raw credentials using Env variables
		String password = "password"; //You can access those variables with System.getenv("var-name")
	
		return DriverManager.getConnection(url, username, password);
	}
	
//	public static void main(String[] args) {
//		try {
//			getConnection();
//			System.out.println("Connection Successful");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	

}
