using System;
using System.Collections;
using System.Collections.Generic;

class Program
{
  static void Main()
  {
    // NON-GENERIC COLLECTIONS
    Console.WriteLine("=== NON-GENERIC COLLECTIONS ===\n");
    
    // ArrayList
    Console.WriteLine("--- ArrayList ---");
    ArrayList arrayList = new ArrayList();
    arrayList.Add(10);
    arrayList.Add("Hello");
    arrayList.Add(3.14);
    
    foreach (object item in arrayList)
      Console.WriteLine($"{item} ({item.GetType().Name})");
    
    // Hashtable
    Console.WriteLine("\n--- Hashtable ---");
    Hashtable hashtable = new Hashtable();
    hashtable.Add("name", "Ram");
    hashtable.Add("age", 25);
    hashtable.Add("city", "Kathmandu");
    
    foreach (DictionaryEntry entry in hashtable)
      Console.WriteLine($"{entry.Key}: {entry.Value}");
    
    // Stack
    Console.WriteLine("\n--- Stack ---");
    Stack stack = new Stack();
    stack.Push("First");
    stack.Push("Second");
    stack.Push("Third");
    
    while (stack.Count > 0)
      Console.WriteLine(stack.Pop());
    
    // Queue
    Console.WriteLine("\n--- Queue ---");
    Queue queue = new Queue();
    queue.Enqueue("A");
    queue.Enqueue("B");
    queue.Enqueue("C");
    
    while (queue.Count > 0)
      Console.WriteLine(queue.Dequeue());
    
    // GENERIC COLLECTIONS
    Console.WriteLine("\n=== GENERIC COLLECTIONS ===\n");
    
    // List<T>
    Console.WriteLine("--- List<T> ---");
    List<int> numbers = new List<int> { 10, 20, 30, 40 };
    numbers.ForEach(n => Console.WriteLine(n));
    
    List<string> names = new List<string> { "Ram", "Sita", "Hari" };
    Console.WriteLine($"Names: {string.Join(", ", names)}");
    
    // Dictionary<TKey, TValue>
    Console.WriteLine("\n--- Dictionary<TKey, TValue> ---");
    Dictionary<string, string> dict = new Dictionary<string, string>();
    dict.Add("NPL", "Nepal");
    dict.Add("IND", "India");
    dict.Add("USA", "United States");
    
    foreach (var kvp in dict)
      Console.WriteLine($"{kvp.Key}: {kvp.Value}");
    
    // Stack<T>
    Console.WriteLine("\n--- Stack<T> ---");
    Stack<string> genericStack = new Stack<string>();
    genericStack.Push("Page1");
    genericStack.Push("Page2");
    genericStack.Push("Page3");
    
    while (genericStack.Count > 0)
      Console.WriteLine(genericStack.Pop());
    
    // Queue<T>
    Console.WriteLine("\n--- Queue<T> ---");
    Queue<int> genericQueue = new Queue<int>();
    genericQueue.Enqueue(100);
    genericQueue.Enqueue(200);
    genericQueue.Enqueue(300);
    
    while (genericQueue.Count > 0)
      Console.WriteLine(genericQueue.Dequeue());
    
    // HashSet<T>
    Console.WriteLine("\n--- HashSet<T> ---");
    HashSet<int> hashSet = new HashSet<int>();
    hashSet.Add(10);
    hashSet.Add(20);
    hashSet.Add(20); // Duplicate ignored
    hashSet.Add(30);
    
    foreach (int item in hashSet)
      Console.WriteLine(item);
    Console.WriteLine($"Count: {hashSet.Count}");
    
    Console.WriteLine("\nLab No.: 10");
    Console.WriteLine("Name: Samir Paudel");
    Console.WriteLine("Roll No./Section: 114-079/D");
  }
}
