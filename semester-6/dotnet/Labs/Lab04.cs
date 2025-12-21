using System;

// Integer Indexer
class StudentMarks
{
  private int[] marks = new int[5];
  
  public int this[int index]
  {
    get 
    { 
      if (index >= 0 && index < marks.Length)
        return marks[index];
      throw new IndexOutOfRangeException();
    }
    set 
    { 
      if (index >= 0 && index < marks.Length)
        marks[index] = value;
      else
        throw new IndexOutOfRangeException();
    }
  }
  
  public int Length { get { return marks.Length; } }
}

// String Indexer
class PhoneBook
{
  private string[] names = new string[10];
  private string[] phones = new string[10];
  private int count = 0;
  
  public string this[string name]
  {
    get
    {
      for (int i = 0; i < count; i++)
        if (names[i] == name) return phones[i];
      return "Not Found";
    }
    set
    {
      for (int i = 0; i < count; i++)
      {
        if (names[i] == name) { phones[i] = value; return; }
      }
      if (count < names.Length)
      {
        names[count] = name;
        phones[count] = value;
        count++;
      }
    }
  }
  
  public void Display()
  {
    Console.WriteLine("\nPhone Book:");
    for (int i = 0; i < count; i++)
      Console.WriteLine($"{names[i]}: {phones[i]}");
  }
}

class Program
{
  static void Main()
  {
    Console.WriteLine("=== Integer Indexer ===");
    StudentMarks student = new StudentMarks();
    student[0] = 85; student[1] = 90; student[2] = 78;
    
    for (int i = 0; i < student.Length; i++)
      Console.WriteLine($"Subject {i + 1}: {student[i]}");
    
    Console.WriteLine("\n=== String Indexer ===");
    PhoneBook pb = new PhoneBook();
    pb["Ram"] = "9841234567";
    pb["Sita"] = "9847654321";
    pb.Display();
    Console.WriteLine($"\nRam's phone: {pb["Ram"]}");
    
    Console.WriteLine("\nLab No.: 4");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
