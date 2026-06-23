# Advanced Java Programming (CSC409) - Question Bank
---

## Part 1: Chapter-wise Important Questions

### Unit 1: Programming in Java

1. Write a program to create a class MOVIE with attributes name and genre. Write the movies with genre comedy on COM.DAT file. *(2082)* [5]
2. What is a package? Differentiate between method overloading and overriding. *(2082)* [5]
3. Write a program to input the name of faculty and throw an exception if that input is not "CSIT". *(2082)* [5]
4. How is exception different from error? Differentiate throws and throw keywords. When is the block finally important? [5]
5. What is the difference between final, finally, and finalize keywords in Java? [5]
6. Why is multithreading important? Explain thread life cycle with proper state diagram. Write a program that reads data of employees from the keyboard and write it into the file emp.doc using proper exception handling with try...catch blocks. [10]
7. Assume that a text file named "ONE.TXT" contains a paragraph of text. Write a program to copy the word that starts with vowel from "ONE.TXT" to another file "TWO.TXT". *(2081)* [5]
8. Differentiate between path and class path in Java. When do you prefer anonymous inner class? Consider the following program and answer the given questions: *(2081)* [10]
   ```java
   class A {
     class B {
    public void test() {
      int i = 0;
      while (i <= 100) {
        System.out.println(i);
        i = i + 2;
      }
    }
  }
}
   ```
   a) Name the list of class files created after compiling the above program.
   b) Rewrite the above program using for loop.

9. Suppose that 9 integers are written in a file named "magic.txt" in the arrangement of 3 × 3 separated by space. Write a program to check whether the integers in all rows, all columns, and both diagonals sum to the same constant or not. *(2080)* [5]

10. Describe the role of Result Sets. What is wrong in the following code? *(2080)* [5]
    ```java
    public class Point {
      int p;
      public void setP(int p) {
        p = p;
      }
    }
    ```
11. Why do we need to synchronize the thread? Justify with an example. An array with an odd number of elements is said to be centered if all elements (except the middle one) are strictly greater than the value of the middle element. Note that only arrays with an odd number of elements have a middle element. Write a function that accepts an integer array and returns 1 if it is a centered array, otherwise it returns 0. *(2080)* [10]
12. When thread synchronization is necessary? Explain with suitable example. *(2080)* [5]
13. Write a java program that writes objects of Employee class in the file named emp.doc. Create Employee class as of your interest. *(2080)* [5]
14. What are the uses of final modifier? Explain each use of the modifier with suitable example. *(2080)* [10]
15. Write short notes on: *(2079)* [5]
16. What is multithreading? How can you create multithreaded program in Java? Explain. *(2079)* [5]
17. Explain feature of object-oriented programming. Create a class Distance with private variables feet of type integer and inches of type floating point. Use suitable constructor, and methods for adding and comparing two distance objects. [Hint: 1 feet = 12 inches] *(2079)* [10]
18. What is package? How can you create your own package in Java? Explain with example. *(2078)* [5]
19. Describe the responsibility of Serializable interface. Write a program to read an input string from the user and write the vowels of that string in VOWEL.TXT and consonants in CONSONANT.TXT. *(2077)* [10]
20. A non-empty array A of length n is called an array of all possibilities if it contains all numbers between 0 and A.length-1 inclusive. Write a method named isAllPossibilities that accepts an integer array and returns 1 if the array is an array of all possibilities, otherwise it returns 0. *(2077)* [5]
21. When does the finally block is mandatory in while handling exception? Describe with a suitable scenario. *(2077)* [5]
22. What is the task of manifest file? Write the procedure to create it. *(2077)* [5]
23. Why multiple inheritance is not allowed in Java using classes? Give an example. *(2077)* [5]
24. Why synchronization is essential in multithreading? Describe. *(2077)* [5]

### Unit 2: User Interface Components with Swing

