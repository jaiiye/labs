package javaee.pw.obj.Employee;

/**
 * A minimalist employee class for testing purposes.
 */
public class Employee
{
   private String name;
   private double salary;

   /**
    * Constructs an employee with $0 salary.
    * @param n the employee name
    */
   public Employee(String n)
   {
      name = n;
      salary = 0;
   }
   
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   public String toString()
   {
      return "[name=" + name + ", salary=" + salary + "]";
   }
   
   public String getName() {
	   return this.name;
   }
   
   public double getSalary() {
	   return this.salary;
   }
   
   public void setSalary(double s) {
	   this.salary = s;
   }
   
   public void raiseSalary(double r) {
	   this.salary = this.salary + r;
   }
   
   
   public void raiseSalary(int prc) {
	   this.salary = this.salary + ( (this.salary/100) * prc );
   }
}