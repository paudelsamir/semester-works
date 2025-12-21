using System;

class Person
{
  // Auto-implemented property with get and set
  public string Name { get; set; }
  
  // Auto-implemented property with default value
  public int Age { get; set; } = 0;
  
  // Read-only auto property (can only be set in constructor)
  public string Country { get; }
  
  // Read-only property with backing field
  private string _ssn;
  public string SSN 
  { 
    get { return _ssn; } 
  }
  
  // Auto property with private setter
  public string Email { get; private set; }
  
  // Constructor
  public Person(string country, string ssn)
  {
    Country = country;
    _ssn = ssn;
  }
  
  public void SetEmail(string email)
  {
    Email = email;
  }
  
  public void DisplayInfo()
  {
    Console.WriteLine($"Name: {Name}");
    Console.WriteLine($"Age: {Age}");
    Console.WriteLine($"Country: {Country}");
    Console.WriteLine($"SSN: {SSN}");
    Console.WriteLine($"Email: {Email}");
  }
}

class Program
{
  static void Main()
  {
    Person person = new Person("Nepal", "123-45-6789");
    
    person.Name = "Ram Sharma";
    person.Age = 25;
    person.SetEmail("ram@example.com");
    
    Console.WriteLine("Person Information:");
    person.DisplayInfo();
    
    Console.WriteLine("\nLab No.: 2");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
