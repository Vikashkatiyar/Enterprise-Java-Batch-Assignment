package com.javastack.JDBCStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {
	
	public static Connection getConnection() throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsbase", "root", "root@#123");
		return connection;
	}
	
	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection)	throws SQLException 
	{
		if (resultSet != null)
			resultSet.close();

		if (statement != null) 
			statement.close();

		if (connection != null) 
			connection.close();
	}
}
