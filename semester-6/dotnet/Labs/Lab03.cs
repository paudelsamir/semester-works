using System;

class JaggedArrayDemo
{
  static void Main()
  {
    // Declare jagged array with 4 rows
    int[][] jaggedArray = new int[4][];
    
    // Initialize each row with different lengths
    jaggedArray[0] = new int[3] { 1, 2, 3 };
    jaggedArray[1] = new int[5] { 4, 5, 6, 7, 8 };
    jaggedArray[2] = new int[2] { 9, 10 };
    jaggedArray[3] = new int[4] { 11, 12, 13, 14 };
    
    Console.WriteLine("Jagged Array Elements:");
    Console.WriteLine("======================");
    
    for (int i = 0; i < jaggedArray.Length; i++)
    {
      Console.Write($"Row {i}: ");
      for (int j = 0; j < jaggedArray[i].Length; j++)
      {
        Console.Write(jaggedArray[i][j] + " ");
      }
      Console.WriteLine();
    }
    
    Console.WriteLine("\nStudent Marks:");
    int[][] studentMarks = new int[3][];
    studentMarks[0] = new int[] { 85, 90, 78, 92 };
    studentMarks[1] = new int[] { 88, 76 };
    studentMarks[2] = new int[] { 95, 89, 91 };
    
    for (int i = 0; i < studentMarks.Length; i++)
    {
      Console.Write($"Student {i + 1}: ");
      double sum = 0;
      for (int j = 0; j < studentMarks[i].Length; j++)
      {
        Console.Write(studentMarks[i][j] + " ");
        sum += studentMarks[i][j];
      }
      Console.WriteLine($"(Avg: {sum / studentMarks[i].Length:F2})");
    }
    
    Console.WriteLine("\nLab No.: 3");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
