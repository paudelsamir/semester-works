import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Lab 18: JDBC Movie Management - JOIN with DIRECTOR table
 * Advanced Java Programming / CSIT-7th Semester
 * Real JDBC Implementation with SQL JOIN
 */
public class Lab18_JDBC_MovieTable {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/java_lab";
    static final String USER = "root";
    static final String PASS = "password";
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load JDBC Driver
            Class.forName(DRIVER);
            System.out.println("✓ JDBC Driver loaded");
            
            // Connect to database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("✓ Connected to database: " + DB_URL);
            
            // Create tables
            createTables(conn);
            
            // Insert Directors
            insertDirectors(conn);
            
            // Insert Movies
            insertMovies(conn);
            
            // Display all movies with directors (JOIN query)
            System.out.println("\n=== Movies with Directors (SQL JOIN) ===");
            displayMoviesWithDirectors(conn);
            
            // Update Jatra genre from Drama to Comedy
            System.out.println("\n=== Updating Jatra genre to Comedy ===");
            updateMovieGenre(conn, "Jatra", "Comedy");
            
            // Display updated records
            System.out.println("\n=== Updated Movie List ===");
            displayMoviesWithDirectors(conn);
            
            System.out.println("\n--- Lab Information ---");
            System.out.println("Lab No.: 18");
            System.out.println("Name: Samir Paudel");
            System.out.println("Roll No./Section: 114-079/D");
            
        } catch (ClassNotFoundException e) {
            System.err.println("✗ JDBC Driver Error: " + e.getMessage());
            System.out.println("  Please add mysql-connector-java JAR to classpath");
        } catch (SQLException e) {
            System.err.println("✗ Database Error: " + e.getMessage());
            System.out.println("  Ensure MySQL is running and database 'java_lab' exists");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("✓ Connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Create DIRECTOR and MOVIE tables with relationships
    static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        
        try {
            stmt.execute("DROP TABLE IF EXISTS MOVIE");
            stmt.execute("DROP TABLE IF EXISTS DIRECTOR");
            System.out.println("✓ Old tables dropped");
        } catch (SQLException e) {
            // Tables may not exist
        }
        
        // Create DIRECTOR table
        String createDirector = "CREATE TABLE DIRECTOR (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100) NOT NULL" +
                ")";
        stmt.execute(createDirector);
        System.out.println("✓ DIRECTOR table created");
        
        // Create MOVIE table with FOREIGN KEY constraint
        String createMovie = "CREATE TABLE MOVIE (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "title VARCHAR(100) NOT NULL, " +
                "genre VARCHAR(50) NOT NULL, " +
                "rating DOUBLE NOT NULL, " +
                "director_id INT NOT NULL, " +
                "FOREIGN KEY (director_id) REFERENCES DIRECTOR(id)" +
                ")";
        stmt.execute(createMovie);
        System.out.println("✓ MOVIE table created with foreign key");
        
        stmt.close();
    }
    
    // Insert directors into DIRECTOR table
    static void insertDirectors(Connection conn) throws SQLException {
        String sql = "INSERT INTO DIRECTOR (name) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        String[] directors = {"Anurag Kashyap", "Vikas Bahl", "James Cameron"};
        
        for (String director : directors) {
            pstmt.setString(1, director);
            pstmt.executeUpdate();
        }
        
        System.out.println("✓ " + directors.length + " Directors inserted");
        pstmt.close();
    }
    
    // Insert movies into MOVIE table
    static void insertMovies(Connection conn) throws SQLException {
        String sql = "INSERT INTO MOVIE (title, genre, rating, director_id) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        Object[][] movies = {
            {"Inception", "Science Fiction", 8.8, 3},
            {"Jatra", "Drama", 7.5, 1},
            {"Avatar", "Science Fiction", 7.8, 3}
        };
        
        for (Object[] movie : movies) {
            pstmt.setString(1, (String) movie[0]);
            pstmt.setString(2, (String) movie[1]);
            pstmt.setDouble(3, (Double) movie[2]);
            pstmt.setInt(4, (Integer) movie[3]);
            pstmt.executeUpdate();
        }
        
        System.out.println("✓ " + movies.length + " Movies inserted");
        pstmt.close();
    }
    
    // Display movies with directors using SQL JOIN
    static void displayMoviesWithDirectors(Connection conn) throws SQLException {
        String joinQuery = "SELECT m.id, m.title, m.genre, m.rating, d.name AS director_name " +
                "FROM MOVIE m " +
                "JOIN DIRECTOR d ON m.director_id = d.id " +
                "ORDER BY m.id";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(joinQuery);
        
        System.out.println("\nID | Title      | Genre              | Rating | Director");
        System.out.println("---+------------+--------------------+--------+-----------");
        
        while (rs.next()) {
            System.out.printf("%d  | %-10s | %-18s | %.1f   | %s%n",
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getDouble("rating"),
                    rs.getString("director_name"));
        }
        
        rs.close();
        stmt.close();
    }
    
    // Update movie genre using PreparedStatement
    static void updateMovieGenre(Connection conn, String title, String newGenre) throws SQLException {
        String sql = "UPDATE MOVIE SET genre = ? WHERE title = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newGenre);
        pstmt.setString(2, title);
        
        int rowsAffected = pstmt.executeUpdate();
        System.out.println("✓ " + rowsAffected + " record(s) updated");
        
        pstmt.close();
    }
}
