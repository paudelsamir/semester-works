using Microsoft.Data.Sqlite; // namespace for sqlite database access
using Microsoft.Extensions.Configuration; // namespace for reading configuration (like connection strings)
using System.Collections.Generic;
using System;

namespace webAppDemo.Models
{
    public class DataAccess
    {
        private readonly string _connectionString; // stores the connection string for sqlite

        // constructor receives IConfiguration to get the connection string from appsettings.json
        public DataAccess(IConfiguration configuration)
        {
            _connectionString = configuration.GetConnectionString("TodoDbConnection"); // type: string
        }

        // helper method to create a new SqliteConnection object
        private SqliteConnection GetConnection() // returns SqliteConnection
        {
            return new SqliteConnection(_connectionString); // does not open yet, just constructs the object
        }

        // Get all persons
        public List<PersonModel> GetAllPersons() // returns a list of PersonModel objects
        {
            var persons = new List<PersonModel>(); // initialize empty list to store results
            using (var conn = GetConnection()) // creates a connection and disposes it automatically after use
            {
                string query = "SELECT * FROM Persons"; // SQL query string
                var cmd = new SqliteCommand(query, conn); // command object to execute query, type: SqliteCommand
                conn.Open(); // open the connection
                using (var reader = cmd.ExecuteReader()) // execute query and get a reader to loop through results
                {
                    while (reader.Read()) // loop through each row returned
                    {
                        persons.Add(new PersonModel // map database row to PersonModel object
                        {
                            Name = reader["Name"].ToString() ?? "", // get string value of column "Name", fallback to empty string
                            Age = reader.GetInt32(reader.GetOrdinal("Age")), // get integer value of column "Age"
                            Email = reader["Email"].ToString() ?? "", // get string value of column "Email", fallback to empty string
                            Github = reader["Github"].ToString() ?? "" // get string value of column "Github", fallback to empty string
                        });
                    }
                }
            }
            return persons; // return the list of PersonModel objects
        }

        // Get person by name (or you can use Id if you add it)
        public PersonModel? GetPersonByName(string name) // returns PersonModel or null if not found
        {
            PersonModel? person = null; // initialize as null
            using (var conn = GetConnection())
            {
                string query = "SELECT * FROM Persons WHERE Name=@Name"; // SQL query with parameter
                var cmd = new SqliteCommand(query, conn); // command object
                cmd.Parameters.AddWithValue("@Name", name); // add parameter value to prevent SQL injection
                conn.Open();
                using (var reader = cmd.ExecuteReader()) // execute and get reader
                {
                    if (reader.Read()) // if a row exists
                    {
                        person = new PersonModel
                        {
                            Name = reader["Name"].ToString() ?? "",
                            Age = reader.GetInt32(reader.GetOrdinal("Age")),
                            Email = reader["Email"].ToString() ?? "",
                            Github = reader["Github"].ToString() ?? ""
                        };
                    }
                }
            }
            return person; // return PersonModel or null
        }

        // Create person
        public void CreatePerson(PersonModel person) // returns void
        {
            using (var conn = GetConnection())
            {
                string query = "INSERT INTO Persons (Name, Age, Email, Github) VALUES (@Name, @Age, @Email, @Github)";
                var cmd = new SqliteCommand(query, conn); // create command with insert query
                // add parameter values to command
                cmd.Parameters.AddWithValue("@Name", person.Name); // string
                cmd.Parameters.AddWithValue("@Age", person.Age); // int
                cmd.Parameters.AddWithValue("@Email", person.Email); // string
                cmd.Parameters.AddWithValue("@Github", person.Github); // string
                conn.Open(); // open connection
                cmd.ExecuteNonQuery(); // execute insert (non-query)
            }
        }

        // Update person
        public void UpdatePerson(PersonModel person) // returns void
        {
            using (var conn = GetConnection())
            {
                string query = "UPDATE Persons SET Age=@Age, Email=@Email, Github=@Github WHERE Name=@Name";
                var cmd = new SqliteCommand(query, conn);
                // add parameters
                cmd.Parameters.AddWithValue("@Name", person.Name); // string
                cmd.Parameters.AddWithValue("@Age", person.Age); // int
                cmd.Parameters.AddWithValue("@Email", person.Email); // string
                cmd.Parameters.AddWithValue("@Github", person.Github); // string
                conn.Open();
                cmd.ExecuteNonQuery(); // execute update
            }
        }

        // Delete person
        public void DeletePerson(string name) // returns void
        {
            using (var conn = GetConnection())
            {
                string query = "DELETE FROM Persons WHERE Name=@Name"; // delete query
                var cmd = new SqliteCommand(query, conn);
                cmd.Parameters.AddWithValue("@Name", name); // add name parameter
                conn.Open();
                cmd.ExecuteNonQuery(); // execute delete
            }
        }
    }
}
