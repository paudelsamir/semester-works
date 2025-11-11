using Microsoft.Data.Sqlite; // namespace for sqlite database access
using Microsoft.Extensions.Configuration; // namespace for reading configuration (like connection strings)
using System.Collections.Generic;
using System;

namespace webAppDemo.Models
{
    public class PersonAddressDataAccess
    {
        private readonly string _connectionString; // stores the connection string for sqlite

        // constructor receives IConfiguration to get the connection string from appsettings.json
        public PersonAddressDataAccess(IConfiguration configuration)
        {
            _connectionString = configuration.GetConnectionString("TodoDbConnection"); // type: string
        }

        // helper method to create a new SqliteConnection object
        private SqliteConnection GetConnection() // returns SqliteConnection
        {
            return new SqliteConnection(_connectionString); // does not open yet, just constructs the object
        }

        // Get all PersonAddress entries
        public List<PersonAddressViewModel> GetAllPersonAddresses() // returns a list of PersonAddressViewModel objects
        {
            var personAddresses = new List<PersonAddressViewModel>(); // initialize empty list to store results
            using (var conn = GetConnection()) // creates a connection and disposes it automatically after use
            {
                string query = "SELECT * FROM PersonAddresses"; // SQL query string
                var cmd = new SqliteCommand(query, conn); // command object to execute query, type: SqliteCommand
                conn.Open(); // open the connection
                using (var reader = cmd.ExecuteReader()) // execute query and get a reader to loop through results
                {
                    while (reader.Read()) // loop through each row returned
                    {
                        personAddresses.Add(new PersonAddressViewModel // map database row to PersonAddressViewModel object
                        {
                            Person = new PersonModel
                            {
                                Name = reader["PersonName"].ToString() ?? "", // get string value of column "PersonName"
                                Age = reader.GetInt32(reader.GetOrdinal("Age")), // get integer value of column "Age"
                                Email = reader["Email"].ToString() ?? "", // get string value of column "Email", fallback to empty string
                                Github = reader["Github"].ToString() ?? "" // get string value of column "Github", fallback to empty string
                            },
                            Address = new AddressViewModel
                            {
                                City = reader["City"].ToString() ?? "", // get string value of column "City"
                                State = reader["State"].ToString() ?? "" // get string value of column "State"
                            }
                        });
                    }
                }
            }
            return personAddresses; // return the list of PersonAddressViewModel objects
        }

        // Get PersonAddress by person name
        public PersonAddressViewModel? GetPersonAddressByName(string name) // returns PersonAddressViewModel or null if not found
        {
            PersonAddressViewModel? personAddress = null; // initialize as null
            using (var conn = GetConnection())
            {
                string query = "SELECT * FROM PersonAddresses WHERE PersonName=@Name"; // SQL query with parameter
                var cmd = new SqliteCommand(query, conn); // command object
                cmd.Parameters.AddWithValue("@Name", name); // add parameter value to prevent SQL injection
                conn.Open();
                using (var reader = cmd.ExecuteReader()) // execute and get reader
                {
                    if (reader.Read()) // if a row exists
                    {
                        personAddress = new PersonAddressViewModel
                        {
                            Person = new PersonModel
                            {
                                Name = reader["PersonName"].ToString() ?? "",
                                Age = reader.GetInt32(reader.GetOrdinal("Age")),
                                Email = reader["Email"].ToString() ?? "",
                                Github = reader["Github"].ToString() ?? ""
                            },
                            Address = new AddressViewModel
                            {
                                City = reader["City"].ToString() ?? "",
                                State = reader["State"].ToString() ?? ""
                            }
                        };
                    }
                }
            }
            return personAddress; // return PersonAddressViewModel or null
        }

        // Create PersonAddress
        public void CreatePersonAddress(PersonAddressViewModel personAddress) // returns void
        {
            using (var conn = GetConnection())
            {
                string query = "INSERT INTO PersonAddresses (PersonName, Age, Email, Github, City, State) VALUES (@Name, @Age, @Email, @Github, @City, @State)";
                var cmd = new SqliteCommand(query, conn); // create command with insert query
                // add parameter values to command
                cmd.Parameters.AddWithValue("@Name", personAddress.Person.Name); // string
                cmd.Parameters.AddWithValue("@Age", personAddress.Person.Age); // int
                cmd.Parameters.AddWithValue("@Email", personAddress.Person.Email); // string
                cmd.Parameters.AddWithValue("@Github", personAddress.Person.Github); // string
                cmd.Parameters.AddWithValue("@City", personAddress.Address.City); // string
                cmd.Parameters.AddWithValue("@State", personAddress.Address.State); // string
                conn.Open(); // open connection
                cmd.ExecuteNonQuery(); // execute insert (non-query)
            }
        }

        // Update PersonAddress
        public void UpdatePersonAddress(PersonAddressViewModel personAddress) // returns void
        {
            using (var conn = GetConnection())
            {
                string query = "UPDATE PersonAddresses SET Age=@Age, Email=@Email, Github=@Github, City=@City, State=@State WHERE PersonName=@Name";
                var cmd = new SqliteCommand(query, conn);
                // add parameters
                cmd.Parameters.AddWithValue("@Name", personAddress.Person.Name); // string
                cmd.Parameters.AddWithValue("@Age", personAddress.Person.Age); // int
                cmd.Parameters.AddWithValue("@Email", personAddress.Person.Email); // string
                cmd.Parameters.AddWithValue("@Github", personAddress.Person.Github); // string
                cmd.Parameters.AddWithValue("@City", personAddress.Address.City); // string
                cmd.Parameters.AddWithValue("@State", personAddress.Address.State); // string
                conn.Open();
                cmd.ExecuteNonQuery(); // execute update
            }
        }

        // Delete PersonAddress
        public void DeletePersonAddress(string name) // returns void
        {
            using (var conn = GetConnection())
            {
                string query = "DELETE FROM PersonAddresses WHERE PersonName=@Name"; // delete query
                var cmd = new SqliteCommand(query, conn);
                cmd.Parameters.AddWithValue("@Name", name); // add name parameter
                conn.Open();
                cmd.ExecuteNonQuery(); // execute delete
            }
        }
    }
}
