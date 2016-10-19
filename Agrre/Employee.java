package com.src.model;
import com.src.model.Address;
public class Employee
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