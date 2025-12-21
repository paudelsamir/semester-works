using System;

// Structure
struct Point
{
  public int X;
  public int Y;
  
  public Point(int x, int y) { X = x; Y = y; }
  
  public void Display()
  {
    Console.WriteLine($"Point: ({X}, {Y})");
  }
  
  public double Distance()
  {
    return Math.Sqrt(X * X + Y * Y);
  }
}

// Enumeration
enum Days { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday }

enum OrderStatus
{
  Pending = 1,
  Processing = 2,
  Shipped = 3,
  Delivered = 4
}

enum Priority { Low = 1, Medium = 2, High = 3, Critical = 4 }

// Partial Class - Part 1
partial class Employee
{
  private int empId;
  private string name;
  private double salary;
  
  public Employee(int id, string name, double salary)
  {
    this.empId = id;
    this.name = name;
    this.salary = salary;
  }
  
  public void DisplayInfo()
  {
    Console.WriteLine($"ID: {empId}, Name: {name}, Salary: {salary:C}");
  }
}

// Partial Class - Part 2
partial class Employee
{
  public void CalculateBonus()
  {
    double bonus = salary * 0.10;
    Console.WriteLine($"Bonus: {bonus:C}, Total: {(salary + bonus):C}");
  }
  
  public void GiveRaise(double percentage)
  {
    salary += salary * (percentage / 100);
    Console.WriteLine($"New Salary: {salary:C}");
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== STRUCTURE ===");
    Point p = new Point(3, 4);
    p.Display();
    Console.WriteLine($"Distance: {p.Distance():F2}");
    
    Console.WriteLine("\n=== ENUMERATION ===");
    Days today = Days.Wednesday;
    Console.WriteLine($"Today: {today} ({(int)today})");
    
    OrderStatus status = OrderStatus.Processing;
    Console.WriteLine($"Status: {status} (Code: {(int)status})");
    
    Priority priority = Priority.High;
    Console.WriteLine($"Priority: {priority} (Level: {(int)priority})");
    
    Console.WriteLine("\n=== PARTIAL CLASS ===");
    Employee emp = new Employee(101, "Ram Sharma", 50000);
    emp.DisplayInfo();
    emp.CalculateBonus();
    emp.GiveRaise(15);
    
    Console.WriteLine("\nLab No.: 8");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
