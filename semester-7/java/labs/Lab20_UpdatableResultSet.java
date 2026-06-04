import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab20_UpdatableResultSet {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/movie_db";
    static final String USER = "root";
    static final String PASS = "password";
    
    public static void main(String[] args) {
        System.out.println("--- Updatable ResultSet ---");
        
        String sql = "SELECT * FROM MOVIE";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\nSearching for movie with title 'interstellar':");
            boolean found = false;
            
            while (rs.next()) {
                String title = rs.getString("title");
                System.out.println("Current row - ID: " + rs.getInt("id") +
                        ", Title: " + title +
                        ", Genre: " + rs.getString("genre"));
                
                if (title.equalsIgnoreCase("interstellar")) {
                    found = true;
                    System.out.println("\nFound 'interstellar' movie!");
                    
                    // Update genre directly through ResultSet
                    rs.updateString("genre", "fiction");
                    rs.updateRow();
                    
                    System.out.println("Updated genre to 'fiction'");
                    System.out.println("Updated row - ID: " + rs.getInt("id") +
                            ", Title: " + rs.getString("title") +
                            ", Genre: " + rs.getString("genre"));
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Movie 'interstellar' not found in database");
                System.out.println("\nAvailable movies:");
                rs.beforeFirst();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Title: " + rs.getString("title") +
                            ", Genre: " + rs.getString("genre"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 20");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
