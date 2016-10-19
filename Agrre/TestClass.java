import com.src.model.MyPrinter;

public class TestClass
{
	public static void main(String args[])
	{
		MyPrinter p=new MyPrinter();

		int a=10;
		float b=23.45f;
		double d=5436.9484;
		String v="Success";

		p.write(a);
		p.write(b);
		p.write(d);
		p.write(v);
		p.writeln("-concated-----------------------------");
		p.write(a+" "+b+" "+d+" "+v);
		p.writeln("------------------------------");
		p.writeln(a);
				p.writeln(b);
				p.writeln(d);
		p.writeln(v);
			p.writeln("-------------writeln concat----------------");
		p.writeln(a+" "+b+" "+d+" "+v);
	}
}
