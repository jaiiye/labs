package javaee.pw.obj.Equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee
{
   private String name;
   private double salary;
   private Date hireDay;
   private Date birthDate;

   public Employee(String n, double s, int year, int month, int day, int birthYear, int birthMonth, int birthDay)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      GregorianCalendar calendarBirth = new GregorianCalendar(birthYear, birthMonth, birthDay);
      hireDay = calendar.getTime();
      birthDate = calendar.getTime();
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public Date getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
   
   public Date getBirthDate(){
	   return birthDate;
   }

   public void setBirthDate(Date birthDate) {
	   this.birthDate = birthDate;
   }

   public boolean equals(Object otherObject)
   {
      // a quick test to see if the objects are identical
      if (this == otherObject) return true;

      // must return false if the explicit parameter is null
      if (otherObject == null) return false;

      // if the classes don't match, they can't be equal
      if (getClass() != otherObject.getClass()) return false;

      // now we know otherObject is a non-null Employee
      Employee other = (Employee) otherObject;

      // test whether the fields have identical values
      return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay) && Objects.equals(birthDate, other.birthDate);
   }

   public int hashCode()
   {
      return Objects.hash(name, salary, hireDay, birthDate); 
   }

   public String toString()
   {
      return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + ",birthDate=" + birthDate + "]";
   }
}
