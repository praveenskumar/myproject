public class Product
{
	private String id;
	private String name;
	private int price;
	private int qty;

	public Product()
	{}

	public Product(String id,String name,int price,int qty)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.qty=qty;
	}

	public void setId(String id)
	{
		this.id=id;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public void setPrice(int price)
	{
		this.price=price;
	}


	public void setQty(int qty)
	{
		this.qty=qty;
	}

	public String getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public int getPrice()
	{
		return this.price;
	}

	public int getQty()
	{
		return this.qty;
	}
}