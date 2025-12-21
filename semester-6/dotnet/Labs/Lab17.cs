using System;
using System.Threading;
using System.Threading.Tasks;
using System.Net.Http;

class Program
{
  static async Task Main(string[] args)
  {
    Console.WriteLine("=== Async/Await Basics ===\n");
    
    Console.WriteLine("Starting async operation...");
    await PerformAsyncOperation();
    Console.WriteLine("Async operation completed!\n");
    
    Console.WriteLine("=== Multiple Async Tasks ===\n");
    await RunMultipleTasks();
    
    Console.WriteLine("\n=== Async with Return Value ===\n");
    int result = await CalculateAsync(10, 5);
    Console.WriteLine($"Calculation result: {result}");
    
    Console.WriteLine("\n=== Parallel Async Tasks ===\n");
    await RunParallelTasks();
    
    Console.WriteLine("\n=== Exception Handling in Async ===\n");
    await HandleAsyncException();
    
    Console.WriteLine("\n=== Task.WhenAll ===\n");
    await DemoTaskWhenAll();
    
    Console.WriteLine("\n=== Task.WhenAny ===\n");
    await DemoTaskWhenAny();
    
    Console.WriteLine("\nLab No.: 17");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
  
  static async Task PerformAsyncOperation()
  {
    Console.WriteLine("  Task started...");
    await Task.Delay(2000); // Simulate 2 second delay
    Console.WriteLine("  Task completed after 2 seconds");
  }
  
  static async Task RunMultipleTasks()
  {
    Console.WriteLine("Task 1 starting...");
    await Task1();
    
    Console.WriteLine("Task 2 starting...");
    await Task2();
    
    Console.WriteLine("Both tasks completed");
  }
  
  static async Task Task1()
  {
    await Task.Delay(1000);
    Console.WriteLine("  Task 1 done (1 sec)");
  }
  
  static async Task Task2()
  {
    await Task.Delay(1500);
    Console.WriteLine("  Task 2 done (1.5 sec)");
  }
  
  static async Task<int> CalculateAsync(int a, int b)
  {
    Console.WriteLine($"Calculating {a} + {b}...");
    await Task.Delay(1000);
    return a + b;
  }
  
  static async Task RunParallelTasks()
  {
    Console.WriteLine("Starting 3 tasks in parallel...");
    
    var task1 = DownloadDataAsync("File1", 1000);
    var task2 = DownloadDataAsync("File2", 1500);
    var task3 = DownloadDataAsync("File3", 2000);
    
    await Task.WhenAll(task1, task2, task3);
    
    Console.WriteLine("\nAll downloads completed!");
    Console.WriteLine($"Total time: ~2 seconds (parallel execution)");
  }
  
  static async Task DownloadDataAsync(string fileName, int delay)
  {
    Console.WriteLine($"  Downloading {fileName}...");
    await Task.Delay(delay);
    Console.WriteLine($"  {fileName} downloaded ({delay}ms)");
  }
  
  static async Task HandleAsyncException()
  {
    try
    {
      await TaskThatThrowsException();
    }
    catch (Exception ex)
    {
      Console.WriteLine($"Caught exception: {ex.Message}");
    }
  }
  
  static async Task TaskThatThrowsException()
  {
    await Task.Delay(500);
    throw new Exception("Something went wrong in async task!");
  }
  
  static async Task DemoTaskWhenAll()
  {
    var tasks = new[]
    {
      ProcessDataAsync("Data1", 1000),
      ProcessDataAsync("Data2", 1500),
      ProcessDataAsync("Data3", 800)
    };
    
    Console.WriteLine("Waiting for all tasks...");
    var results = await Task.WhenAll(tasks);
    
    Console.WriteLine("\nAll results:");
    foreach (var result in results)
      Console.WriteLine($"  {result}");
  }
  
  static async Task<string> ProcessDataAsync(string data, int delay)
  {
    await Task.Delay(delay);
    return $"{data} processed in {delay}ms";
  }
  
  static async Task DemoTaskWhenAny()
  {
    var task1 = DelayedTaskAsync("Fast Task", 1000);
    var task2 = DelayedTaskAsync("Medium Task", 2000);
    var task3 = DelayedTaskAsync("Slow Task", 3000);
    
    Console.WriteLine("Waiting for first task to complete...");
    
    var completedTask = await Task.WhenAny(task1, task2, task3);
    var result = await completedTask;
    
    Console.WriteLine($"\nFirst completed: {result}");
    Console.WriteLine("Other tasks still running in background");
  }
  
  static async Task<string> DelayedTaskAsync(string name, int delay)
  {
    Console.WriteLine($"  {name} started");
    await Task.Delay(delay);
    Console.WriteLine($"  {name} completed");
    return name;
  }
}
