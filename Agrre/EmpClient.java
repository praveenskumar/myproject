import com.src.model.Address;
import com.src.model.Employee;
import com.src.model.MyPrinter;
public class EmpClient
{
	public static void main(String args[])
	{
		MyPrinter p=new MyPrinter();

		Address adr=new Address("Indi Road","Indi",586211);
		Employee arh=new Employee(007,"Arbaz","Hundekar","Data Scientist",2500000.00f,adr);

		p.print(arh);

		p.println(arh);
	}
}
