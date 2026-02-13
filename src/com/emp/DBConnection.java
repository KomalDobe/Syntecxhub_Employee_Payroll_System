package com.emp;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnection {

	    static final String URL = "jdbc:mysql://localhost:3306/payrolldb";
	    static final String USER = "root";
	    static final String PASSWORD = "komal@123";

	    public static Connection getConnection() throws Exception {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}



