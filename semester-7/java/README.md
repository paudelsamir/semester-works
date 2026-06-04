# Lab Works (Advanced Java Programming / CSIT-7th)

## Things to Know

1. **Lab Report Structure** (order must be maintained):
   - a) Title / Question
   - b) Theory: Brief overview of concepts, techniques, syntax, and technology used in the program
   - c) Code: The complete code
   - d) Output: Screenshot of the output

2. **Output Requirements**: Output screen should be captured (use snipping tool), printed and attached in the report. Other contents must be handwritten.

3. **Source Code Requirements**: Every source code must include printing statements to display the following information after the main output:
   - Lab No.
   - Name
   - Roll No. / Section

4. **Paper Guidelines**: Contents should be written on single side of A4 sized paper.

5. **Submission**: Works must be submitted within the specified deadline.

6. **Report Format**: Cover page and index page should be attached in the report appropriately.

---

## Lab Exercises

### Exercise 1: Box Class
Create a class named "Box" which includes the variables: `length`, `breadth`, and `height`. Add a method to print the values of these variables. Add another method that prints the volume of box. Now create two objects of "Box" class inside main method and initialize the variables for both objects then call above methods using each object.

### Exercise 2: Matrix and Jagged Array
Perform the following tasks:
- a) WAP to take the elements of a 3×3 matrix from user and display the matrix and all diagonal elements
- b) WAP to demonstrate the concept of jagged array

### Exercise 3: Static Variables and Final Keyword
WAP in Java to demonstrate:
- a) Static variable, static method, static block
- b) Final keyword (variable/method/class)

### Exercise 4: Inheritance - Student Hierarchy
Create a class `Student` with instance variable `roll_no` and two methods to read and display the roll no. Then, create another class `Test` that inherits class `Student`, consisting of its own instance variables to hold the marks of two subjects and also methods to read and display the marks. Finally, create another class `Result` which inherits class `Test`. It also has its own instance variable `total` that holds the total of two marks scored by the student. Similarly, it has methods to calculate and display the total. Create some instances of above classes and demonstrate inheritance.

### Exercise 5: Super Keyword and Multilevel Inheritance
WAP to demonstrate:
- a) The use of `super` keyword to access super class constructor
- b) The use of `super` keyword to overcome name hiding (to access parent class members from child class)
- c) Multilevel inheritance in Java

### Exercise 6: Method Overriding and Polymorphism
WAP to:
- a) Show method overriding in Java
- b) Illustrate runtime polymorphism in Java (Hint: Area of Figures - Rectangle, Triangle)

### Exercise 7: Nested Classes
WAP to demonstrate:
- a) Static nested class
- b) Non-static nested class (inner class)
- c) Local inner class

### Exercise 8: Interface Implementation
Create an interface called `Shape` which has methods `area(double x, double y)` and `perimeter(double x, double y)` to compute area and perimeter. Create a class called `Rectangle` which implements this interface. Declare instance variables as per requirement in class itself. Create instance of the class `Rectangle` and demonstrate interface implementation.

### Exercise 9: Exception Handling
WAP to:
- a) Demonstrate try, catch, and finally blocks in exception handling
- b) Have multiple catch blocks in exception handling
- c) Have nested try statements in exception handling
- d) Demonstrate the use of `throw` keyword in exception handling
- e) Demonstrate the use of `throws` keyword in exception handling
- f) Illustrate the idea of custom exceptions in Java (user-defined exceptions)

### Exercise 10: Threading
WAP to:
- a) Demonstrate the process of creating threads by implementing `Runnable` interface and by extending `Thread` class
- b) Show the use of `isAlive()` and `join()` methods of Thread
- c) Demonstrate the process of setting and getting thread priorities
- d) Illustrate the process of thread synchronization using synchronized method and synchronized block
- e) Create two threads: first thread prints numbers from 1 to 10 in the interval of 2 seconds and second thread prints numbers from 11 to 20 in the interval of 1 second

### Exercise 11: File I/O
WAP to:
- a) Demonstrate the use of `RandomAccessFile` class for random accessing of file
- b) Read text from keyboard and write to a file
- c) Demonstrate the concept of serialization and deserialization in Java

### Exercise 12: Swing - Colored Buttons
Using swing components, design a form with three buttons with captions "RED," "BLUE," and "GREEN," respectively. Then write a program to handle the event such that when the user clicks the button, the color of that button will be the same as its caption.

### Exercise 13: Simple GUI - Text Field
Write a simple GUI program that displays "Hello World" in a text field. The program should display output in option dialog if user clicks a button.

### Exercise 14: Text Area with File Operations
Write a simple GUI program that has text area and two buttons "Read" and "Write". Whenever write button is clicked, the text in text area should be written to the file named "userinput.txt" and when read button is clicked, the text in file should be shown in text area.

### Exercise 15: Menu Bar
Write a program to create a menu named "File" with menu items "New," "Save," and "Exit".

### Exercise 16: JTextField with KeyListener
Write a Java Swing program with a JTextField. Implement a KeyListener such that:
- a) Only numeric digits (0-9) can be typed into the JTextField
- b) If any other key is typed (e.g., a letter or symbol), it should be ignored (i.e., not appear in the text field)

### Exercise 17: JCheckBox and JRadioButtons
Create a GUI with one JCheckBox labeled "Enable Extra Options" and three JRadioButtons (e.g., "Option A," "Option B," "Option C") grouped in a ButtonGroup.
- a) Initially, the radio buttons should be disabled
- b) Implement an ItemListener for the JCheckBox. When the checkbox is selected, the radio buttons should become enabled. When it's deselected, they should become disabled
- c) Implement an ItemListener for the radio buttons. When a radio button is selected, print its label (e.g., "Option A selected") to the console

### Exercise 18: JDBC - MOVIE Table Operations
Assume a table `MOVIE(id, title, genre)`. Using JDBC, perform the following queries:
- a) Add any three records to the MOVIE table
- b) Using a prepared statement, update the genre to "Comedy" where title = "Jatra"

### Exercise 19: Scrollable ResultSet Navigation
Write a program to create a scrollable ResultSet and navigate it to the last row, then to the first row, and then to the third row. Consider MOVIE table.

### Exercise 20: Updatable ResultSet
Write a program that retrieves data from a movie table using an updatable ResultSet. The program should find a movie with title = 'interstellar' and update its genre to fiction directly through the ResultSet object.

### Exercise 21: TCP Sockets - One-Way Chat
Write a simple one-way chat application using TCP sockets.
- **Server Code**: Listens for a connection, reads a line of text from the client, and prints it
- **Client Code**: Connects to the server, reads a line of text from the user's console, and sends it to the server

### Exercise 22: UDP Echo Server and Client
Create a simple UDP Echo Server and Client.
- **Server Code**: Listens on a port, receives a packet, and sends the exact same data back to the sender's address and port
- **Client Code**: Sends a message to the server and waits to receive the echo, then prints it

### Exercise 23: URL Object Handling
Write a Java program that creates a URL object for `https://www.example.com/index.html?user=test` and prints its protocol, host, and file path.

### Exercise 24: Email Using JavaMail API
Write a Java program to send a simple email using the JavaMail API. Assume you have a Session object properly configured. The email should be from sender@test.com to receiver@test.com with the subject "Test Mail".


Labs 18-20: JDBC (requires MySQL)
Lab 24: Email (requires JavaMail)