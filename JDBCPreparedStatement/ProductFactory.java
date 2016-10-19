import java.sql.*;
public class ProductFactory
{
	public ProductInterface createInstance() throws SQLException,ClassNotFoundException
	{
		return new ProductImplementation();
	}
}

