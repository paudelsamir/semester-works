# Syllabus — When to Use What + Import Locations

## Unit 1 — Core Java
**Location:** `$JAVA_HOME/lib/modules` (module `java.base`) — auto-available, no extra JAR needed.

```java
import java.lang.*;   // auto-imported: String, Thread, Exception, System
import java.util.*;   // Arrays, Scanner, ArrayList, HashMap
import java.io.*;     // File, InputStream, OutputStream, Reader, Writer
import java.io.Serializable;
```

| You want to... | Use |
|---|---|
| Store text | `String`, `StringBuilder` |
| Store a list/map | `ArrayList`, `HashMap` |
| Run code in parallel | `Thread`, `Runnable` |
| Handle errors | `try {} catch(Exception e) {}` |
| Read/write a file | `FileReader`/`FileWriter` or `InputStream`/`OutputStream` |
| Read/write objects | `ObjectInputStream`/`ObjectOutputStream` + `implements Serializable` |

## Unit 2 — Swing
**Location:** module `java.desktop` in JDK — no extra JAR needed.

```java
import javax.swing.*;  // JFrame, JButton, JLabel, JTextField, JTable, JTree, JMenu, etc.
import java.awt.*;     // FlowLayout, BorderLayout, GridLayout, Color, Font
import java.applet.*;  // Applet, AppletStub
```

| You want to... | Use |
|---|---|
| A window | `JFrame` |
| A popup window | `JDialog` |
| Arrange buttons in a row | `JPanel` + `FlowLayout` |
| Arrange in a grid | `GridLayout` or `GridBagLayout` |
| A text box | `JTextField` |
| A password box | `JPasswordField` |
| A big text area | `JTextArea` + `JScrollPane` |
| A checkbox | `JCheckBox` |
| Radio buttons (choose one) | `JRadioButton` + `ButtonGroup` |
| A dropdown | `JComboBox` |
| A slider | `JSlider` |
| A menu bar | `JMenuBar` → `JMenu` → `JMenuItem` |
| A table | `JTable` + `DefaultTableModel` |
| A tree | `JTree` + `DefaultMutableTreeNode` |
| A file picker | `JFileChooser` |
| A simple message popup | `JOptionPane.showMessageDialog()` |
| Toolbar with icons | `JToolBar` + `ImageIcon` |

## Unit 3 — Event Handling
**Location:** same module as Swing (`java.desktop`).

```java
import java.awt.event.*;    // ActionListener, KeyListener, MouseListener, WindowListener
import javax.swing.event.*; // ListSelectionListener, ChangeListener, DocumentListener
```

| When user does... | Use listener |
|---|---|
| Clicks a button | `ActionListener` |
| Types a key | `KeyListener` |
| Clicks mouse | `MouseListener` |
| Moves mouse | `MouseMotionListener` |
| Closes window | `WindowListener` |
| Selects a checkbox | `ItemListener` |
| Moves a slider | `ChangeListener` |
| Selects a table row | `ListSelectionListener` |

**Adapter shortcut:** Use `MouseAdapter` instead of `MouseListener` if you only need 1 of its 5 methods.

## Unit 4 — JDBC
**Location:** `java.sql` module in JDK + your DB driver JAR (e.g., `WEB-INF/lib/h2-2.2.224.jar`).

```java
import java.sql.*;  // DriverManager, Connection, Statement, PreparedStatement, ResultSet, SQLException
```

| You want to... | Use |
|---|---|
| Connect to DB | `DriverManager.getConnection(url)` |
| Run a plain query | `Statement.executeQuery("SELECT ...")` |
| Run a query with user input | `PreparedStatement` + `setString()` (prevents SQL injection) |
| Loop through results | `while (rs.next()) { rs.getString("col"); }` |
| Insert/update/delete | `executeUpdate()` |
| Scroll back/forward | `ResultSet.TYPE_SCROLL_INSENSITIVE` |
| Update a row directly | `ResultSet.CONCUR_UPDATABLE` + `updateRow()` |
| Work offline | `CachedRowSet` |
| Group operations together | `setAutoCommit(false)` → commit/rollback |

## Unit 5 — Networking
**Location:** `java.base` module in JDK for `java.net.*`; `javax.mail.jar` (external) for email.

```java
import java.net.*;  // Socket, ServerSocket, DatagramSocket, URL, URLConnection
// For email, add javax.mail.jar to classpath:
import javax.mail.*;  // Session, Message, Transport
import javax.mail.internet.*;  // MimeMessage, InternetAddress
```

| You want to... | Use |
|---|---|
| Connect to a server (TCP) | `Socket` + `getInputStream()`/`getOutputStream()` |
| Accept clients (TCP server) | `ServerSocket` + `accept()` |
| Send/receive UDP | `DatagramSocket` + `DatagramPacket` |
| Download a webpage | `URL("https://...").openStream()` |
| Send HTTP request manually | `HttpURLConnection` |
| Send an email | `Session` → `MimeMessage` → `Transport.send()` |

