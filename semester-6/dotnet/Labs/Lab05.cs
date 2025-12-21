using System;

class Vehicle
{
  protected string brand = "Generic";
  protected int speed = 0;
  
  public Vehicle() 
  { 
    Console.WriteLine("Vehicle: Default constructor"); 
  }
  
  public Vehicle(string brand, int speed)
  {
    this.brand = brand;
    this.speed = speed;
    Console.WriteLine("Vehicle: Parameterized constructor");
  }
  
  public virtual void ShowInfo()
  {
    Console.WriteLine($"Brand: {brand}, Speed: {speed} km/h");
  }
  
  public void StartEngine()
  {
    Console.WriteLine($"{brand}: Engine started");
  }
}

class Car : Vehicle
{
  private string brand = "Car Brand";
  private int numberOfDoors;
  
  public Car() : base()
  {
    numberOfDoors = 4;
    Console.WriteLine("Car: Default constructor");
  }
  
  public Car(string brand, int speed, int doors) : base(brand, speed)
  {
    numberOfDoors = doors;
    Console.WriteLine("Car: Parameterized constructor");
  }
  
  public override void ShowInfo()
  {
    Console.WriteLine("--- Car Information ---");
    base.ShowInfo();
    Console.WriteLine($"Doors: {numberOfDoors}");
  }
  
  public void DisplayBrands()
  {
    Console.WriteLine($"Base brand: {base.brand}");
    Console.WriteLine($"Derived brand: {this.brand}");
  }
  
  public void StartCarEngine()
  {
    base.StartEngine();
    Console.WriteLine("Car systems initialized");
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Creating Car ===");
    Car car = new Car("Toyota", 180, 4);
    
    Console.WriteLine("\n=== Base Keyword Uses ===");
    Console.WriteLine("1. Accessing fields:");
    car.DisplayBrands();
    
    Console.WriteLine("\n2. Calling method:");
    car.ShowInfo();
    
    Console.WriteLine("\n3. Starting engine:");
    car.StartCarEngine();
    
    Console.WriteLine("\nLab No.: 5");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
