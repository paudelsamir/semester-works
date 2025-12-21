using System;

class ConstructorDemo
{
  private int value;
  private string name;

  // 1. Default Constructor
  public ConstructorDemo()
  {
    value = 0;
    name = "Default";
    Console.WriteLine("Default Constructor: value={0}, name={1}", value, name);
  }

  // 2. Parameterized Constructor
  public ConstructorDemo(int val, string nm)
  {
    value = val;
    name = nm;
    Console.WriteLine("Parameterized Constructor: value={0}, name={1}", value, name);
  }

  // 3. Copy Constructor
  public ConstructorDemo(ConstructorDemo obj)
  {
    value = obj.value;
    name = obj.name;
    Console.WriteLine("Copy Constructor: value={0}, name={1}", value, name);
  }

  // 4. Static Constructor
  static ConstructorDemo()
  {
    Console.WriteLine("Static Constructor called");
  }
}

// 5. Private Constructor
class Singleton
{
  private static Singleton instance;

  private Singleton()
  {
    Console.WriteLine("Private Constructor called");
  }

  public static Singleton GetInstance()
  {
    if (instance == null)
      instance = new Singleton();
    return instance;
  }
}

class Program
{
  static void Main()
  {
    ConstructorDemo obj1 = new ConstructorDemo();
    ConstructorDemo obj2 = new ConstructorDemo(10, "Test");
    ConstructorDemo obj3 = new ConstructorDemo(obj2);
    Singleton s = Singleton.GetInstance();

    Console.WriteLine("\nLab No.: 1");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