## Unit 6 — JavaFX
**Location:** External JavaFX SDK (not in JDK by default). Download and add `javafx-base.jar`, `javafx-controls.jar`, etc.

```java
import javafx.application.*;  // Application, Platform
import javafx.stage.*;        // Stage, Scene, FileChooser
import javafx.scene.*;        // Node, Group, Image
import javafx.scene.layout.*; // FlowPane, BorderPane, HBox, VBox, GridPane
import javafx.scene.control.*;// Label, Button, TextField, MenuBar, TableView
import javafx.event.*;        // Event, ActionEvent, EventHandler
```

| You want to... | Use |
|---|---|
| Start a JavaFX app | `extends Application` + `@Override start()` |
| The window | `Stage` (passed to `start()`) |
| The content area | `Scene` |
| Arrange horizontally | `HBox` |
| Arrange vertically | `VBox` |
| Flexible grid | `GridPane` |
| A button | `Button` |
| React to button click | `button.setOnAction(e -> { ... })` |
| Show an alert | `Alert(AlertType.INFORMATION)` |
| A file chooser | `FileChooser.showOpenDialog()` |

## Unit 7 — Servlets & JSP
**Location:** `$TOMCAT_HOME/lib/servlet-api.jar` + `jsp-api.jar` + `el-api.jar`. Add them to classpath when compiling.

```java
// Servlet imports (from servlet-api.jar)
import javax.servlet.*;         // Servlet, ServletConfig, ServletContext, RequestDispatcher
import javax.servlet.http.*;    // HttpServlet, HttpServletRequest, HttpServletResponse, HttpSession, Cookie
import javax.servlet.annotation.*;  // WebServlet

// JSP imports (from jsp-api.jar)
import javax.servlet.jsp.*;     // JspWriter (out), PageContext

// EL imports (from el-api.jar) — for ${...}
import javax.el.*;              // ELProcessor, ValueExpression

// In JSP files, use directives instead of imports:
// <%@ page import="java.util.*" %>
// <%@ page import="java.sql.*" %>
```

**JSP Implicit Objects** (available in scriptlets without any import):
```
request   ← HttpServletRequest
response  ← HttpServletResponse
session   ← HttpSession
application ← ServletContext
out       ← JspWriter (like PrintWriter for HTML)
config    ← ServletConfig
page      ← this (the generated servlet)
pageContext ← PageContext
```

**JSP Scopes (narrowest → widest):**
```
pageScope → requestScope → sessionScope → applicationScope
```

| You want to... | Use |
|---|---|
| Handle form data | `HttpServlet` + `doPost()` → `request.getParameter()` |
| Show a page (GET) | `doGet()` → `response.getWriter().println()` |
| Store data for one user | `session.setAttribute("key", value)` |
| Remember across visits | `Cookie` + `response.addCookie(cookie)` |
| Keep data across all users | `application.setAttribute("key", value)` |
| Redirect to another page | `response.sendRedirect("page.jsp")` |
| Show dynamic value in HTML | JSP: `<%= expr %>` or `${expr}` |
| Write Java logic in a JSP | `<% ... %>` scriptlet |
| Define a method in JSP | `<%! ... %>` declaration |
| Import classes in JSP | `<%@ page import="java.util.*" %>` |
| Map a URL to a servlet | `@WebServlet("/path")` |

## Unit 8 — RMI & CORBA
**Location:** `java.rmi` module in JDK for RMI. CORBA (`org.omg.CORBA.*`) removed from JDK 11+.

```java
// RMI (from java.rmi module)
import java.rmi.*;           // Remote, RemoteException
import java.rmi.server.*;    // UnicastRemoteObject
import java.rmi.registry.*;  // Registry, LocateRegistry
import java.rmi.Naming;      // Naming.rebind(), Naming.lookup()

// CORBA (removed from JDK 11 — required older JDK or separate download)
import org.omg.CORBA.*;      // ORB, Any, SystemException
import org.omg.CosNaming.*;  // NamingContext, NameComponent
import org.omg.PortableServer.*;  // POA, Servant
```

| You want to... | Use |
|---|---|
| Call a Java method on another machine | RMI |
| Define a remote service | `extends UnicastRemoteObject`, implement a `Remote` interface |
| Start the registry | `LocateRegistry.createRegistry(1099)` |
| Register your service | `Naming.rebind("rmi://localhost/MyService", obj)` |
| Call from client | `Naming.lookup("rmi://localhost/MyService")` |
| Call methods across languages (Java ↔ C++) | CORBA |
| Start CORBA | `ORB.init(args, null)` |
| Define the interface | IDL file (`.idl`) |
| Generate Java stubs | `idlj` compiler |
