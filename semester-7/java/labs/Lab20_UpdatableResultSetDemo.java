import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Lab 20: JDBC Updatable ResultSet
 * Advanced Java Programming / CSIT-7th Semester
 * 
 * Real JDBC Implementation:
 * - Create updatable ResultSet (TYPE_SCROLL_INSENSITIVE + CONCUR_UPDATABLE)
 * - Search for "Interstellar" movie
 * - Update genre field using updateString() and updateRow()
 */
public class Lab20_UpdatableResultSetDemo {
    
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
            
            // Display movies before update
            System.out.println("\n=== Before Update ===");
            displayAllMovies(conn);
            
            // Search and update Interstellar genre
            System.out.println("\n=== Searching and Updating ===");
            searchAndUpdateMovie(conn, "Interstellar", "fiction");
            
            // Display movies after update
            System.out.println("\n=== After Update ===");
            displayAllMovies(conn);
            
            System.out.println("\n--- Lab Information ---");
            System.out.println("Lab No.: 20");
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
            {"Interstellar", "Science Fiction"},
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
    
    // Search and update using updatable ResultSet
    static void searchAndUpdateMovie(Connection conn, String searchTitle, String newGenre) 
            throws SQLException {
        String sql = "SELECT id, title, genre FROM MOVIE";
        
        // Create UPDATABLE ResultSet
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);
        
        boolean found = false;
        
        while (rs.next()) {
            String currentTitle = rs.getString("title");
            
            if (currentTitle.equalsIgnoreCase(searchTitle)) {
                found = true;
                System.out.println("✓ Found movie: " + currentTitle);
                System.out.println("  Current genre: " + rs.getString("genre"));
                
                // Update the genre column
                rs.updateString("genre", newGenre);
                // Apply the update to database
                rs.updateRow();
                
                System.out.println("  Updated genre: " + newGenre);
                break;
            }
        }
        
        if (!found) {
            System.out.println("✗ Movie '" + searchTitle + "' not found");
        }
        
        rs.close();
        stmt.close();
    }
    
    // Display all movies
    static void displayAllMovies(Connection conn) throws SQLException {
        String sql = "SELECT id, title, genre FROM MOVIE ORDER BY id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        System.out.println("\nID | Title          | Genre");
        System.out.println("---+----------------+-----------------");
        
        while (rs.next()) {
            System.out.printf("%d  | %-14s | %s%n",
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("genre"));
        }
        
        rs.close();
        stmt.close();
    }
}
