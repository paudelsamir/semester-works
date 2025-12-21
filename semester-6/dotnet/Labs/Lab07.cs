using System;

// Abstract Class
abstract class Animal
{
  protected string name;
  
  public Animal(string name) { this.name = name; }
  
  public abstract void MakeSound();
  public abstract void Move();
  
  public void Sleep()
  {
    Console.WriteLine($"{name} is sleeping...");
  }
}

// Interfaces
interface IFlyable
{
  void Fly();
  int MaxAltitude { get; set; }
}

interface ISwimmable
{
  void Swim();
  int MaxDepth { get; set; }
}

interface IRunnable
{
  void Run();
}

class Dog : Animal, IRunnable
{
  public Dog(string name) : base(name) { }
  
  public override void MakeSound()
  {
    Console.WriteLine($"{name} says: Woof!");
  }
  
  public override void Move()
  {
    Console.WriteLine($"{name} is running");
  }
  
  public void Run()
  {
    Console.WriteLine($"{name} runs fast!");
  }
}

// Multiple Inheritance using Interfaces
class Duck : Animal, IFlyable, ISwimmable
{
  public int MaxAltitude { get; set; }
  public int MaxDepth { get; set; }
  
  public Duck(string name) : base(name)
  {
    MaxAltitude = 1000;
    MaxDepth = 10;
  }
  
  public override void MakeSound()
  {
    Console.WriteLine($"{name} says: Quack!");
  }
  
  public override void Move()
  {
    Console.WriteLine($"{name} can walk, fly, and swim");
  }
  
  public void Fly()
  {
    Console.WriteLine($"{name} flies to {MaxAltitude}m");
  }
  
  public void Swim()
  {
    Console.WriteLine($"{name} swims to {MaxDepth}m depth");
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Abstract Class ===");
    Dog dog = new Dog("Buddy");
    dog.MakeSound();
    dog.Move();
    dog.Run();
    
    Console.WriteLine("\n=== Multiple Inheritance ===");
    Duck duck = new Duck("Donald");
    duck.MakeSound();
    duck.Move();
    duck.Fly();
    duck.Swim();
    
    Console.WriteLine("\n=== Polymorphism ===");
    Animal[] animals = { dog, duck };
    foreach (Animal a in animals)
    {
      a.MakeSound();
      a.Move();
    }
    
    Console.WriteLine("\nLab No.: 7");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
