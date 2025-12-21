using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Lambda Expression - Basic ===");
    
    // Lambda with no parameters
    Action greet = () => Console.WriteLine("Hello from Lambda!");
    greet();
    
    // Lambda with one parameter
    Action<string> sayHello = name => Console.WriteLine($"Hello, {name}!");
    sayHello("Ram");
    
    // Lambda with multiple parameters
    Func<int, int, int> add = (a, b) => a + b;
    Console.WriteLine($"10 + 5 = {add(10, 5)}");
    
    Func<int, int, int> multiply = (x, y) => x * y;
    Console.WriteLine($"10 * 5 = {multiply(10, 5)}");
    
    Console.WriteLine("\n=== Lambda with Collections ===");
    List<int> numbers = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    
    // Filter using lambda
    var evenNumbers = numbers.Where(n => n % 2 == 0).ToList();
    Console.WriteLine("Even: " + string.Join(", ", evenNumbers));
    
    // Transform using lambda
    var squares = numbers.Select(n => n * n).ToList();
    Console.WriteLine("Squares: " + string.Join(", ", squares));
    
    // Sort using lambda
    List<string> names = new List<string> { "Ram", "Hari", "Sita", "Gita" };
    var sortedNames = names.OrderBy(n => n.Length).ToList();
    Console.WriteLine("Sorted by length: " + string.Join(", ", sortedNames));
    
    Console.WriteLine("\n=== Lambda for Filtering ===");
    var greaterThan5 = numbers.Where(n => n > 5).ToList();
    Console.WriteLine("Greater than 5: " + string.Join(", ", greaterThan5));
    
    Console.WriteLine("\n=== Lambda with Objects ===");
    List<Person> people = new List<Person>
    {
      new Person { Name = "Ram", Age = 25, Salary = 50000 },
      new Person { Name = "Sita", Age = 30, Salary = 60000 },
      new Person { Name = "Hari", Age = 22, Salary = 45000 },
      new Person { Name = "Gita", Age = 28, Salary = 55000 }
    };
    
    // Filter
    var youngPeople = people.Where(p => p.Age < 28).ToList();
    Console.WriteLine("\nAge < 28:");
    youngPeople.ForEach(p => Console.WriteLine($"{p.Name}: {p.Age}"));
    
    // Select specific properties
    var salaries = people.Select(p => p.Salary).ToList();
    Console.WriteLine("\nSalaries: " + string.Join(", ", salaries));
    
    // Order by
    var orderedBySalary = people.OrderByDescending(p => p.Salary).ToList();
    Console.WriteLine("\nOrdered by Salary:");
    orderedBySalary.ForEach(p => Console.WriteLine($"{p.Name}: {p.Salary}"));
    
    Console.WriteLine("\n=== Lambda - Multiple Statements ===");
    Func<int, int, string> compare = (a, b) =>
    {
      if (a > b) return $"{a} is greater";
      else if (a < b) return $"{b} is greater";
      else return "Both are equal";
    };
    Console.WriteLine(compare(10, 5));
    Console.WriteLine(compare(3, 8));
    
    Console.WriteLine("\n=== Lambda - Aggregate Operations ===");
    int sum = numbers.Sum();
    double average = numbers.Average();
    int max = numbers.Max();
    int min = numbers.Min();
    
    Console.WriteLine($"Sum: {sum}");
    Console.WriteLine($"Average: {average}");
    Console.WriteLine($"Max: {max}");
    Console.WriteLine($"Min: {min}");
    
    // Custom aggregate
    var totalSalary = people.Sum(p => p.Salary);
    Console.WriteLine($"\nTotal Salary: {totalSalary}");
    
    Console.WriteLine("\n=== Lambda - Find ===");
    var firstHighEarner = people.FirstOrDefault(p => p.Salary > 55000);
    if (firstHighEarner != null)
      Console.WriteLine($"First high earner: {firstHighEarner.Name}");
    
    Console.WriteLine("\nLab No.: 14");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}

class Person
{
  public string Name { get; set; }
  public int Age { get; set; }
  public double Salary { get; set; }
}
