import java.sql.*;

public class ProductImplementation implements ProductInterface
{

	private Connection con;

	public ProductImplementation() throws SQLException,ClassNotFoundException
	{
		try
		{
			con=DBConnection.getConnection();
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
	//insert method begins
	public int insert(String id,String name,int price,int qty) throws SQLException
	{
	int rowAffected=0;
	try(PreparedStatement pstmt=con.prepareStatement("insert into Product values(?,?,?,?)");)
	{
		pstmt.setString(1,id);
		pstmt.setString(2,name);
		pstmt.setInt(3,price);
		pstmt.setInt(4,qty);
		rowAffected=pstmt.executeUpdate();
	}
	catch(SQLException exe)
	{
		throw exe;
	}
	return rowAffected;


	}//insert method ends

	//update mehod begins
	public int update(int price,int qty,String id) throws SQLException
	{
		int rowAffected=0;
		try(PreparedStatement pstmt=con.prepareStatement("update Product set price=?,qty=? where productID=?");)
		{
			pstmt.setInt(1,price);
			pstmt.setInt(2,qty);
			pstmt.setString(3,id);
			rowAffected=pstmt.executeUpdate();
		}

		catch(SQLException exe)
		{
			throw exe;
		}
		return rowAffected;
	}//update method ends

		//delete method begins
	public int delete(String id) throws SQLException
	{
		int rowAffected=0;

		try(PreparedStatement pstmt=con.prepareStatement("delete from Product where productID=?");)
		{
			pstmt.setString(1,id);
			rowAffected=pstmt.executeUpdate();

		}
		catch(SQLException exe)
		{
			throw exe;
		}
		return rowAffected;
	}//delete method ends

	//insert method begins
	public ResultSet select(String id) throws SQLException
	{
			ResultSet rs=null;
			try{
				PreparedStatement pstmt=con.prepareStatement("Select productID,name,price,qty from Product where productID=?");

				pstmt.setString(1,id);
				rs=pstmt.executeQuery();
				}
				catch(SQLException exe)
				{
					throw exe;
				}

				return rs;
	}//insert method ends




}