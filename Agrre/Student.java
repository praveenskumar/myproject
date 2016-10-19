import com.src.model.Address;
public class Student
{
	public int id;
	public String name;
	public Address address;

	public Student(int id,String name,Address address)
	{
		this.id=id;
		this.name=name;
		this.address=address;
	}

	public String toString()
	{
		return Integer.toString(id);
	}
	public static void main(String args[])
	{
		Address add=new Address("Shigaon","Haveri",586000);
		Student s=new Student(32,"Raghs",add);

		System.out.println(s);
	}
}