1. Do we still need Java Applet? Justify. Give the hierarchy of Swing class. *(2082)* [5]
2. Write a program to demonstrate the concept of internal frame. *(2082)* [5] **[Repeated: 2080]**
3. Write a program to design a layout of a simple calculator. (Arithmetic operation not required.) *(2082)* [5]
4. Write a program to create a form with employee id, name, salary fields and two buttons add and cancel using appropriate components. [5]
5. Explain flow layout manager with suitable constructors and demonstrate it by using suitable java code. [5]
6. Write a program that divides the frame into five regions by using border layout and then add panels in the east, north and center region. Finally add some descriptive label in the north panel, buttons with icon in the east panel and a sample form in the center panel. You can further subdivide the center panel, if necessary. Prepare a program with three text boxes First Number, Second Number, and Result and four buttons add, subtract, multiply and divide. Handle the events to perform the required operation and display results. [10]
7. Write a program to create a menu named "File" with menu items "New," "Save," and "Exit". *(2080)* [5]
8. When do we need an internal frame? How do you create a table using Swing? *(2080)* [5] **[Repeated: 2082]**
9. Describe any two types of Layout manager. Using swing components, design a form with three buttons with captions "RED," "BLUE," and "GREEN," respectively. Then write a program to handle the event such that when the user clicks the button, the color of that button will be the same as its caption. *(2080)* [10]
10. What are layout managers? Explain Gridbag layout with suitable example. *(2080)* [5]
11. What is grid layout? Compare grid layout with grid bag layout. *(2079)* [5]
12. Why do we need layout management? Explain any two layout managers with example. Write a simple GUI program that displays "Hello World" in a text field. The program should display output if user clicks a button. *(2079)* [10]
13. What are the tasks of sliders and scroll pane? Explain any four types of layout manager. *(2081)* [10]
14. Design a simple form that takes name, password, hobbies and gender as input. *(2081)* [5]
15. Compare AWT with Swing. Write a GUI program using components to find sum and difference of two numbers. Use two text fields for giving input and a label for output. The program should display sum if user presses mouse and difference if user release mouse. *(2078)* [10]
16. Why do we need swing components? Explain the uses of check boxes and radio buttons in GUI programming. *(2078)* [5]
17. What is the task of Layout manager? Describe about default layout manager. *(2077)* [5]

### Unit 3: Event Handling

1. Write a program to insert an icon in the frame and when the user presses the up arrow, it will move upward. *(2082)* [5]
2. What is an adapter class? Explain advantages of adapter classes over listener interfaces with suitable examples. [5]
3. What is the use of action command in event handling? Explain with example. *(2080)* [5] **[Repeated: 2079]**
4. Write a java program to create login form with user id, password, ok button, and cancel button. Handle key events such that pressing 'l' performs login and pressing 'c' clears text boxes and puts focus on user id text box. Assume user table having fields Uid and Password in the database named account. *(2080)* [10]
5. Why do we need event handling? Explain the use of action event with example. *(2079)* [5] **[Repeated: 2080]**
6. Describe any two types of events. *(2081)* [5]
7. How can we use listener interface to handle events? Compare listener interface with adapter class. *(2078)* [5]
8. Define event delegation model. Why do we need adapter class in event handling? *(2077)* [5]

### Unit 4: Database Connectivity

1. What is a prepared statement? When is it useful? Explain its use with suitable java code. [5]
2. What do you mean by SQL escape? Describe about scrollable and updateable result sets. *(2081)* [5] **[Repeated: 2079]**
3. Assume a table MOVIE(id, title, genre). Now, using JDBC, perform the following queries: a. Add any three records to the MOVIE table. b. Using a prepared statement, update the genre to "Comedy" having the title "Jatra". *(2080)* [5]
4. What causes SQL exception? How it can be handled? Explain with example. *(2080)* [5]
5. Explain JDBC driver types. What is scrollable result set? *(2079)* [5] **[Repeated: 2081]**
6. What is row set? Explain cached row set in detail. *(2078)* [5]
7. You are hired by a reputed software company which is going to design an application for "Movie Rental System". Your responsibility is to design a schema named MRS and create a table named Movie(id, Title, Genre, Language, Length). Write a program to design a GUI form to take input for this table and insert the data into table after clicking the OK button. *(2077)* [10]

