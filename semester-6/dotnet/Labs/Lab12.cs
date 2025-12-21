using System;
using System.IO;

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Write Input to File ===\n");
    
    string fileName = "student_data.txt";
    
    try
    {
      // Take input from keyboard
      Console.Write("Enter your name: ");
      string name = Console.ReadLine();
      
      Console.Write("Enter your roll number: ");
      string rollNo = Console.ReadLine();
      
      Console.Write("Enter your age: ");
      string age = Console.ReadLine();
      
      Console.Write("Enter your address: ");
      string address = Console.ReadLine();
      
      // Write to file
      using (StreamWriter writer = new StreamWriter(fileName))
      {
        writer.WriteLine("Student Information");
        writer.WriteLine("===================");
        writer.WriteLine($"Name: {name}");
        writer.WriteLine($"Roll No: {rollNo}");
        writer.WriteLine($"Age: {age}");
        writer.WriteLine($"Address: {address}");
        writer.WriteLine();
        writer.WriteLine("Lab No.: 12");
        writer.WriteLine("Name: Samir Paudel");
        writer.WriteLine("Roll No./Section: 114-079/D");
      }
      
      Console.WriteLine($"\nData written to {fileName} successfully!");
      
      // Read and display file contents
      Console.WriteLine("\n=== File Contents ===\n");
      using (StreamReader reader = new StreamReader(fileName))
      {
        string content = reader.ReadToEnd();
        Console.WriteLine(content);
      }
      
      // Append more data
      Console.WriteLine("\n=== Append Mode ===");
      Console.Write("\nEnter additional comment: ");
      string comment = Console.ReadLine();
      
      using (StreamWriter writer = new StreamWriter(fileName, true))
      {
        writer.WriteLine($"\nComment: {comment}");
        writer.WriteLine($"Date: {DateTime.Now}");
      }
      
      Console.WriteLine("Comment appended successfully!");
      
      // Display final contents
      Console.WriteLine("\n=== Final File Contents ===\n");
      string finalContent = File.ReadAllText(fileName);
      Console.WriteLine(finalContent);
    }
    catch (Exception ex)
    {
      Console.WriteLine($"Error: {ex.Message}");
    }
    
    Console.WriteLine("\nLab No.: 12");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
