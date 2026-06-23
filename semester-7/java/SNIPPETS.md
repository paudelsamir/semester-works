# Syllabus Code Snippets

## Unit 1 — Core Java

### Interface
```java
interface MyInterface {
    void myMethod();
}
class MyClass implements MyInterface {
    public void myMethod() {
        System.out.println("Hello");
    }
}
```

### Inner Class (Member)
```java
class Outer {
    private int x = 10;
    class Inner {
        void show() { System.out.println(x); }
    }
}
// Usage: Outer.Inner i = new Outer().new Inner();
```

### Static Nested Class
```java
class Outer {
    static int x = 10;
    static class Nested {
        void show() { System.out.println(x); }
    }
}
// Usage: Outer.Nested n = new Outer.Nested();
```

### Final
```java
class Parent {
    final void cannotOverride() { }
}
class Child extends Parent {
    // void cannotOverride() { }  ← ERROR
}
```

### Static
```java
class A {
    static void method() { }
}
A.method();  // call without object
```

### Packages
```java
// File: myPackage/Sum.java
package myPackage;
public class Sum {
    public int add(int a, int b) { return a + b; }
}

// File: Main.java
import myPackage.Sum;
Sum s = new Sum();
s.add(3, 2);
```

### Custom Exception
```java
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) { super(msg); }
}
class Test {
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Too young");
        else System.out.println("OK");
    }
    public static void main(String[] args) {
        try { validate(15); }
        catch (InvalidAgeException e) { System.out.println(e); }
    }
}
```

### Thread (extend Thread)
```java
class MyThread extends Thread {
    public void run() { System.out.println("Running"); }
}
MyThread t = new MyThread();
t.start();
```

### Thread (implement Runnable)
```java
class MyThread implements Runnable {
    public void run() { System.out.println("Running"); }
}
Thread t = new Thread(new MyThread());
t.start();
```

### Synchronization
```java
class Table {
    synchronized void print(int n) {
        for (int i = 1; i <= 5; i++) System.out.println(n * i);
    }
}
class A extends Thread {
    Table t;
    A(Table t) { this.t = t; }
    public void run() { t.print(2); }
}
class B extends Thread {
    Table t;
    B(Table t) { this.t = t; }
    public void run() { t.print(3); }
}
// Main: Table t = new Table(); new A(t).start(); new B(t).start();
```

### Thread Priorities
```java
t1.setPriority(Thread.MIN_PRIORITY);  // 1
t2.setPriority(Thread.MAX_PRIORITY);  // 10
t3.setPriority(Thread.NORM_PRIORITY); // 5
```

---

## Unit 2 — Swing

### JFrame + Layout
```java
JFrame f = new JFrame("Title");
f.setSize(400, 300);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLayout(new FlowLayout());  // or BorderLayout, GridLayout
f.add(new JButton("Click"));
f.setVisible(true);
```

### GridBagLayout
```java
JPanel p = new JPanel(new GridBagLayout());
GridBagConstraints g = new GridBagConstraints();
g.gridx = 0; g.gridy = 0;  // position
p.add(new JButton("Button1"), g);
g.gridx = 1; g.gridy = 0;
p.add(new JButton("Button2"), g);
```

### Menu + Mnemonic + Accelerator
```java
JMenuBar mb = new JMenuBar();
JMenu file = new JMenu("File");
file.setMnemonic('F');
JMenuItem save = new JMenuItem("Save");
save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
file.add(save);
mb.add(file);
f.setJMenuBar(mb);
```

### Toolbar
```java
JToolBar tb = new JToolBar();
tb.add(new JButton("Cut"));
tb.add(new JComboBox<>(new String[]{"A","B"}));
f.add(tb, BorderLayout.NORTH);
```

### Dialog / ColorChooser / FileChooser
```java
// Message
JOptionPane.showMessageDialog(f, "Hello");

// Color
Color c = JColorChooser.showDialog(f, "Pick", Color.RED);

// File
JFileChooser fc = new JFileChooser();
fc.showOpenDialog(f);
```

### Internal Frame
```java
JDesktopPane dp = new JDesktopPane();
JInternalFrame iframe = new JInternalFrame("Child", true, true, true, true);
iframe.setSize(200, 100);
iframe.add(new JLabel("Inside"));
iframe.setVisible(true);
dp.add(iframe);
f.add(dp);
```

### Applet
```java
import java.applet.*;
import java.awt.*;
public class MyApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello", 20, 20);
    }
}
// HTML: <applet code="MyApplet.class" width="200" height="100"></applet>
```

---

## Unit 3 — Event Handling

### ActionEvent (Button click)
```java
class MyClass implements ActionListener {
    JTextField t1, t2, t3;
    JButton b;
    MyClass() {
        // ... create components
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        t3.setText(String.valueOf(a + b));
    }
}
```

### MouseEvent
```java
class MyClass implements MouseListener {
    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
}
// Or use MouseAdapter to skip unused methods
```

---

## Unit 4 — JDBC

