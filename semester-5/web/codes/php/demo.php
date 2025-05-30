<?php
// Database configuration
$host = "localhost";
$username = "root";
$password = "";
$database = "student_db";

// Create connection
$conn = mysqli_connect($host, $username, $password, $database);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Function to insert data into database
function insertdb($name, $email, $phone, $conn) {
    $sql = "INSERT INTO students (name, email, phone) VALUES ('$name', '$email', '$phone')";
    
    if (mysqli_query($conn, $sql)) {
        echo "<p style='color: green;'>Record inserted successfully!</p>";
    } else {
        echo "<p style='color: red;'>Error: " . mysqli_error($conn) . "</p>";
    }
}

// Function to display all records from database
function display($conn) {
    $sql = "SELECT * FROM students";
    $result = mysqli_query($conn, $sql);
    
    if (mysqli_num_rows($result) > 0) {
        echo "<h3>Student Records:</h3>";
        echo "<table border='1' cellpadding='10' cellspacing='0'>";
        echo "<tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th></tr>";
        
        while($row = mysqli_fetch_assoc($result)) {
            echo "<tr>";
            echo "<td>" . $row['id'] . "</td>";
            echo "<td>" . $row['name'] . "</td>";
            echo "<td>" . $row['email'] . "</td>";
            echo "<td>" . $row['phone'] . "</td>";
            echo "</tr>";
        }
        echo "</table>";
    } else {
        echo "<p>No records found.</p>";
    }
}

// Handle form submission
if ($_POST) {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    
    // Call insertdb function
    insertdb($name, $email, $phone, $conn);
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        form {
            background-color: #f4f4f4;
            padding: 20px;
            border-radius: 5px;
            width: 400px;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        table {
            margin-top: 30px;
            border-collapse: collapse;
        }
        th {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
    <h2>Student Registration Form</h2>
    
    <!-- HTML Form -->
    <form method="POST" action="">
        <label>Name:</label><br>
        <input type="text" name="name" required><br>
        
        <label>Email:</label><br>
        <input type="email" name="email" required><br>
        
        <label>Phone:</label><br>
        <input type="text" name="phone" required><br>
        
        <input type="submit" value="Submit">
    </form>
    
    <hr>
    
    <?php
    // Display all records
    display($conn);
    
    // Close connection
    mysqli_close($conn);
    ?>
</body>
</html>