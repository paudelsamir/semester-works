# Lab 20: Database CRUD Operations with SQL Server

## Student Information
- **Name:** Samir Paudel
- **Roll No./Section:** 114-079/D
- **Lab No:** 20

## Project Description
A Console Application in C# demonstrating INSERT, READ, UPDATE, and DELETE (CRUD) operations with SQL Server database.

## Database Structure

### Table: Students

```sql
CREATE TABLE Students (
    StudentID INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Age INT NOT NULL,
    Course NVARCHAR(50) NOT NULL,
    City NVARCHAR(50) NOT NULL,
    CreatedDate DATETIME DEFAULT GETDATE()
);
```

### Column Descriptions:
- **StudentID**: Auto-incrementing primary key
- **Name**: Student's full name (up to 100 characters)
- **Email**: Student's email address (up to 100 characters)
- **Age**: Student's age (integer)
- **Course**: Course name (up to 50 characters)
- **City**: Student's city (up to 50 characters)
- **CreatedDate**: Timestamp when record was created (auto-generated)
