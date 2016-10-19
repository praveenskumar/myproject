import java.sql.*;
import java.util.*;

public final class DBConnection
{

private static  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
private static  String user="";
private static  String password="";
private static  Connection con=null;

private DBConnection()
{}

public static Connection getConnection() throws SQLException,ClassNotFoundException
{
	try
	{
		//Step 1: code to Load the Driver
		//Class.forName(driverName); // programatically

	//	Driver d=new sun.jdbc.odbc.JdbcOdbcDriver();
	//	DriverManager.registerDriver(d);   //programatically

/*
//Mannually
Properties prop=new Properties();
prop.load(new java.io.FileInputStream("database.properties"));

driverName=prop.getProperty("jdbc.driver");
username=prop.getProperty("username");
password=prop.getProperty("password");
*/


/*
Class.forName(driverName);
Properties prop=new Properties();
prop.put("driver","sun.jdbc.odbc.JdbcOdbcDriver");
prop.put(user,new String(""));
prop.put(password,new String(""));
*/
Class.forName(driverName);
//con=DriverManager.getConnection("Jdbc:Odbc:Source1",prop);
		//con=DriverManager.getConnection("Jdbc:Odbc:Source1",username,password);


con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=password@123");

return con;


	}
	catch(ClassNotFoundException exe)
	{
		throw exe;

	}

	catch(SQLException exe)
		{
		throw exe;

	}


}





}