### Unit 5: Network Programming

1. What are the uses of focus and item event? Write a socket program using UDP to create three programs, two of which are clients to a single server. Client1 will send a character to the server process. The server will circularly decrement the letter to the previous letter in the alphabet and send the result to Client2. Then Client2 prints the letter it receives and then all the processes terminate. *(2082)* [10]
2. Write the steps for writing client and server programs using TCP with a suitable example. [5]
3. What is the task of the Listener interface? Write a socket program for a file server that makes a collection of files available for transmission to clients. When a client connects to the server, the server first reads a one-line command from the client. The command string can be of the form "GET <filename>", where <filename> is a file name. The server checks whether the requested file actually exists. If so, it first sends the word "OK" as a message to the client. Then it sends the contents of the file and closes the connection. Otherwise, it sends "ERROR" to the client as message and closes the connection. Assume that there is no sub directories. *(2081)* [10]
4. Write a TCP client-server system in which the client program sends two integers to a server program, which returns the greatest among them. *(2080)* [5]
5. Write Java program that send messages with each other using TCP socket. *(2079)* [5]

### Unit 6: GUI with JavaFX

1. Write a JavaFX application that creates a ChoiceBox with a list of colors. Display a label that changes its text based on the selected color from the ChoiceBox. Write down steps for writing CORBA programs with a suitable example. *(2082)* [10]
2. What is JavaFX? How it is different from swing. Write a JavaFX program to create a form to read two numbers and display their sum on button click. [5] **[Repeated: 2080, 2079]**
3. Write a JavaFX application with components, buttons, text fields, and labels, arranged in a VBox or HBox layout. *(2080)* [5]
4. How JavaFx differs from Swing? Explain steps of creating GUI using javaFx. *(2080)* [5] **[Repeated: 2079]**
5. What is JavaFX? Compare it with swing. Explain FlowPane layout of JavaFX. *(2079)* [5] **[Repeated: 2080]**
6. How does JavaFX hyperlink control format text that functions as button? Illustrate with an example. *(2081)* [5]
7. Compare JavaFX with swing. Explain HBox and VBox layouts of JavaFX. *(2078)* [5]

### Unit 7: Servlets and Java Server pages

1. Describe the life cycle of a servlet. *(2082)* [5] **[Repeated: 2081, 2080, 2078]**
2. How do you handle HTTP request and response using JSP? Illustrate with an example. *(2082)* [5]
3. What is Servlet? Create an application where an HTML file displays a form containing field company name, city and ESTD and a save button and when we click on save button it must save records in the database. [10]
4. How do you insert pop-up menu? Distinguish between GET and POST request. *(2081)* [5]
5. Explain the life cycle of servlets. *(2081)* [5] **[Repeated: 2082, 2080, 2078]**
6. What do you mean by JSP implicit objects? Discuss Java Mail API. *(2080)* [5] **[Repeated: 2079]**
7. How does JSP differ from Servlet and show the life cycle of Servlet? How do you create and read the cookies and session using JSP? Illustrate with an example. *(2080)* [10] **[Repeated: 2082, 2081, 2079, 2078]**
8. What are different ways of writing servlet programs? Write a sample Servlet program using any one way. *(2080)* [5]
9. Discuss various scopes of JSP objects briefly. Create a HTML file with principal, time and rate. Then create a JSP file that reads values from the HTML form, calculates simple interest and displays it. *(2080)* [10]
10. Write a java program using TCP such that client sends number to server and displays its factorial. The server computes factorial of the number received from client. *(2080)* [5]
11. Compare JSP with servlet. What are different implicit objects in JSP? *(2079)* [5] **[Repeated: 2080]**
12. Define JSP. What are the benefits of using JSP? Create a HTML file with two text fields to first name and last name. Create a JSP file that reads data from the HTML form and display full name. *(2079)* [10]
13. Explain life-cycle of servlet in detail. Create a simple servlet that reads and displays data from HTML form. Assume form with two fields username and password. *(2078)* [10] **[Repeated: 2082, 2081, 2080]**
14. Discuss about JSP implicit objects. Assume a database with the table TEACHER (ID, Name). Now using JDBC, execute the following SQL query: a. select * from TEACHER; b. insert into TEACHER values (8, 'Ramesh'); c. select name from TEACHER where ID = 9; *(2082)* [10]
15. Write a program in JSP to display the string taken in one page in another page. *(2081)* [5]
16. What is Java Mail API? How can you use this API to send email messages? *(2078)* [5]
17. What is servlet? Write a simple JSP file to display "Tribhuwan University" five times. *(2078)* [5]
18. How forms can be created and processed using JSP? Make it clear with your own assumptions. *(2077)* [5]

