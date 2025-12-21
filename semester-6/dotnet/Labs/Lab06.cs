using System;

class Shape
{
  protected string name;
  
  public Shape(string name) { this.name = name; }
  
  public virtual void Draw()
  {
    Console.WriteLine($"Drawing a {name}");
  }
  
  public void ShowInfo()
  {
    Console.WriteLine($"This is a {name}");
  }
  
  public virtual double CalculateArea() { return 0; }
}

class Circle : Shape
{
  private double radius;
  
  public Circle(double radius) : base("Circle")
  {
    this.radius = radius;
  }
  
  public override void Draw()
  {
    Console.WriteLine($"Drawing circle with radius {radius}");
  }
  
  public override double CalculateArea()
  {
    return Math.PI * radius * radius;
  }
  
  public new void ShowInfo()
  {
    Console.WriteLine($"Circle with radius {radius}");
  }
}

class Rectangle : Shape
{
  private double length, width;
  
  public Rectangle(double length, double width) : base("Rectangle")
  {
    this.length = length;
    this.width = width;
  }
  
  public override void Draw()
  {
    Console.WriteLine($"Drawing rectangle: {length} x {width}");
  }
  
  public override double CalculateArea()
  {
    return length * width;
  }
  
  public new void ShowInfo()
  {
    Console.WriteLine($"Rectangle: {length} x {width}");
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Method Overriding vs Hiding ===\n");
    
    Circle circle = new Circle(5.0);
    circle.Draw();
    circle.ShowInfo();
    Console.WriteLine($"Area: {circle.CalculateArea():F2}\n");
    
    Console.WriteLine("=== Dynamic Polymorphism ===");
    Shape shape1 = new Circle(7.0);
    Shape shape2 = new Rectangle(5.0, 8.0);
    
    shape1.Draw();
    Console.WriteLine($"Area: {shape1.CalculateArea():F2}");
    
    shape2.Draw();
    Console.WriteLine($"Area: {shape2.CalculateArea():F2}");
    
    Console.WriteLine("\n=== Hidden Method Behavior ===");
    shape1.ShowInfo();
    shape2.ShowInfo();
    
    Console.WriteLine("\nLab No.: 6");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
