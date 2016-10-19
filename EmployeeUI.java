//Sample program to count no of objects created for a class
class Employee
{
  private int id;
  private String name;
  private String jobTitle;
  public static int objCount;
  
  public Employee()
  {
    objCount++;
  }
  
}

class EmployeeUI
{
public static void main(String args[])
{
  //Creating Employee objects
  Employee emp1=new Employee();
  Employee emp2=new Employee();
  Employee emp3=new Employee();
  int no_of_objs=Employee.objCount;
  System.out.println("no of objects"+no_of_objs);
}
}
  
