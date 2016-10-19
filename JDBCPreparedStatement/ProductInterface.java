import java.sql.*;

public interface ProductInterface
{
	public int insert(String id,String name,int price,int qty) throws SQLException;

	public int update(int price,int qty,String id) throws SQLException;

	public int delete(String id) throws SQLException;

	public ResultSet select(String id) throws SQLException;
}
