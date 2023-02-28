package com.javastack.JDBCCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class JdbcCrud 
{	
	public static void main(String[] args) throws SQLException, ParseException ,Exception
	{
		Connection connection=JDBCStatement.getConnection();
		Scanner scanner = new Scanner(System.in);		
		System.out.print("Enter the name of the table to be modified : ");
		String tableName=scanner.next();
		CRUDOperation crudObject=new CRUDOperation(connection);
		
		//Question1
		crudObject.insertDataUsingStatement(tableName,scanner);
		crudObject.readDataUsingStatement(tableName);
		crudObject.updateRecord(tableName,scanner);
		crudObject.deleteRecordUsingStatement(tableName,scanner);
		
		//Question2
		crudObject.insertDataUsingWithSQLDate(tableName,scanner);
		crudObject.retrieveDataWithDatesInMultipleFormats(tableName);
		
		crudObject.deleteAllRecordsUsingStatement(tableName);
		
		//Question3
		crudObject.insertDataUsingPreparedStatement(tableName, scanner);
		crudObject.readDataUsingPreparedStatement(tableName);
		crudObject.updateRecordUsingPreparedStatement(tableName,scanner);
		crudObject.deleteRecordUsingPreparedStatement(tableName,scanner);
		crudObject.deleteAllRecordsUsingPreparedStatement(tableName);
		
		//Closing Connection
		JDBCStatement.closeConnection(connection);
	}
}

class CRUDOperation
{
	private Connection connection;
	private ResultSet resultSet=null;
	public CRUDOperation(Connection connection)
	{
		this.connection=connection;
	}

	public void insertDataUsingWithSQLDate(String tableName,Scanner scanner) throws SQLException, ParseException
	{
		Statement statement=this.connection.createStatement();
		
		System.out.print("Enter the number of records to be created : ");
		
		int n=scanner.nextInt(),id=0;
		String query="INSERT into "+tableName+" values",name=null,address=null,gender=null;
		java.util.Date dob,doj;
		String dom;
		
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		
		for(int t=0;t<n;t++)
		{
			System.out.print("Enter Student Id    : ");
			id=scanner.nextInt();
			System.out.print("Enter Student Name  : ");
			name=scanner.next();
			System.out.print("Enter Student Address  : ");
			address=scanner.next();
			System.out.print("Enter Student Gender  : ");
			gender=scanner.next();
			System.out.print("Enter Student DOB : ");
			dob=df.parse(scanner.next());
			System.out.print("Enter Student DOJ : ");
			doj=df.parse(scanner.next());
			System.out.print("Enter Student DOM : ");
			dom=scanner.next();
			query+= (t==n-1) ?"("+id+",'"+name+"','"+address+"','"+gender+"','"+new java.sql.Date(dob.getTime())+"','"+new java.sql.Date(doj.getTime())+"','"+java.sql.Date.valueOf(dom)+"')":"("+id+",'"+name+"','"+address+"','"+gender+"','"+new java.sql.Date(dob.getTime())+"','"+new java.sql.Date(doj.getTime())+"','"+ java.sql.Date.valueOf(dom)+"'),";			
		} 
		System.out.println(query);
		int count=statement.executeUpdate(query);
		System.out.println(count==n?"All the given records are inserted into"+tableName+"table successfully" : "Please check your query");
	}

	public void deleteAllRecordsUsingStatement(String tableName) throws SQLException 
	{
		connection.createStatement().executeUpdate("DELETE from "+tableName);
		System.out.println("All the records in the table "+tableName+" deleted successfully");
	}
	
	public void deleteAllRecordsUsingPreparedStatement(String tableName) throws SQLException 
	{
		connection.prepareStatement("DELETE from "+tableName).executeUpdate();
		System.out.println("All the records in the table "+tableName+" deleted successfully");
	}

