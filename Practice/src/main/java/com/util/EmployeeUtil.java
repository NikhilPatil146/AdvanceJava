package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeeUtil {

	public static Connection createConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_2","root","");
		} catch (Exception e) {
           e.printStackTrace();
		}
		return conn;
	}
}
