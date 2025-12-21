using System;
using System.Linq;
using System.Collections.Generic;

class Student
{
  public int RollNo { get; set; }
  public string Name { get; set; }
  public int Age { get; set; }
  public double Marks { get; set; }
  public string City { get; set; }
}

class Program
{
  static void Main()
  {
    // Sample data
    List<Student> students = new List<Student>
    {
      new Student { RollNo = 1, Name = "Ram", Age = 20, Marks = 85, City = "Kathmandu" },
      new Student { RollNo = 2, Name = "Sita", Age = 19, Marks = 92, City = "Pokhara" },
      new Student { RollNo = 3, Name = "Hari", Age = 21, Marks = 78, City = "Kathmandu" },
      new Student { RollNo = 4, Name = "Gita", Age = 20, Marks = 88, City = "Lalitpur" },
      new Student { RollNo = 5, Name = "Shyam", Age = 22, Marks = 95, City = "Pokhara" }
    };
    
    int[] numbers = { 5, 2, 8, 1, 9, 3, 7, 4, 6 };
    
    Console.WriteLine("=== LINQ - Where (Filtering) ===");
    var passedStudents = students.Where(s => s.Marks >= 80);
    foreach (var s in passedStudents)
      Console.WriteLine($"{s.Name}: {s.Marks}");
    
    Console.WriteLine("\n=== LINQ - Select (Projection) ===");
    var studentNames = students.Select(s => s.Name);
    Console.WriteLine("Names: " + string.Join(", ", studentNames));
    
    Console.WriteLine("\n=== LINQ - OrderBy ===");
    var sortedByMarks = students.OrderByDescending(s => s.Marks);
    foreach (var s in sortedByMarks)
      Console.WriteLine($"{s.Name}: {s.Marks}");
    
    Console.WriteLine("\n=== LINQ - GroupBy ===");
    var studentsByCity = students.GroupBy(s => s.City);
    foreach (var group in studentsByCity)
    {
      Console.WriteLine($"\n{group.Key}:");
      foreach (var s in group)
        Console.WriteLine($"  {s.Name}");
    }
    
    Console.WriteLine("\n=== LINQ - Aggregate Functions ===");
    Console.WriteLine($"Total Students: {students.Count()}");
    Console.WriteLine($"Average Marks: {students.Average(s => s.Marks):F2}");
    Console.WriteLine($"Highest Marks: {students.Max(s => s.Marks)}");
    Console.WriteLine($"Lowest Marks: {students.Min(s => s.Marks)}");
    Console.WriteLine($"Sum of Marks: {students.Sum(s => s.Marks)}");
    
    Console.WriteLine("\n=== LINQ - First, Last, Single ===");
    var firstStudent = students.First();
    Console.WriteLine($"First: {firstStudent.Name}");
    
    var topStudent = students.First(s => s.Marks > 90);
    Console.WriteLine($"First with >90: {topStudent.Name}");
    
    Console.WriteLine("\n=== LINQ - Query Syntax ===");
    var query = from s in students
                where s.Age >= 20 && s.Marks >= 85
                orderby s.Marks descending
                select new { s.Name, s.Marks, s.City };
    
    foreach (var item in query)
      Console.WriteLine($"{item.Name} ({item.City}): {item.Marks}");
    
    Console.WriteLine("\n=== LINQ on Arrays ===");
    var evenNumbers = numbers.Where(n => n % 2 == 0);
    Console.WriteLine("Even: " + string.Join(", ", evenNumbers));
    
    var sortedNumbers = numbers.OrderBy(n => n);
    Console.WriteLine("Sorted: " + string.Join(", ", sortedNumbers));
    
    Console.WriteLine("\n=== LINQ - Any, All ===");
    Console.WriteLine($"Any student with 100? {students.Any(s => s.Marks == 100)}");
    Console.WriteLine($"All students passed (>50)? {students.All(s => s.Marks > 50)}");
    
    Console.WriteLine("\nLab No.: 13");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