### Unit 8: RMI and CORBA

1. What is RMI? Discuss stub and skeleton. Explain its role in creating distributed applications. [5]
2. List the steps to create an RMI application. Differentiate between RMI and CORBA. *(2080)* [5]
3. How CORBA differs from RMI? Discuss the concepts of IDL briefly. *(2080)* [5]

---
4. How do you write an IDL file and generate the stub and skeleton code for CORBA implementation? Explain. *(2081)* [5]
5. Explain RMI architecture layers in detail. Write a Java programs using RMI to find product of two numbers. *(2078)* [10]
6. Why CORBA is important? Compare CORBA with RMI. *(2078)* [5]
7. What is the significance of stub and skeleton in RMI? Create a RMI application such that a client sends an Integer number to the server and the server return the factorial value of that integer. Give a clear specification for every step. *(2077)* [10]

## Part 2: Question Bank by Exam Year

### Model Set

**Group A (Attempt any TWO questions)**

1. What are the uses of final modifier? Explain each use of the modifier with suitable example.
2. Write a java program to create login form with user id, password, ok button, and cancel button. Handle key events such that pressing 'l' performs login and pressing 'c' clears text boxes and puts focus on user id text box. Assume user table having fields Uid and Password in the database named account.
3. Discuss various scopes of JSP objects briefly. Create a HTML file with principal, time and rate. Then create a JSP file that reads values from the HTML form, calculates simple interest and displays it.

**Group B (Attempt any EIGHT questions)**

4. Write a java program that writes objects of Employee class in the file named emp.doc. Create Employee class as of your interest.
5. What are layout managers? Explain Gridbag layout with suitable example.
6. What is the use of action command in event handling? Explain with example.
7. What causes SQL exception? How it can be handled? Explain with example.
8. Write a java program using TCP such that client sends number to server and displays its factorial. The server computes factorial of the number received from client.
9. How JavaFx differs from Swing? Explain steps of creating GUI using javaFx.
10. What are different ways of writing servlet programs? Write a sample Servlet program using any one way.
11. How CORBA differs from RMI? Discuss the concepts of IDL briefly.
12. When thread synchronization is necessary? Explain with suitable example.

### Model Set II

**Section A (Attempt any TWO questions)**

1. Why is multithreading important? Explain thread life cycle with proper state diagram. Write a program that reads data of employees from the keyboard and write it into the file emp.doc using proper exception handling with try...catch blocks.
2. Write a program that divides the frame into five regions by using border layout and then add panels in the east, north and center region. Finally add some descriptive label in the north panel, buttons with icon in the east panel and a sample form in the center panel. You can further subdivide the center panel, if necessary. Prepare a program with three text boxes First Number, Second Number, and Result and four buttons add, subtract, multiply and divide. Handle the events to perform the required operation and display results.
3. What is Servlet? Create an application where an HTML file displays a form containing field company name, city and ESTD and a save button and when we click on save button it must save records in the database.