### Full CRUD
```java
import java.sql.*;

Class.forName("com.mysql.jdbc.Driver");  // or "org.h2.Driver"
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

// CREATE TABLE
con.createStatement().executeUpdate("CREATE TABLE users (id INT, name VARCHAR(50))");

// INSERT
PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?, ?)");
ps.setInt(1, 1);
ps.setString(2, "Alice");
ps.executeUpdate();

// SELECT
ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
while (rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
}

// UPDATE
con.createStatement().executeUpdate("UPDATE users SET name='Bob' WHERE id=1");

// DELETE
con.createStatement().executeUpdate("DELETE FROM users WHERE id=1");

con.close();
```

### Scrollable / Updatable ResultSet
```java
Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = st.executeQuery("SELECT * FROM users");
rs.last();           // go to last row
rs.first();          // go to first row
rs.absolute(3);      // go to row 3
```

### Transactions
```java
con.setAutoCommit(false);
try {
    // execute statements...
    con.commit();
} catch (Exception e) {
    con.rollback();
} finally {
    con.setAutoCommit(true);
}
```

### SQL Escape
```java
// LIKE escape
"SELECT * FROM users WHERE name LIKE '100%' {escape '0'}"

// Function
"SELECT {fn UCASE(name)} FROM users"
```

---

## Unit 5 — Networking

### TCP Client
```java
Socket s = new Socket("localhost", 4241);
Scanner in = new Scanner(s.getInputStream());
PrintWriter out = new PrintWriter(s.getOutputStream(), true);
out.println("Hello");
System.out.println(in.nextLine());
s.close();
```

### TCP Server
```java
ServerSocket ss = new ServerSocket(4241);
Socket s = ss.accept();  // waits for client
Scanner in = new Scanner(s.getInputStream());
PrintWriter out = new PrintWriter(s.getOutputStream(), true);
System.out.println(in.nextLine());
out.println("Hi back");
s.close();
ss.close();
```

### UDP Client
```java
DatagramSocket ds = new DatagramSocket();
InetAddress addr = InetAddress.getByName("localhost");
byte[] data = "Hello".getBytes();
DatagramPacket p = new DatagramPacket(data, data.length, addr, 9876);
ds.send(p);
```

### UDP Server
```java
DatagramSocket ds = new DatagramSocket(9876);
byte[] buf = new byte[1024];
DatagramPacket p = new DatagramPacket(buf, buf.length);
ds.receive(p);
System.out.println(new String(p.getData(), 0, p.getLength()));
```

### Email
```java
Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");
Session session = Session.getInstance(props);
MimeMessage msg = new MimeMessage(session);
msg.setFrom(new InternetAddress("from@gmail.com"));
msg.addRecipient(Message.RecipientType.TO, new InternetAddress("to@gmail.com"));
msg.setSubject("Test");
msg.setText("Hello");
Transport.send(msg);
```

---

## Unit 6 — JavaFX

```java
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Main extends Application {
    public void start(Stage stage) {
        RadioButton r1 = new RadioButton("A");
        RadioButton r2 = new RadioButton("B");
        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);

        Button btn = new Button("Click");
        btn.setOnAction(e -> System.out.println("Clicked"));

        VBox root = new VBox(10);  // spacing=10
        root.getChildren().addAll(r1, r2, btn);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) { launch(args); }
}
```

---

## Unit 7 — Servlets & JSP

### Servlet: Read form & print
```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        out.println("<p>User: " + user + "</p>");
        out.println("<p>Pass: " + pass + "</p>");
    }
}
```

### JSP: Read form & print
```jsp
<%-- example.jsp --%>
<%@ page language="java" contentType="text/html" %>
<html>
<body>
    <h2>Your input:</h2>
    <%
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        out.println(fname + " " + lname);
    %>
</body>
</html>
```

### Cookie
```java
// Set
Cookie c = new Cookie("user", "Alice");
c.setMaxAge(86400);
response.addCookie(c);

// Read
Cookie[] cookies = request.getCookies();
for (Cookie c : cookies) {
    if (c.getName().equals("user")) System.out.println(c.getValue());
}
```

### Session
```java
HttpSession session = request.getSession();
session.setAttribute("key", "value");       // store
String val = (String) session.getAttribute("key");  // read
session.invalidate();  // destroy
```

---

## Unit 8 — RMI & CORBA

### RMI

**Step 1 — Remote Interface:**
```java
import java.rmi.*;
public interface Adder extends Remote {
    int add(int x, int y) throws RemoteException;
}
```

**Step 2 — Implementation:**
```java
import java.rmi.*;
import java.rmi.server.*;
public class AdderImpl extends UnicastRemoteObject implements Adder {
    public AdderImpl() throws RemoteException { }
    public int add(int x, int y) { return x + y; }
}
```

**Step 3 — Server:**
```java
AdderImpl obj = new AdderImpl();
LocateRegistry.createRegistry(1099);
Naming.rebind("rmi://localhost/AdderService", obj);
```

**Step 4 — Client:**
```java
Adder obj = (Adder) Naming.lookup("rmi://localhost/AdderService");
System.out.println(obj.add(3, 4));  // 7
```

### CORBA (IDL → compile → use)
```java
// HelloApp.idl
module HelloApp {
    interface Hello {
        string sayHello();
    };
};

// Compile: idlj -fall HelloApp.idl
// Then implement, create server/client similar to RMI pattern
```