	public void deleteRecordUsingStatement(String tableName,Scanner scanner) throws SQLException 
	{
		Statement statement=connection.createStatement();
		System.out.println("Before Deleting record");
		readDataUsingStatement(tableName);
		System.out.print("Enter the Id of the student to be removed : ");
		int id=scanner.nextInt();
		statement.executeUpdate("DELETE from "+tableName+" where Student_Id="+id);
		System.out.println("After Deleting record having Id "+id);
		readDataUsingStatement(tableName);
	}
	
	public void deleteRecordUsingPreparedStatement(String tableName, Scanner scanner) throws SQLException 
	{
		System.out.println("Before Deleting record");
		readDataUsingPreparedStatement(tableName);
		int id=0;
		System.out.print("Enter the  Id  and Name of the student to be removed : ");
		System.out.print("Student Id : ");
		id=scanner.nextInt();
		System.out.print("Student Name : ");
		String name=scanner.next();
		PreparedStatement statement=connection.prepareStatement("DELETE from "+tableName+" where Student_Name=? and Student_Id=?");
		statement.setString(1, name);
		statement.setInt(2, id);
		statement.executeUpdate();
		System.out.println("After Deleting record having Name "+name+" and Id "+id);
		readDataUsingPreparedStatement(tableName);
	}
	
	public void retrieveDataWithDatesInMultipleFormats(String tableName) throws SQLException 
	{
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("SELECT * from "+tableName);
		System.out.println("Student_ID\tStudent_Name\tStudent_Address\tStudent_Gender\tStudent_DOB\tStudent_DOJ\tStudent_DOM");
		while(resultSet.next())
			System.out.print(resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+new SimpleDateFormat("dd-MM-yyyy").format(resultSet.getDate(5))+"\t"+new SimpleDateFormat("MM-dd-yyyy").format(resultSet.getDate(6))+"\t"+resultSet.getDate(7)+"\n");
	}
	
