using System;

// Generic Class with Generic Field and Method
class Box<T>
{
  // Generic field
  private T item;
  
  public void SetItem(T value)
  {
    item = value;
    Console.WriteLine($"Item set: {item}");
  }
  
  public T GetItem()
  {
    return item;
  }
  
  // Generic method
  public void Display<U>(U data)
  {
    Console.WriteLine($"Generic Method - Type: {typeof(U).Name}, Value: {data}");
  }
}

// Generic class with multiple type parameters
class Pair<T1, T2>
{
  public T1 First { get; set; }
  public T2 Second { get; set; }
  
  public Pair(T1 first, T2 second)
  {
    First = first;
    Second = second;
  }
  
  public void DisplayPair()
  {
    Console.WriteLine($"Pair: ({First}, {Second})");
  }
  
  // Generic method with constraint
  public void Swap<T>(ref T a, ref T b)
  {
    T temp = a;
    a = b;
    b = temp;
  }
}

// Generic class with constraints
class Calculator<T> where T : struct
{
  public void Add(T a, T b)
  {
    dynamic x = a;
    dynamic y = b;
    Console.WriteLine($"{a} + {b} = {x + y}");
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Generic Class with Generic Field ===");
    Box<int> intBox = new Box<int>();
    intBox.SetItem(100);
    Console.WriteLine($"Retrieved: {intBox.GetItem()}");
    
    Console.WriteLine();
    Box<string> strBox = new Box<string>();
    strBox.SetItem("Hello Generic");
    Console.WriteLine($"Retrieved: {strBox.GetItem()}");
    
    Console.WriteLine("\n=== Generic Method ===");
    intBox.Display(42);
    intBox.Display("String value");
    intBox.Display(3.14);
    
    Console.WriteLine("\n=== Generic Class with Multiple Parameters ===");
    Pair<int, string> pair1 = new Pair<int, string>(1, "One");
    pair1.DisplayPair();
    
    Pair<string, double> pair2 = new Pair<string, double>("PI", 3.14159);
    pair2.DisplayPair();
    
    Console.WriteLine("\n=== Generic Method with Swap ===");
    int a = 10, b = 20;
    Console.WriteLine($"Before: a={a}, b={b}");
    pair1.Swap(ref a, ref b);
    Console.WriteLine($"After: a={a}, b={b}");
    
    Console.WriteLine("\n=== Generic Class with Constraints ===");
    Calculator<int> calc = new Calculator<int>();
    calc.Add(15, 25);
    
    Calculator<double> calcDouble = new Calculator<double>();
    calcDouble.Add(5.5, 4.5);
    
    Console.WriteLine("\nLab No.: 11");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
