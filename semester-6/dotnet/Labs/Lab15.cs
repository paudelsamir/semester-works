using System;

// Custom Exception
class InvalidAgeException : Exception
{
  public InvalidAgeException(string message) : base(message) { }
}

class InsufficientBalanceException : Exception
{
  public double Balance { get; set; }
  public double RequestedAmount { get; set; }
  
  public InsufficientBalanceException(string message, double balance, double requested) 
    : base(message)
  {
    Balance = balance;
    RequestedAmount = requested;
  }
}

class BankAccount
{
  private double balance;
  
  public BankAccount(double initialBalance)
  {
    balance = initialBalance;
  }
  
  public void Withdraw(double amount)
  {
    if (amount > balance)
      throw new InsufficientBalanceException(
        "Insufficient balance!", balance, amount);
    
    balance -= amount;
    Console.WriteLine($"Withdrawn: {amount}, Balance: {balance}");
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Try-Catch-Finally ===\n");
    
    try
    {
      Console.Write("Enter first number: ");
      int num1 = int.Parse(Console.ReadLine());
      
      Console.Write("Enter second number: ");
      int num2 = int.Parse(Console.ReadLine());
      
      int result = num1 / num2;
      Console.WriteLine($"Result: {num1} / {num2} = {result}");
    }
    catch (DivideByZeroException ex)
    {
      Console.WriteLine($"Error: {ex.Message}");
    }
    catch (FormatException ex)
    {
      Console.WriteLine($"Invalid input: {ex.Message}");
    }
    catch (Exception ex)
    {
      Console.WriteLine($"General Error: {ex.Message}");
    }
    finally
    {
      Console.WriteLine("Finally block executed - Cleanup done");
    }
    
    Console.WriteLine("\n=== Throw Keyword ===\n");
    
    try
    {
      ValidateAge(15);
    }
    catch (InvalidAgeException ex)
    {
      Console.WriteLine($"Custom Exception: {ex.Message}");
    }
    
    Console.WriteLine("\n=== Multiple Catch Blocks ===\n");
    
    try
    {
      int[] numbers = { 1, 2, 3 };
      Console.WriteLine(numbers[5]); // Index out of range
    }
    catch (IndexOutOfRangeException ex)
    {
      Console.WriteLine($"Index Error: {ex.Message}");
    }
    catch (Exception ex)
    {
      Console.WriteLine($"Error: {ex.Message}");
    }
    
    Console.WriteLine("\n=== Custom Exception with Properties ===\n");
    
    BankAccount account = new BankAccount(5000);
    
    try
    {
      account.Withdraw(3000);
      account.Withdraw(3000); // This will throw exception
    }
    catch (InsufficientBalanceException ex)
    {
      Console.WriteLine($"Error: {ex.Message}");
      Console.WriteLine($"Balance: {ex.Balance}");
      Console.WriteLine($"Requested: {ex.RequestedAmount}");
      Console.WriteLine($"Shortage: {ex.RequestedAmount - ex.Balance}");
    }
    
    Console.WriteLine("\n=== Nested Try-Catch ===\n");
    
    try
    {
      try
      {
        int divisor = 0;
        int x = 10 / divisor;
      }
      catch (DivideByZeroException)
      {
        Console.WriteLine("Inner catch: Division by zero");
        throw; // Re-throw the exception
      }
    }
    catch (Exception ex)
    {
      Console.WriteLine($"Outer catch: {ex.GetType().Name}");
    }
    
    Console.WriteLine("\n=== Exception with Stack Trace ===\n");
    
    try
    {
      Method1();
    }
    catch (Exception ex)
    {
      Console.WriteLine($"Exception: {ex.Message}");
      Console.WriteLine($"Source: {ex.Source}");
      Console.WriteLine("Stack Trace:");
      Console.WriteLine(ex.StackTrace);
    }
    
    Console.WriteLine("\nLab No.: 15");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
  
  static void ValidateAge(int age)
  {
    if (age < 18)
      throw new InvalidAgeException($"Age {age} is below 18!");
    
    Console.WriteLine($"Age {age} is valid");
  }
  
  static void Method1()
  {
    Method2();
  }
  
  static void Method2()
  {
    Method3();
  }
  
  static void Method3()
  {
    throw new Exception("Error in Method3");
  }
}