**Section B (Attempt any EIGHT questions)**

4. What is the difference between final, finally, and finalize keywords in Java?
5. How is exception different from error? Differentiate throws and throw keywords. When is the block finally important?
6. Explain flow layout manager with suitable constructors and demonstrate it by using suitable java code.
7. Write a program to create a form with employee id, name, salary fields and two buttons add and cancel using appropriate components.
8. What is an adapter class? Explain advantages of adapter classes over listener interfaces with suitable examples.
9. What is a prepared statement? When is it useful? Explain its use with suitable java code.
10. Write the steps for writing client and server programs using TCP with a suitable example.
11. What is JavaFX? How it is different from swing. Write a JavaFX program to create a form to read two numbers and display their sum on button click.
12. What is RMI? Discuss stub and skeleton. Explain its role in creating distributed applications.

### 2082

**Section A (Attempt any TWO questions)**

1. What are the uses of focus and item event? Write a socket program using UDP to create three programs, two of which are clients to a single server. Client1 will send a character to the server process. The server will circularly decrement the letter to the previous letter in the alphabet and send the result to Client2. Then Client2 prints the letter it receives and then all the processes terminate.
2. Write a JavaFX application that creates a ChoiceBox with a list of colors. Display a label that changes its text based on the selected color from the ChoiceBox. Write down steps for writing CORBA programs with a suitable example.
3. Discuss about JSP implicit objects. Assume a database with the table TEACHER (ID, Name). Now using JDBC, execute the following SQL query:
   a. select * from TEACHER;
   b. insert into TEACHER values (8, 'Ramesh');
   c. select name from TEACHER where ID = 9;

**Section B (Attempt any EIGHT questions)**

4. Write a program to insert an icon in the frame and when the user presses the up arrow, it will move upward.
5. How do you handle HTTP request and response using JSP? Illustrate with an example.
6. Describe the life cycle of a servlet.
7. Write a program to input the name of faculty and throw an exception if that input is not "CSIT".
8. Write a program to design a layout of a simple calculator. (Arithmetic operation not required.)
9. What is a package? Differentiate between method overloading and overriding.
10. Write a program to demonstrate the concept of internal frame.
11. Write a program to create a class MOVIE with attributes name and genre. Write the movies with genre comedy on COM.DAT file.
12. Do we still need Java Applet? Justify. Give the hierarchy of Swing class.

### 2081

**Group A (Attempt any TWO questions)**

1. What is the task of the Listener interface? Write a socket program for a file server that makes a collection of files available for transmission to clients. When a client connects to the server, the server first reads a one-line command from the client. The command string can be of the form "GET \<filename\>", where \<filename\> is a file name. The server checks whether the requested file actually exists. If so, it first sends the word "OK" as a message to the client. Then it sends the contents of the file and closes the connection. Otherwise, it sends "ERROR" to the client as message and closes the connection. Assume that there is no sub directories.
2. Differentiate between path and class path in Java. When do you prefer anonymous inner class? Consider the following program and answer the given questions.
   ```java
   class A {
     class B {
       public void test() {
         int i = 0;
         while (i <= 100) {
           System.out.println(i);
           i = i + 2;
         }
       }
     }
   }
   ```
   a. Name the list of class file created after compiling above program.
   b. Rewrite the above program using for loop.
3. What are the tasks of sliders and scroll pane? Explain any four types of layout manager.

**Group B (Attempt any EIGHT questions)**

