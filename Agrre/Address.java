package com.src.model;
public class Address
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
