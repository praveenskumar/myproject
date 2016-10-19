public class MyTest
{


	public static void main(String args[])
	{
			int i;
			String s1="223";

			int k;
			String s2="223Arh";
		try{
		i=Integer.getInteger(s2);
		System.out.println(i);
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("Invalid Number");
	}
}
}