4. How does JavaFX hyperlink control format text that functions as button? Illustrate with an example.
5. Describe any two types of events.
6. How do you write an IDL file and generate the stub and skeleton code for CORBA implementation? Explain.
7. Design a simple form that takes name, password, hobbies and gender as input.
8. Assume that a text file named "ONE.TXT" contains a paragraph of text. Write a program to copy the word that starts with vowel from "ONE.TXT" to another file "TWO.TXT".
9. What do you mean by SQL escape? Describe about scrollable and updateable result sets.
10. Explain the life cycle of servlets.
11. Write a program in JSP to display the string taken in one page in another page.
12. How do you insert pop-up menu? Distinguish between GET and POST request.

### 2080

**GROUP A (Attempt any TWO questions)**

1. Why do we need to synchronize the thread? Justify with an example. An array with an odd number of elements is said to be centered if all elements (except the middle one) are strictly greater than the value of the middle element. Note that only arrays with an odd number of elements have a middle element. Write a function that accepts an integer array and returns 1 if it is a centered array, otherwise it returns 0.
2. How does JSP differ from Servlet and show the life cycle of Servlet? How do you create and read the cookies and session using JSP? Illustrate with an example.
3. Describe any two types of Layout manager. Using swing components, design a form with three buttons with captions "RED," "BLUE," and "GREEN," respectively. Then write a program to handle the event such that when the user clicks the button, the color of that button will be the same as its caption.

**Group B (Attempt any EIGHT questions)**

4. List the steps to create an RMI application. Differentiate between RMI and CORBA.
5. Write a JavaFX application with components, buttons, text fields, and labels, arranged in a VBox or HBox layout.
6. Assume a table MOVIE(id, title, genre). Now, using JDBC, perform the following queries:
   a. Add any three records to the MOVIE table.
   b. Using a prepared statement, update the genre to "Comedy" having the title "Jatra".
7. When do we need an internal frame? How do you create a table using Swing?
8. What do you mean by JSP implicit objects? Discuss Java Mail API.
9. Describe the role of Result Sets. What is wrong in the following code?
   ```java
   public class Point {
     int p;
     public void setP(int p) {
       p = p;
     }
   }
   ```
10. Write a TCP client-server system in which the client program sends two integers to a server program, which returns the greatest among them.
11. Suppose that 9 integers are written in a file named "magic.txt" in the arrangement of 3 × 3 separated by space. Write a program to check whether the integers in all rows, all columns, and both diagonals sum to the same constant or not.
12. Write a program to create a menu named "File" with menu items "New," "Save," and "Exit".

### 2079

**Section A (Attempt any two questions)**

1. Explain feature of object-oriented programming. Create a class Distance with private variables feet of type integer and inches of type floating point. Use suitable constructor, and methods for adding and comparing two distance objects. [Hint: 1 feet = 12 inches]
2. Why do we need layout management? Explain any two layout managers with example. Write a simple GUI program that displays "Hello World" in a text field. The program should display output if user clicks a button.
3. Define JSP. What are the benefits of using JSP? Create a HTML file with two text fields to first name and last name. Create a JSP file that reads data from the HTML form and display full name.

**Section B (Attempt any eight questions)**

4. What is multithreading? How can you create multithreaded program in Java? Explain.
5. What is grid layout? Compare grid layout with grid bag layout.
6. Why do we need event handling? Explain the use of action event with example.
7. Explain JDBC driver types. What is scrollable result set?
8. Write Java program that send messages with each other using TCP socket.
9. What is JavaFX? Compare it with swing. Explain FlowPane layout of JavaFX.
10. Compare JSP with servlet. What are different implicit objects in JSP?
11. Write short notes on:
    a. Final class
    b. Result set

### 2078

**Section A (Attempt any two questions)**

1. Compare AWT with Swing. Write a GUI program using components to find sum and difference of two numbers. Use two text fields for giving input and a label for output. The program should display sum if user presses mouse and difference if user release mouse.
2. Explain life-cycle of servlet in detail. Create a simple servlet that reads and displays data from HTML form. Assume form with two fields username and password.
3. Explain RMI architecture layers in detail. Write a Java programs using RMI to find product of two numbers.

