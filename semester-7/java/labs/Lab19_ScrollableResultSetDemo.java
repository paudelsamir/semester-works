import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Lab 19: JDBC Scrollable ResultSet Navigation
 * Advanced Java Programming / CSIT-7th Semester
 * 
 * Real JDBC Implementation:
 * - Create scrollable ResultSet (TYPE_SCROLL_INSENSITIVE)
 * - Navigate to specific rows using absolute() and relative() methods
 * - Display rows from last, first, and third positions
 */
public class Lab19_ScrollableResultSetDemo {
    
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
            System.out.println("✓ Connected to database");
            
            // Create movies table
            createMoviesTable(conn);
            
            // Insert sample data
            insertMovies(conn);
            
            // Create Scrollable ResultSet
            System.out.println("\n=== Scrollable ResultSet Navigation ===\n");
            navigateResultSet(conn);
            
            System.out.println("\n--- Lab Information ---");
            System.out.println("Lab No.: 19");
            System.out.println("Name: Samir Paudel");
            System.out.println("Roll No./Section: 114-079/D");
            
        } catch (ClassNotFoundException e) {
            System.err.println("✗ JDBC Driver Error: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("✗ Database Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Create MOVIE table
    static void createMoviesTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        
        try {
            stmt.execute("DROP TABLE IF EXISTS MOVIE");
        } catch (SQLException e) {
            // Table may not exist
        }
        
        String createTable = "CREATE TABLE MOVIE (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "title VARCHAR(100) NOT NULL, " +
                "genre VARCHAR(50) NOT NULL" +
                ")";
        stmt.execute(createTable);
        System.out.println("✓ MOVIE table created");
        stmt.close();
    }
    
    // Insert movies
    static void insertMovies(Connection conn) throws SQLException {
        String sql = "INSERT INTO MOVIE (title, genre) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        Object[][] movies = {
            {"Inception", "Science Fiction"},
            {"Jatra", "Comedy"},
            {"Avatar", "Science Fiction"}
        };
        
        for (Object[] movie : movies) {
            pstmt.setString(1, (String) movie[0]);
            pstmt.setString(2, (String) movie[1]);
            pstmt.executeUpdate();
        }
        
        System.out.println("✓ " + movies.length + " Movies inserted");
        pstmt.close();
    }
    
    // Navigate through scrollable ResultSet
    static void navigateResultSet(Connection conn) throws SQLException {
        String sql = "SELECT id, title, genre FROM MOVIE";
        
        // Create statement with TYPE_SCROLL_INSENSITIVE for scrollable results
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Navigate to Last row
        System.out.println("1. Moving to LAST row:");
        rs.last();
        displayMovieRow(rs);
        
        // Navigate to First row
        System.out.println("\n2. Moving to FIRST row:");
        rs.first();
        displayMovieRow(rs);
        
        // Navigate to Third row
        System.out.println("\n3. Moving to row 3 (ABSOLUTE position):");
        if (rs.absolute(3)) {
            displayMovieRow(rs);
        } else {
            System.out.println("   Row 3 does not exist");
        }
        
        // Navigate relative
        System.out.println("\n4. All records from ResultSet:");
        rs.first();
        int count = 1;
        do {
            System.out.printf("   Row %d: ", count);
            displayMovieRow(rs);
            count++;
        } while (rs.next());
        
        // Get row count using last()
        int totalRows = rs.getRow();
        System.out.println("\nTotal rows in ResultSet: " + totalRows);
        
        rs.close();
        stmt.close();
    }
    
    // Helper method to display movie row
    static void displayMovieRow(ResultSet rs) throws SQLException {
        System.out.printf("ID=%d, Title=%s, Genre=%s%n",
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("genre"));
    }
}
