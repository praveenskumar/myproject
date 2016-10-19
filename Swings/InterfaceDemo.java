interface Flyer
{
	public void takeOff();

	public void land();

	public void fly();
}


 class Eagle implements Flyer
{

	public void takeOff()
	{
		System.out.println("Eagle is flying");
	}

	public void fly()
	{
		System.out.println("Eagle is flying");
	}

	public void land()
	{
		System.out.println("Eagle has landed");
	}

}


class AeroPlane implements Flyer
{
		public void takeOff()
		{
			System.out.println("Aeroplane is flying");
		}

		public void fly()
		{
			System.out.println("AeroPlane is flying");
		}

		public void land()
		{
			System.out.println("Aeroplane has landed");
	}
}

class SuperMan implements Flyer
{
		public void takeOff()
		{
			System.out.println("Superman is flying");
		}

		public void fly()
		{
			System.out.println("Superman is flying");
		}

		public void land()
		{
			System.out.println("Superman has landed");
	}

	public void saveLives()
	{
		System.out.println("superman is saving lives");
	}
}
public class InterfaceDemo
{
public static void main(String args[])
{
	Flyer eagle=new Eagle();
	Flyer superman=new SuperMan();

	superman.fly();
	superman.takeOff();
	superman.land();
	//superman.saveLives();
	if(superman instanceof SuperMan)
	{
		SuperMan sm=(SuperMan)superman;
		sm.saveLives();
	}
}


}