**Section B (Attempt any eight questions)**

4. What is package? How can you create your own package in Java? Explain with example.
5. Why do we need swing components? Explain the uses of check boxes and radio buttons in GUI programming.
6. How can we use listener interface to handle events? Compare listener interface with adapter class.
7. What is row set? Explain cached row set in detail.
8. What is Java Mail API? How can you use this API to send email messages?
9. Compare JavaFX with swing. Explain HBox and VBox layouts of JavaFX.
10. What is servlet? Write a simple JSP file to display "Tribhuwan University" five times.
11. Why CORBA is important? Compare CORBA with RMI.
12. Write short notes on:
    a. JDBC drivers
    b. Java server pages

### Predicted Paper

**Group A (Attempt any TWO questions)**

1. What is multithreading? Explain thread synchronization with suitable example. Write a Java program demonstrating producer-consumer problem using inter-thread communication (wait, notify, notifyAll).
2. Design a GUI application using Swing that contains a combo box with list of cities, a text area, and a button. When a city is selected from the combo box, display its famous places in the text area. Use appropriate layout manager and handle necessary events.
3. Discuss JSP implicit objects in detail. Create an HTML form that accepts employee id and name. Create a JSP file that receives this data, stores it in a database table EMPLOYEE, and displays a confirmation message. Assume appropriate database configuration.

**Group B (Attempt any EIGHT questions)**

4. What is the significance of the `static` modifier in Java? Explain static variables, static methods, and static blocks with suitable examples.
5. What is Window Event? Explain how to handle window events in Java with a suitable example using WindowListener or WindowAdapter.
6. Explain Group Layout in Swing. How does it differ from other layout managers?
7. How do you use the `InetAddress` class in Java? Write a program to find the IP address of a given domain name and display the local host address.
8. Explain JDBC Architecture with a neat diagram. List and briefly describe the four types of JDBC drivers.
9. Write a JavaFX application that uses BorderPane layout. Place a label in the top region, a text field in the center, and two buttons in the bottom region. Style the components using inline CSS.
10. Explain JSP directives, declarations, expressions, and scriptlets with code examples. Differentiate between page directive and include directive.
11. What is a custom exception class in Java? Write a program that creates a custom exception named `InvalidAgeException` and demonstrates its use in age validation.
12. Explain the architecture of CORBA. How does the Object Request Broker (ORB) facilitate communication between client and server?

### 2077

**Group A (Attempt any two questions)**

1. What is the significance of stub and skeleton in RMI? Create a RMI application such that a client sends an Integer number to the server and the server return the factorial value of that integer. Give a clear specification for every step.
2. You are hired by a reputed software company which is going to design an application for "Movie Rental System". Your responsibility is to design a schema named MRS and create a table named Movie(id, Title, Genre, Language, Length). Write a program to design a GUI form to take input for this table and insert the data into table after clicking the OK button.
3. Describe the responsibility of Serializable interface. Write a program to read an input string from the user and write the vowels of that string in VOWEL.TXT and consonants in CONSONANT.TXT.

**Group B (Attempt any eight questions)**

4. A non-empty array A of length n is called an array of all possibilities if it contains all numbers between 0 and A.length-1 inclusive. Write a method named isAllPossibilities that accepts an integer array and returns 1 if the array is an array of all possibilities, otherwise it returns 0.
5. Define event delegation model. Why do we need adapter class in event handling?
6. What is the task of Layout manager? Describe about default layout manager.
7. When does the finally block is mandatory in while handling exception? Describe with a suitable scenario.
8. Explain the life cycle of a servlet.
9. What is the task of manifest file? Write the procedure to create it.
10. Why multiple inheritance is not allowed in Java using classes? Give an example.
11. How forms can be created and processed using JSP? Make it clear with your own assumptions.
12. Why synchronization is essential in multithreading? Describe.
13. Write short notes on:
    a. JAVA beans and JAR file
    b. MVC design pattern
