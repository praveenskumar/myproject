import java.sql.*;

public final class DBConnection
{
	private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String username="";
	private static String password="";
	private static Connection con=null;

	public static Connection getConnection() throws ClassNotFoundException,SQLException
	{
		try
		{
			Class.forName(driverName);
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=password@123");
		}
		catch(ClassNotFoundException exe)
		{
			throw exe;
		}

		catch(SQLException exe)
		{
			throw exe;
		}

		return con;
	}
}