	public void insertDataUsingStatement(String tableName,Scanner scanner) throws SQLException, ParseException
	{
		Statement statement=this.connection.createStatement();
			
		System.out.print("Enter the number of records to be created : ");
		
		int n=scanner.nextInt(),id=0;
		String query="INSERT into "+tableName+" values",name=null,address=null,gender=null;
		java.util.Date dob,doj,dom;
		
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		
		for(int t=0;t<n;t++)
		{
			System.out.print("Enter Student Id    : ");
			id=scanner.nextInt();
			System.out.print("Enter Student Name  : ");
			name=scanner.next();
			System.out.print("Enter Student Address  : ");
			address=scanner.next();
			System.out.print("Enter Student Gender  : ");
			gender=scanner.next();
			System.out.print("Enter Student DOB : ");
			dob=df.parse(scanner.next());
			System.out.print("Enter Student DOJ : ");
			doj=df.parse(scanner.next());
			System.out.print("Enter Student DOM : ");
			dom=df.parse(scanner.next());
			query+= (t==n-1) ?"("+id+",'"+name+"','"+address+"','"+gender+"','"+new java.sql.Date(dob.getTime())+"','"+new java.sql.Date(doj.getTime())+"','"+new java.sql.Date(dom.getTime())+"')":"("+id+",'"+name+"','"+address+"','"+gender+"','"+new java.sql.Date(dob.getTime())+"','"+new java.sql.Date(doj.getTime())+"','"+new java.sql.Date(dom.getTime())+"'),";			
		} 
		System.out.println(query);
		int count=statement.executeUpdate(query);
		System.out.println(count==n?"All the given records are inserted into"+tableName+"table successfully" : "Please check your query");
	}
	
	
	public void insertDataUsingPreparedStatement(String tableName, Scanner scanner) throws Exception 
	{
		PreparedStatement statement=null;
		System.out.print("Enter the number of records to be created : ");
		int n=scanner.nextInt(),
			id=0;
		String query="INSERT into "+tableName+" values",
			   name=null,
			   address=null,
			   gender=null;
		
		java.util.Date dob,
		              doj,
		              dom;
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		int count=0;
		for(int t=0;t<n;t++)
		{
			statement=this.connection.prepareStatement("INSERT into "+tableName+" VALUES (?,?,?,?,?,?,?)");
			System.out.print("Enter Student Id    : ");
			id=scanner.nextInt();
			System.out.print("Enter Student Name  : ");
			name=scanner.next();
			System.out.print("Enter Student Address  : ");
			address=scanner.next();
			System.out.print("Enter Student Gender  : ");
			gender=scanner.next();
			System.out.print("Enter Student DOB : ");
			dob=df.parse(scanner.next());
			System.out.print("Enter Student DOJ : ");
			doj=df.parse(scanner.next());
			System.out.print("Enter Student DOM : ");
			dom=df.parse(scanner.next());
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, address);
			statement.setString(4, gender);
			statement.setDate(5, new java.sql.Date(dob.getTime()));
			statement.setDate(6, new java.sql.Date(doj.getTime()));
			statement.setDate(7, new java.sql.Date(dom.getTime()));
			count+=statement.executeUpdate();
			statement.close();
		} 
		System.out.println(count==n ? "All the given records are inserted into"+tableName+"table successfully" : "Please check your query");
	}
	
	
	public  void updateRecord(String tableName,Scanner scanner) throws SQLException 
	{
		Statement statement=connection.createStatement();
		System.out.print("Enter the id of the student for which modification is required : ");
		int id=scanner.nextInt();
		System.out.println("Before Updation!..");
		readDataUsingStatement(tableName);
		System.out.print("Enter the Name to be updated : ");
		String nameToBeUpdated=scanner.next();
		statement.executeUpdate("update "+tableName+" SET Student_Name='"+nameToBeUpdated+"' WHERE Student_Id="+id);
		System.out.println("After Updation!..");
		readDataUsingStatement(tableName);
	}
	
	
	public void updateRecordUsingPreparedStatement(String tableName, Scanner scanner) throws SQLException 
	{
		System.out.println("Before Updation!..");
		readDataUsingPreparedStatement(tableName);
		System.out.print("Enter the id of the student for which modification is required : ");
		int id=scanner.nextInt();
		System.out.print("Enter the Name to be updated : ");
		String nameToBeUpdated=scanner.next();
		PreparedStatement statement=connection.prepareStatement("UPDATE "+tableName+" SET Student_Name=? WHERE Student_Id=?");
		statement.setString(1, nameToBeUpdated);
		statement.setInt(2, id);
		statement.executeUpdate();
		System.out.println("After Updation!..");
		readDataUsingPreparedStatement(tableName);
	}
	
	
	public  void readDataUsingStatement(String tableName) throws SQLException 
	{
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("SELECT * from "+tableName);
		System.out.println("Student_ID\tStudent_Name\tStudent_Address\tStudent_Gender\tStudent_DOB\tStudent_DOJ\tStudent_DOM");
		while(resultSet.next())
		{
			System.out.print(resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t\t"+resultSet.getDate(5)+"\t"+resultSet.getDate(6)+"\t"+resultSet.getDate(7));
			System.out.println();
		}
		if(resultSet!=null)
			resultSet.close();
		if(statement!=null)
			statement.close();
	}
	
	
	public void readDataUsingPreparedStatement(String tableName) throws SQLException
	{
		PreparedStatement statement=connection.prepareStatement("SELECT * from "+tableName);
		resultSet=statement.executeQuery();
		System.out.println("Student_ID\tStudent_Name\tStudent_Address\tStudent_Gender\tStudent_DOB\tStudent_DOJ\tStudent_DOM");
		while(resultSet.next())
		{
			System.out.print(resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getDate(5)+"\t"+resultSet.getDate(6)+"\t"+resultSet.getDate(7));
			System.out.println();
		}
		if(resultSet!=null)
			resultSet.close();
		if(statement!=null)
			statement.close();
	}
}

class JDBCStatement 
{
	public static Connection getConnection() throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsbase", "root", "root@#123");
		return connection;
	}
	
	public static void closeConnection( Connection connection)	throws SQLException 
	{
		if (connection != null) 
			connection.close();
	}
}
