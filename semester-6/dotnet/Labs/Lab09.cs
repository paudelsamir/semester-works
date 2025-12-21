using System;

// Delegate
delegate int MathOperation(int a, int b);
delegate void DisplayMessage(string message);

// Event
class Button
{
  public event EventHandler Click;
  
  public void OnClick()
  {
    Console.WriteLine("Button clicked!");
    Click?.Invoke(this, EventArgs.Empty);
  }
}

class Calculator
{
  public int Add(int a, int b) { return a + b; }
  public int Subtract(int a, int b) { return a - b; }
  public static void ShowResult(string msg) { Console.WriteLine($"Result: {msg}"); }
}

class Program
{
  static void Main()
  {
    Calculator calc = new Calculator();
    
    // Delegate
    Console.WriteLine("=== DELEGATE ===");
    MathOperation op = calc.Add;
    Console.WriteLine($"10 + 5 = {op(10, 5)}");
    
    // Multicast Delegate
    Console.WriteLine("\n=== MULTICAST DELEGATE ===");
    DisplayMessage display = Calculator.ShowResult;
    display += msg => Console.WriteLine($"Log: {msg}");
    display("Hello multicast");
    
    // Func Delegate
    Console.WriteLine("\n=== FUNC DELEGATE ===");
    Func<int, int, int> add = (x, y) => x + y;
    Func<string, string> greet = name => $"Hello, {name}!";
    Console.WriteLine($"15 + 10 = {add(15, 10)}");
    Console.WriteLine(greet("Ram"));
    
    // Action Delegate
    Console.WriteLine("\n=== ACTION DELEGATE ===");
    Action<string> print = msg => Console.WriteLine($"Action: {msg}");
    print("This is Action delegate");
    Action<int, int> printSum = (a, b) => Console.WriteLine($"{a} + {b} = {a + b}");
    printSum(20, 30);
    
    // Anonymous Method
    Console.WriteLine("\n=== ANONYMOUS METHOD ===");
    MathOperation sub = delegate(int x, int y)
    {
      Console.WriteLine($"Anonymous: {x} - {y}");
      return x - y;
    };
    Console.WriteLine($"Result: {sub(50, 20)}");
    
    // Event
    Console.WriteLine("\n=== EVENT ===");
    Button button = new Button();
    button.Click += Button_Click;
    button.Click += (s, e) => Console.WriteLine("Lambda handler");
    button.OnClick();
    
    Console.WriteLine("\nLab No.: 9");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
  
  static void Button_Click(object sender, EventArgs e)
  {
    Console.WriteLine("Button_Click handler");
  }
}
