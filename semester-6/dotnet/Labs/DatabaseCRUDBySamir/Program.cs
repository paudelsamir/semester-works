using Microsoft.Data.SqlClient;
using System;

namespace DatabaseCRUDBySamir
{
    class Program
    {
        // Connection string - UPDATE THIS with your SQL Server details
        private static string connectionString = 
            "Server=localhost;Database=StudentDB;User Id=sa;Password=YourPassword;TrustServerCertificate=True;";

        static void Main(string[] args)
        {
            Console.WriteLine("====================================");
            Console.WriteLine("  SQL Server CRUD Operations Demo");
            Console.WriteLine("  Lab No.: 20");
            Console.WriteLine("  Name: Samir Paudel");
            Console.WriteLine("  Roll No./Section: 114-079/D");
            Console.WriteLine("====================================\n");

            // Create database and table if not exists
            CreateDatabaseAndTable();

            bool exit = false;

            while (!exit)
            {
                Console.WriteLine("\n========== MENU ==========");
                Console.WriteLine("1. Insert Student Record");
                Console.WriteLine("2. Read All Students");
                Console.WriteLine("3. Read Student by ID");
                Console.WriteLine("4. Update Student Record");
                Console.WriteLine("5. Delete Student Record");
                Console.WriteLine("6. Exit");
                Console.Write("\nEnter your choice (1-6): ");

                string choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        InsertStudent();
                        break;
                    case "2":
                        ReadAllStudents();
                        break;
                    case "3":
                        ReadStudentById();
                        break;
                    case "4":
                        UpdateStudent();
                        break;
                    case "5":
                        DeleteStudent();
                        break;
                    case "6":
                        exit = true;
                        Console.WriteLine("\nThank you! Exiting program...");
                        break;
                    default:
                        Console.WriteLine("\nInvalid choice! Please try again.");
                        break;
                }
            }
        }

        static void CreateDatabaseAndTable()
        {
            try
            {
                // First connect to master database to create StudentDB if not exists
                string masterConn = "Server=localhost;Database=master;User Id=sa;Password=YourPassword;TrustServerCertificate=True;";
                
                using (SqlConnection conn = new SqlConnection(masterConn))
                {
                    conn.Open();
                    
                    string createDbQuery = @"
                        IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'StudentDB')
                        BEGIN
                            CREATE DATABASE StudentDB;
                        END";
                    
                    using (SqlCommand cmd = new SqlCommand(createDbQuery, conn))
                    {
                        cmd.ExecuteNonQuery();
                    }
                }

                // Now connect to StudentDB and create table
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();
                    
                    string createTableQuery = @"
                        IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Students')
                        BEGIN
                            CREATE TABLE Students (
                                StudentID INT PRIMARY KEY IDENTITY(1,1),
                                Name NVARCHAR(100) NOT NULL,
                                Email NVARCHAR(100) NOT NULL,
                                Age INT NOT NULL,
                                Course NVARCHAR(50) NOT NULL,
                                City NVARCHAR(50) NOT NULL,
                                CreatedDate DATETIME DEFAULT GETDATE()
                            );
                        END";
                    
                    using (SqlCommand cmd = new SqlCommand(createTableQuery, conn))
                    {
                        cmd.ExecuteNonQuery();
                        Console.WriteLine("Database and table initialized successfully.\n");
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error creating database/table: {ex.Message}");
            }
        }

        // CREATE (INSERT)
        static void InsertStudent()
        {
            Console.WriteLine("\n===== INSERT STUDENT RECORD =====");
            
            Console.Write("Enter Name: ");
            string name = Console.ReadLine();
            
            Console.Write("Enter Email: ");
            string email = Console.ReadLine();
            
            Console.Write("Enter Age: ");
            int age = int.Parse(Console.ReadLine());
            
            Console.Write("Enter Course: ");
            string course = Console.ReadLine();
            
            Console.Write("Enter City: ");
            string city = Console.ReadLine();

            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();
                    
                    string query = @"INSERT INTO Students (Name, Email, Age, Course, City) 
                                   VALUES (@Name, @Email, @Age, @Course, @City)";
                    
                    using (SqlCommand cmd = new SqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@Name", name);
                        cmd.Parameters.AddWithValue("@Email", email);
                        cmd.Parameters.AddWithValue("@Age", age);
                        cmd.Parameters.AddWithValue("@Course", course);
                        cmd.Parameters.AddWithValue("@City", city);
                        
                        int rowsAffected = cmd.ExecuteNonQuery();
                        Console.WriteLine($"\n✓ Student record inserted successfully! ({rowsAffected} row affected)");
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n✗ Error: {ex.Message}");
            }
        }

