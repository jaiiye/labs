package javaee.pw.obj.PackageTest;

import javaee.pw.obj.Employee.*;
import static java.lang.System.*;


public class PackageTest
{
   public static void main(String[] args)
   {
      // because of the import statement, we don't have to use com.horstmann.corejava.Employee here
      Employee harry = new Employee("Harry Hacker", 50000);

      // integer
      harry.raiseSalary(100);

      // because of the static import statement, we don't have to use System.out here
      out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
      
      // double
      harry.raiseSalary(100.00);
      
      harry.setSalary(5000);

      // because of the static import statement, we don't have to use System.out here
      out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
   }
}