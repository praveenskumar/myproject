class Address
{
	public String line1;
	public String line2;
	public int zip;


	public Address( String line1, String line2,int zip)
	{
		this.line1=line1;
		this.line2=line2;
		this.zip=zip;
	}

public String toString()
{
	return line1+" "+line2+" "+zip;
}

}

class Employee
{
	public int id;
	public String firstName;
	public String lastName;
	public String jobTitle;
	public float salary;
	Address address;


	public Employee(int id,String firstName,String lastName,String jobTitle,float salary,Address address)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.jobTitle=jobTitle;
		this.salary=salary;
		this.address=address;
	}

	public String toString()
	{
		return id+" "+firstName+" "+lastName+" "+jobTitle+" "+salary+" "+address;
	}
}


public class Client
{
	public static void main(String args[])
	{

		Address adr1=new Address("INDI ROAD","Indi",586211);
		Employee obj1=new Employee(101,"Arbaz","Hundekar","Data Scientist",2500000.00f,adr1);

		System.out.println(obj1);
	}
}