        // READ (SELECT ALL)
        static void ReadAllStudents()
        {
            Console.WriteLine("\n===== ALL STUDENT RECORDS =====");
            
            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();
                    
                    string query = "SELECT * FROM Students ORDER BY StudentID";
                    
                    using (SqlCommand cmd = new SqlCommand(query, conn))
                    {
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (!reader.HasRows)
                            {
                                Console.WriteLine("\nNo records found.");
                                return;
                            }

                            Console.WriteLine("\n{0,-5} {1,-20} {2,-30} {3,-5} {4,-20} {5,-15}", 
                                "ID", "Name", "Email", "Age", "Course", "City");
                            Console.WriteLine(new string('-', 105));
                            
                            while (reader.Read())
                            {
                                Console.WriteLine("{0,-5} {1,-20} {2,-30} {3,-5} {4,-20} {5,-15}",
                                    reader["StudentID"],
                                    reader["Name"],
                                    reader["Email"],
                                    reader["Age"],
                                    reader["Course"],
                                    reader["City"]);
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n✗ Error: {ex.Message}");
            }
        }

        // READ (SELECT BY ID)
        static void ReadStudentById()
        {
            Console.WriteLine("\n===== READ STUDENT BY ID =====");
            
            Console.Write("Enter Student ID: ");
            int studentId = int.Parse(Console.ReadLine());
            
            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();
                    
                    string query = "SELECT * FROM Students WHERE StudentID = @StudentID";
                    
                    using (SqlCommand cmd = new SqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@StudentID", studentId);
                        
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                Console.WriteLine("\nStudent Details:");
                                Console.WriteLine($"ID:        {reader["StudentID"]}");
                                Console.WriteLine($"Name:      {reader["Name"]}");
                                Console.WriteLine($"Email:     {reader["Email"]}");
                                Console.WriteLine($"Age:       {reader["Age"]}");
                                Console.WriteLine($"Course:    {reader["Course"]}");
                                Console.WriteLine($"City:      {reader["City"]}");
                                Console.WriteLine($"Created:   {reader["CreatedDate"]}");
                            }
                            else
                            {
                                Console.WriteLine($"\n✗ No student found with ID {studentId}");
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n✗ Error: {ex.Message}");
            }
        }

        // UPDATE
        static void UpdateStudent()
        {
            Console.WriteLine("\n===== UPDATE STUDENT RECORD =====");
            
            Console.Write("Enter Student ID to update: ");
            int studentId = int.Parse(Console.ReadLine());
            
            // First check if student exists
            bool exists = false;
            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();
                    string checkQuery = "SELECT COUNT(*) FROM Students WHERE StudentID = @StudentID";
                    using (SqlCommand cmd = new SqlCommand(checkQuery, conn))
                    {
                        cmd.Parameters.AddWithValue("@StudentID", studentId);
                        int count = (int)cmd.ExecuteScalar();
                        exists = count > 0;
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n✗ Error: {ex.Message}");
                return;
            }

            if (!exists)
            {
                Console.WriteLine($"\n✗ No student found with ID {studentId}");
                return;
            }

            Console.Write("Enter New Name: ");
            string name = Console.ReadLine();
            
            Console.Write("Enter New Email: ");
            string email = Console.ReadLine();
            
            Console.Write("Enter New Age: ");
            int age = int.Parse(Console.ReadLine());
            
            Console.Write("Enter New Course: ");
            string course = Console.ReadLine();
            
            Console.Write("Enter New City: ");
            string city = Console.ReadLine();

            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();
                    
                    string query = @"UPDATE Students 
                                   SET Name = @Name, Email = @Email, Age = @Age, 
                                       Course = @Course, City = @City 
                                   WHERE StudentID = @StudentID";
                    
                    using (SqlCommand cmd = new SqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@StudentID", studentId);
                        cmd.Parameters.AddWithValue("@Name", name);
                        cmd.Parameters.AddWithValue("@Email", email);
                        cmd.Parameters.AddWithValue("@Age", age);
                        cmd.Parameters.AddWithValue("@Course", course);
                        cmd.Parameters.AddWithValue("@City", city);
                        
                        int rowsAffected = cmd.ExecuteNonQuery();
                        Console.WriteLine($"\n✓ Student record updated successfully! ({rowsAffected} row affected)");
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n✗ Error: {ex.Message}");
            }
        }

        // DELETE
        static void DeleteStudent()
        {
            Console.WriteLine("\n===== DELETE STUDENT RECORD =====");
            
            Console.Write("Enter Student ID to delete: ");
            int studentId = int.Parse(Console.ReadLine());

            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();
                    
                    string query = "DELETE FROM Students WHERE StudentID = @StudentID";
                    
                    using (SqlCommand cmd = new SqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@StudentID", studentId);
                        
                        int rowsAffected = cmd.ExecuteNonQuery();
                        
                        if (rowsAffected > 0)
                        {
                            Console.WriteLine($"\n✓ Student record deleted successfully! ({rowsAffected} row affected)");
                        }
                        else
                        {
                            Console.WriteLine($"\n✗ No student found with ID {studentId}");
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n✗ Error: {ex.Message}");
            }
        }
    }
}
