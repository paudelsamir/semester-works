using System;

// Custom Attribute
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Method, AllowMultiple = true)]
class DeveloperInfoAttribute : Attribute
{
  public string Name { get; set; }
  public string Date { get; set; }
  public string Version { get; set; }
  
  public DeveloperInfoAttribute(string name)
  {
    Name = name;
    Date = DateTime.Now.ToShortDateString();
  }
  
  public void DisplayInfo()
  {
    Console.WriteLine($"Developer: {Name}");
    Console.WriteLine($"Date: {Date}");
    Console.WriteLine($"Version: {Version ?? "1.0"}");
  }
}

[AttributeUsage(AttributeTargets.Method)]
class TestMethodAttribute : Attribute
{
  public string Description { get; set; }
  
  public TestMethodAttribute(string description)
  {
    Description = description;
  }
}

// Using Built-in Attributes
[Serializable]
[DeveloperInfo("Samir Paudel", Version = "2.0")]
class Student
{
  public string Name { get; set; }
  public int Age { get; set; }
  
  [Obsolete("Use GetFullInfo() instead")]
  public void DisplayInfo()
  {
    Console.WriteLine($"{Name}, Age: {Age}");
  }
  
  [DeveloperInfo("Samir", Version = "1.5")]
  [TestMethod("Tests full information display")]
  public void GetFullInfo()
  {
    Console.WriteLine($"Student: {Name}, Age: {Age}");
  }
}

class Calculator
{
  [Obsolete("This method is deprecated. Use AddNumbers instead.", true)]
  public int Add(int a, int b)
  {
    return a + b;
  }
  
  public int AddNumbers(int a, int b)
  {
    return a + b;
  }
  
  [DeveloperInfo("Ram", Version = "2.1")]
  [TestMethod("Tests multiplication")]
  public int Multiply(int a, int b)
  {
    return a * b;
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Built-in Attributes ===\n");
    
    Student student = new Student { Name = "Ram", Age = 20 };
    
    // Using obsolete method (generates warning)
    student.DisplayInfo();
    
    // Using new method
    student.GetFullInfo();
    
    Console.WriteLine("\n=== Custom Attributes ===\n");
    
    // Reading custom attributes from class
    Type studentType = typeof(Student);
    var classAttributes = studentType.GetCustomAttributes(typeof(DeveloperInfoAttribute), false);
    
    Console.WriteLine($"Class: {studentType.Name}");
    foreach (DeveloperInfoAttribute attr in classAttributes)
    {
      attr.DisplayInfo();
      Console.WriteLine();
    }
    
    // Reading attributes from methods
    var methods = studentType.GetMethods();
    
    foreach (var method in methods)
    {
      var devAttrs = method.GetCustomAttributes(typeof(DeveloperInfoAttribute), false);
      var testAttrs = method.GetCustomAttributes(typeof(TestMethodAttribute), false);
      
      if (devAttrs.Length > 0 || testAttrs.Length > 0)
      {
        Console.WriteLine($"Method: {method.Name}");
        
        foreach (DeveloperInfoAttribute attr in devAttrs)
        {
          Console.Write("  ");
          attr.DisplayInfo();
        }
        
        foreach (TestMethodAttribute attr in testAttrs)
        {
          Console.WriteLine($"  Test: {attr.Description}");
        }
        
        Console.WriteLine();
      }
    }
    
    Console.WriteLine("=== Other Built-in Attributes ===\n");
    
    // Conditional attribute example
    TestConditionalMethod();
    
    Console.WriteLine("\n=== Reading All Attributes ===\n");
    
    Type calcType = typeof(Calculator);
    var calcMethods = calcType.GetMethods();
    
    foreach (var method in calcMethods)
    {
      if (method.DeclaringType == calcType)
      {
        Console.WriteLine($"\nMethod: {method.Name}");
        
        var attrs = method.GetCustomAttributes(false);
        foreach (var attr in attrs)
        {
          Console.WriteLine($"  Attribute: {attr.GetType().Name}");
          
          if (attr is DeveloperInfoAttribute devAttr)
          {
            Console.WriteLine($"    Developer: {devAttr.Name}");
            Console.WriteLine($"    Version: {devAttr.Version}");
          }
          else if (attr is TestMethodAttribute testAttr)
          {
            Console.WriteLine($"    Description: {testAttr.Description}");
          }
          else if (attr is ObsoleteAttribute obsAttr)
          {
            Console.WriteLine($"    Message: {obsAttr.Message}");
            Console.WriteLine($"    IsError: {obsAttr.IsError}");
          }
        }
      }
    }
    
    Console.WriteLine("\n=== Serializable Attribute ===");
    Console.WriteLine($"Is Student Serializable? {studentType.IsSerializable}");
    
    Console.WriteLine("\nLab No.: 16");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
  
  [System.Diagnostics.Conditional("DEBUG")]
  static void TestConditionalMethod()
  {
    Console.WriteLine("This only executes in DEBUG mode");
  }
}
